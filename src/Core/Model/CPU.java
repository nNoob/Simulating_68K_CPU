package Core.Model;

/**
 * Created by Ahmed on 10/26/2016.
 */
public class CPU {

    private static final int MOVE = 0;
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int BRA = 3;
    private static final int CMP = 4;
    private static final int BEQ = 5;
    private static final int BNE = 6;
    private static final int EXG = 7;// Exg change the value of two registers
    private static final int STOP = 15;

    private static int PC = 0;                  // Program Counter
    private static int D0 = 0;                  // Data Reg
    private static int A0 = 0;                  // Address Reg
    private static int CCR = 0;                 // Condition Code Register (Flags)
    private static int MAR;                     // Memory Address Register
    private static int MBR;                     // Memory buffer register
    private static int IR;                      // Instruction Register
    private static int operand;                 // The 8-bit operand from IR
    private static int source;                  // source operand
    private static int destination;             // the destination value
    private static int opcode;                  // the 4-bit opCode
    private static int addressingMode;          // the 2-bit addressing mode
    private static int direction;               // the 1-bit direction flag
    private static int[] memory = new int[256]; // the memory
    private static int run = 1;


    /*
     * Instruction format :
     * 7 6 5 4 3 2 1 0
     * Bit 1 and 0 are the 2-bit address mode
     *                          00 absolute
     *                          01 literal
     *                          10 indexed
     *                          11 relative
     *
     * Bit 2        1-Bit direction ( source / operand )
     * Bit 3        not used
     * Bit 7 to 4   4-bit instruction code
     */
    void runProgram() {
        while (run == 1) {
            fetchInstruction();
            getSourceOperand();
            executeInstruction();
            saveInMemory();
        }
    }

    private void fetchInstruction() {
        //Get Op-Code
        MAR = PC;
        PC++;
        MBR = memory[MAR];
        IR = MBR;
        opcode = IR;
        // Handle Bits
        addressingMode = opcode & 0x03;
        direction = (opcode & 0x04) >> 2;
        opcode = opcode >> 4;

        //Get Operand
        MAR = PC;
        PC++;
        MBR = memory[MAR];
        IR = MBR;
        operand = IR;
    }

    private void getSourceOperand() {
        switch (addressingMode) {
            case 0:
                source = memory[operand];
                break;
            case 1:
                source = operand;
                break;
            case 2:
                source = memory[A0 + operand];
                break;
            case 3:
                source = memory[PC + operand];
                break;
            default:
                break;
        }
    }

    private void executeInstruction() {
        switch (opcode) {
            case MOVE: {
                if (direction == 0)
                    destination = D0;
                else
                    D0 = source;
                if (D0 == 0)
                    CCR = 1;
                else
                    CCR = 0;
                break;
            }
            case ADD: {
                if (direction == 0) {
                    destination = D0 + source;
                    if (destination == 0) CCR = 1;
                    else CCR = 0;
                } else {
                    D0 = D0 + source;
                    if (D0 == 0) CCR = 1;
                    else CCR = 0;
                }
                break;
            }
            case SUB: {
                if (direction == 0) {
                    destination = D0 - source;
                    if (destination == 0) CCR = 1;
                    else CCR = 0;
                } else {
                    D0 = D0 - source;
                    if (D0 == 0) CCR = 1;
                    else CCR = 0;
                }
                break;
            }
            case BRA: {
                if (addressingMode == 0) PC = operand;
                if (addressingMode == 1) PC = PC + operand;
                break;
            }
            case CMP: {
                MBR = D0 - source;
                if (MBR == 0) CCR = 1;
                else CCR = 0;
                break;
            }
            case BEQ: {
                if (CCR == 1) {
                    if (addressingMode == 0) PC = operand;
                    if (addressingMode == 1) PC = PC + operand;
                }
                break;
            }
            case BNE: {
                if (CCR != 1) {
                    if (addressingMode == 0) PC = operand;
                    if (addressingMode == 1) PC = PC + operand;
                }
                break;
            }
            case EXG: {
                MBR = D0;
                D0 = A0;
                A0 = MBR;
                break;
            }
            case STOP: {
                run = 0;
                break;
            }
        }
    }

    private void saveInMemory() {
        if (direction == 0) {
            switch (addressingMode) {
                case 0: //Absolute
                    memory[operand] = destination;
                    break;
                case 1: //Literal
                    break;
                case 2: //Indexed
                    memory[A0 + operand] = destination;
                    break;
                case 3: //Relative
                    memory[PC + operand] = destination;
                    break;
            }
        }
    }
}

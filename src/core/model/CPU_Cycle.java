package core.model;

import static core.model.CPU_Model.*;

/**
 * Created by Ahmed on 11/22/2016.
 */
public class CPU_Cycle {

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

    private static final int MOVE = 0;
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int BRA = 3;
    private static final int CMP = 4;
    private static final int BEQ = 5;
    private static final int BNE = 6;
    private static final int EXG = 7;// Exg change the value of two registers
    private static final int STOP = 15;

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
        mar = pc;
        pc++;
        mbr = memory[mar];
        ir = mbr;
        opcode = ir;
        // Handle Bits
        addressingMode = opcode & 0x03;
        direction = (opcode & 0x04) >> 2;
        opcode = opcode >> 4;

        //Get Operand
        mar = pc;
        pc++;
        mbr = memory[mar];
        ir = mbr;
        operand = ir;
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
                source = memory[a0 + operand];
                break;
            case 3:
                source = memory[pc + operand];
                break;
            default:
                break;
        }
    }

    private void executeInstruction() {
        switch (opcode) {
            case MOVE: {
                if (direction == 0)
                    destination = d0;
                else
                    d0 = source;
                if (d0 == 0)
                    ccr = 1;
                else
                    ccr = 0;
                break;
            }
            case ADD: {
                if (direction == 0) {
                    destination = d0 + source;
                    if (destination == 0) ccr = 1;
                    else ccr = 0;
                } else {
                    d0 = d0 + source;
                    if (d0 == 0) ccr = 1;
                    else ccr = 0;
                }
                break;
            }
            case SUB: {
                if (direction == 0) {
                    destination = d0 - source;
                    if (destination == 0) ccr = 1;
                    else ccr = 0;
                } else {
                    d0 = d0 - source;
                    if (d0 == 0) ccr = 1;
                    else ccr = 0;
                }
                break;
            }
            case BRA: {
                if (addressingMode == 0) pc = operand;
                if (addressingMode == 1) pc = pc + operand;
                break;
            }
            case CMP: {
                mbr = d0 - source;
                if (mbr == 0) ccr = 1;
                else ccr = 0;
                break;
            }
            case BEQ: {
                if (ccr == 1) {
                    if (addressingMode == 0) pc = operand;
                    if (addressingMode == 1) pc = pc + operand;
                }
                break;
            }
            case BNE: {
                if (ccr != 1) {
                    if (addressingMode == 0) pc = operand;
                    if (addressingMode == 1) pc = pc + operand;
                }
                break;
            }
            case EXG: {
                mbr = d0;
                d0 = a0;
                a0 = mbr;
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
                    memory[a0 + operand] = destination;
                    break;
                case 3: //Relative
                    memory[pc + operand] = destination;
                    break;
            }
        }
    }
}

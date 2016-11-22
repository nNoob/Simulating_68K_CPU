package core.model;

import java.util.ArrayList;

/**
 * Created by Ahmed on 11/22/2016.
 */
public class CPU implements Processor{

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

    private Instruction inst;
    private CPUData data;
    private int source;
    private int destination;
    private boolean isRunning;

    public CPU() {
        inst = new Instruction();
        data = new CPUData();
        source = 0;
        destination = 0;
        isRunning = true;
    }

    private void fetchInstruction() {
        //Get Op-Code
        data.MAR = data.PC;
        data.PC = data.PC + 1;
        data.MBR = data.memory[data.MAR];
        data.IR = data.MBR;

        // parse the opCode and extract bits
        inst.parseOpCode(data.IR);

        // fetch operand
        data.MAR = data.PC;
        data.PC = data.PC + 1;
        data.MBR = data.memory[data.MAR];
        data.IR = data.MBR;
        inst.operand = data.IR;
    }

    private void getSourceOperand(int addressingMode) {
        switch (addressingMode) {
            case 0:
                source = data.memory[inst.operand];
                break;
            case 1:
                source = inst.operand;
                break;
            case 2:
                source = data.memory[data.A0 + inst.operand];
                break;
            case 3:
                source = data.memory[data.PC + inst.operand];
                break;
            default:
                break;
        }
    }

    private void executeInstruction(Instruction instruction) {
        int oc = instruction.opcode;
        if (oc == OpCodes.MOVE.getValue()) {

            if (instruction.direction == 0)
                destination = data.D0;
            else
                data.D0 = source;
            if (data.D0 == 0)
                data.CCR = 1;
            else
                data.CCR = 0;

        } else if (oc == OpCodes.ADD.getValue()) {
                if (instruction.direction == 0) {
                    destination = data.D0 + source;
                    if (destination == 0)
                        data.CCR = 1;
                    else
                        data.CCR = 0;
                } else {
                    data.D0 = data.D0 + source;

                    if (data.D0 == 0)
                        data.CCR = 1;
                    else
                        data.CCR = 0;
                }
        } else if(oc == OpCodes.SUB.getValue()) {
                if (instruction.direction == 0) {
                    destination = data.D0 - source;
                    if (destination == 0)
                        data.CCR = 1;
                    else
                        data.CCR = 0;
                } else {
                    data.D0 = data.D0 - source;
                    if (data.D0 == 0)
                        data.CCR = 1;
                    else
                        data.CCR = 0;
                }
        } else if(oc == OpCodes.BRA.getValue()) {
                if (instruction.addressingMode == 0)
                    data.PC = instruction.operand;
                if (instruction.addressingMode == 1) data.PC = data.PC + instruction.operand;
        } else if(oc == OpCodes.CMP.getValue()) {
                data.MBR = data.D0 - source;
                if (data.MBR == 0)
                    data.CCR = 1;
                else
                    data.CCR = 0;
        } else if(oc == OpCodes.BEQ.getValue()) {
                if (data.CCR == 1) {
                    if (instruction.addressingMode == 0)
                        data.PC = instruction.operand;
                    if (instruction.addressingMode == 1)
                        data.PC = data.PC + instruction.operand;
                }
        } else if(oc == OpCodes.BNE.getValue()) {
                if (data.CCR != 1) {
                    if (instruction.addressingMode == 0) data.PC = instruction.operand;
                    if (instruction.addressingMode == 1) data.PC = data.PC + instruction.operand;
                }
        } else if(oc == OpCodes.EXG.getValue()) {
                data.MBR = data.D0;
                data.D0 = data.A0;
                data.A0 = data.MBR;
        } else if(oc == OpCodes.STOP.getValue()) {
                isRunning = false;
        }

    }

    private void saveInMemory() {
        if (inst.direction == 0) {

            switch (inst.addressingMode) {
                case 0: //Absolute
                    data.memory[inst.operand] = destination;
                    break;
                case 1: //Literal
                    break;
                case 2: //Indexed
                    data.memory[data.A0 + inst.operand] = destination;
                    break;
                case 3: //Relative
                    data.memory[data.PC + inst.operand] = destination;
                    break;
            }
        }
    }

    public void loadProgram(int[] code, int startingAddress) {
        int codeLength = code.length;

        if(codeLength + startingAddress > 255) {
            throw new ArrayIndexOutOfBoundsException("No enough memory space for code");
        }

        for(int i = 0; i < codeLength; i++) {
            data.memory[i+startingAddress] = code[i];
        }
    }

    public String fetch() {
        if(!isRunning)
            return null;

        fetchInstruction();
        String fetchedInst = Integer.toBinaryString(inst.opcode) + Integer.toBinaryString(inst.operand);
        return fetchedInst;
    }

    public void execute() {
        executeInstruction(inst);

    }

    public CPUData getData() {
        // return a copy of the original CPU data
        return new CPUData(data);
    }

    public void resetCPUData() {
        data.resetData();
    }

}

package core.model;

/*
 * Created by Ahmed on 10/26/2016.
 */
public class CPU_Model {


    private static final int MOVE = 0;
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int BRA = 3;
    private static final int CMP = 4;
    private static final int BEQ = 5;
    private static final int BNE = 6;
    private static final int EXG = 7;// Exg change the value of two registers
    private static final int STOP = 15;


    static int pc = 0;                  // Program Counter
    static int d0 = 0;                  // Data Reg
    static int a0 = 0;                  // Address Reg
    static int ccr = 0;                 // Condition Code Register (Flags)
    static int mar;                     // Memory Address Register
    static int mbr;                     // Memory buffer register
    static int ir;                      // Instruction Register
    static int operand;                 // The 8-bit operand from ir
    static int source;                  // source operand
    static int destination;             // the destination value
    static int opcode;                  // the 4-bit opCode
    static int addressingMode;          // the 2-bit addressing mode
    static int direction;               // the 1-bit direction flag
    static int[] memory = new int[256]; // the memory
    static int run = 1;


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

    public static int getPc() {
        return pc;
    }

    public static void setPc(int pc) {
        CPU_Model.pc = pc;
    }

    public static int getD0() {
        return d0;
    }

    public static void setD0(int d0) {
        CPU_Model.d0 = d0;
    }

    public static int getA0() {
        return a0;
    }

    public static void setA0(int a0) {
        CPU_Model.a0 = a0;
    }

    public static int getCcr() {
        return ccr;
    }

    public static void setCcr(int ccr) {
        CPU_Model.ccr = ccr;
    }

    public static int getMar() {
        return mar;
    }

    public static void setMar(int mar) {
        CPU_Model.mar = mar;
    }

    public static int getMbr() {
        return mbr;
    }

    public static void setMbr(int mbr) {
        CPU_Model.mbr = mbr;
    }

    public static int getIr() {
        return ir;
    }

    public static void setIr(int ir) {
        CPU_Model.ir = ir;
    }

    public static int getOperand() {
        return operand;
    }

    public static void setOperand(int operand) {
        CPU_Model.operand = operand;
    }

    public static int getSource() {
        return source;
    }

    public static void setSource(int source) {
        CPU_Model.source = source;
    }

    public static int getDestination() {
        return destination;
    }

    public static void setDestination(int destination) {
        CPU_Model.destination = destination;
    }

    public static int getOpcode() {
        return opcode;
    }

    public static void setOpcode(int opcode) {
        CPU_Model.opcode = opcode;
    }

    public static int getAddressingMode() {
        return addressingMode;
    }

    public static void setAddressingMode(int addressingMode) {
        CPU_Model.addressingMode = addressingMode;
    }

    public static int getDirection() {
        return direction;
    }

    public static void setDirection(int direction) {
        CPU_Model.direction = direction;
    }

    public static int[] getMemory() {
        return memory;
    }

    public static void setMemory(int[] memory) {
        CPU_Model.memory = memory;
    }
}

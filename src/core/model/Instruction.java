package core.model;

/**
 * Created by abdelrahman on 11/22/16.
 */
public class Instruction {
    public int opcode;                  // the 4-bit opCode
    public int operand;                 // The 8-bit operand from ir
    public int addressingMode;          // the 2-bit addressing mode
    public int direction;               // the 1-bit direction flag

    public void parseOpCode(int opCode) {

        // extract Bits
        addressingMode = opcode & 0x03;
        direction = (opcode & 0x04) >> 2;
        this.opcode = opCode >> 4;
    }

}

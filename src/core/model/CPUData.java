package core.model;

/*
 * Created by Ahmed on 10/26/2016.
 */
public class CPUData {

    public int PC = 0;                  // Program Counter
    public int D0 = 0;                  // Data Reg
    public int A0 = 0;                  // Address Reg
    public int CCR = 0;                 // Condition Code Register (Flags)
    public int MAR;                     // Memory Address Register
    public int MBR;                     // Memory buffer register
    public int IR;                      // Instruction Register
    public int[] memory = new int[256]; // the memory

    public CPUData(){

    }

    public CPUData(int PC, int D0, int A0, int CCR, int MAR, int MBR, int IR, int[] memory){
        this.PC = PC;
        this.D0 = D0;
        this.A0 = A0;
        this.CCR = CCR;
        this.MAR = MAR;
        this.MBR = MBR;
        this.IR = IR;
        this.memory = memory;
    }

}

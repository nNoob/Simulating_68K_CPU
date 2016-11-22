package core.model;

/*
 * Created by Ahmed on 10/26/2016.
 */
public class CPUData implements Cloneable{

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

    /* Copy Constructor */
    public CPUData(CPUData another){
        this.PC = another.PC;
        this.D0 = another.D0;
        this.A0 = another.A0;
        this.CCR = another.CCR;
        this.MAR = another.MAR;
        this.MBR = another.MBR;
        this.IR = another.IR;
        this.memory = another.memory;
    }

    public void resetData() {
        this.PC = 0;
        this.D0 = 0;
        this.A0 = 0;
        this.CCR = 0;
        this.MAR = 0;
        this.MBR = 0;
        this.IR = 0;
        this.memory = new int[256];
    }

}

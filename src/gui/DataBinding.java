package gui;

public class DataBinding {
    private String pc;
    private String mar;
    private String d0;
    private String a0;
    private String addressingMode;
    private String opCode;
    private String mbr;
    private String ccr;
    private String source;
    private String operand;

    public DataBinding() {
    }

    public String getPC() {
        return pc;
    }

    public void setPC(final String pc) {
        this.pc = pc;
    }

    public String getMAR() {
        return mar;
    }

    public void setMAR(final String mar) {
        this.mar = mar;
    }

    public String getD0() {
        return d0;
    }

    public void setD0(final String d0) {
        this.d0 = d0;
    }

    public String getA0() {
        return a0;
    }

    public void setA0(final String a0) {
        this.a0 = a0;
    }

    public String getAddressingMode() {
        return addressingMode;
    }

    public void setAddressingMode(final String addressingMode) {
        this.addressingMode = addressingMode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(final String opCode) {
        this.opCode = opCode;
    }

    public String getMBR() {
        return mbr;
    }

    public void setMBR(final String mbr) {
        this.mbr = mbr;
    }

    public String getCCR() {
        return ccr;
    }

    public void setCCR(final String ccr) {
        this.ccr = ccr;
    }

    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(final String operand) {
        this.operand = operand;
    }
}
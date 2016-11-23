package gui;

public class DataBinding {
    private String pc;
    private String mar;
    private String d0;
    private String a0;
    private String aMode;
    private String opCode;
    private String mbr;
    private String ccr;
    private String source;
    private String operand;
    private String instructionAddress;
    private String editAddress;
    private String editValue;
    private String newInstOpCode;
    private String newInstAMode;
    private String newInstOperand;
    private String newInstSource;
    private String newInstDirection;


    public String getNewInstOpCode() {
        return newInstOpCode;
    }

    public void setNewInstOpCode(String newInstOpCode) {
        this.newInstOpCode = newInstOpCode;
    }

    public String getNewInstAMode() {
        return newInstAMode;
    }

    public void setNewInstAMode(String newInstAMode) {
        this.newInstAMode = newInstAMode;
    }

    public String getNewInstOperand() {
        return newInstOperand;
    }

    public void setNewInstOperand(String newInstOperand) {
        this.newInstOperand = newInstOperand;
    }

    public String getNewInstSource() {
        return newInstSource;
    }

    public void setNewInstSource(String newInstSource) {
        this.newInstSource = newInstSource;
    }

    public String getNewInstDirection() {
        return newInstDirection;
    }

    public void setNewInstDirection(String newInstDirection) {
        this.newInstDirection = newInstDirection;
    }

    public String getNewInstMemoryAddress() {
        return newInstMemoryAddress;
    }

    public void setNewInstMemoryAddress(String newInstMemoryAddress) {
        this.newInstMemoryAddress = newInstMemoryAddress;
    }

    private String newInstMemoryAddress;

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

    public String getaMode() {
        return aMode;
    }

    public void setaMode(final String aMode) {
        this.aMode = aMode;
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

    public String getInstructionAddress() {
        return instructionAddress;
    }

    public void setInstructionAddress(final String instructionAddress) {
        this.instructionAddress = instructionAddress;
    }

    public String getEditAddress() {
        return editAddress;
    }

    public void setEditAddress(final String editAddress) {
        this.editAddress = editAddress;
    }

    public String getEditValue() {
        return editValue;
    }

    public void setEditValue(final String editValue) {
        this.editValue = editValue;
    }
}
package gui;

import javax.swing.table.DefaultTableModel;

public class DataBinding {
    // Monitor
    private String PC;
    private String MAR;
    private String D0;
    private String A0;
    private String aMode;
    private String opCode;
    private String MBR;
    private String CCR;

    public String getPC() {
        return PC;
    }

    public void setPC(String pc) {
        this.PC = pc;
    }

    public String getMAR() {
        return MAR;
    }

    public void setMAR(String MAR) {
        this.MAR = MAR;
    }

    public String getD0() {
        return D0;
    }

    public void setD0(String d0) {
        this.D0 = d0;
    }

    public String getA0() {
        return A0;
    }

    public void setA0(String a0) {
        this.A0 = a0;
    }

    public String getaMode() {
        return aMode;
    }

    public void setaMode(String aMode) {
        this.aMode = aMode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getMBR() {
        return MBR;
    }

    public void setMBR(String MBR) {
        this.MBR = MBR;
    }

    public String getCCR() {
        return CCR;
    }

    public void setCCR(String CCR) {
        this.CCR = CCR;
    }


    // Manage Memory Panel


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
    private DefaultTableModel memoryTableModel;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getInstructionAddress() {
        return instructionAddress;
    }

    public void setInstructionAddress(String instructionAddress) {
        this.instructionAddress = instructionAddress;
    }

    public String getEditAddress() {
        return editAddress;
    }

    public void setEditAddress(String editAddress) {
        this.editAddress = editAddress;
    }

    public String getEditValue() {
        return editValue;
    }

    public void setEditValue(String editValue) {
        this.editValue = editValue;
    }

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

    public DefaultTableModel getMemoryTableModel() {
        return memoryTableModel;
    }

    public void setMemoryTableModel(DefaultTableModel memoryTableModel) {
        this.memoryTableModel = memoryTableModel;
    }
}
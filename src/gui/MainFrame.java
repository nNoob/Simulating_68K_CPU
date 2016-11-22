package gui;

import javax.swing.*;

/*
 * Created by Ahmed on 10/26/2016.
 */
public class MainFrame {
    private JPanel mainPanel;
    private JTable memoryTable;
    private JTextField PCtextField;
    private JTextField MARtextField;
    private JTextField D0textField;
    private JTextField A0textField;
    private JTextField aModeTextField;
    private JTextField opCodeTextField;
    private JTextField MBRtextField;
    private JTextField CCRtextField;
    private JComboBox operationComboBox;
    private JComboBox aModeComboBox;
    private JComboBox directionComboBox;
    private JButton makeButton;
    private JTextField sourceTextField;
    private JTextField operandTextField;


    private MainFrame() {
        createUIComponents();
    }

    private static MainFrame frame = null;

    public static JPanel getMainPanel() {
        if (frame == null)
            return (frame = new MainFrame()).mainPanel;
        return frame.mainPanel;
    }

    private void createUIComponents() {
        // TODO: DO SOME SHIT ! ! !
    }

    // set data to gui
    public void setData(DataBinding data) {
        PCtextField.setText(data.getPC());
        MARtextField.setText(data.getMAR());
        aModeTextField.setText(data.getAddressingMode());
        opCodeTextField.setText(data.getOpCode());
        MBRtextField.setText(data.getMBR());
        CCRtextField.setText(data.getCCR());
        sourceTextField.setText(data.getSource());
        operandTextField.setText(data.getOperand());
    }

    // get data from gui
    public void getData(DataBinding data) {
        data.setPC(PCtextField.getText());
        data.setMAR(MARtextField.getText());
        data.setAddressingMode(aModeTextField.getText());
        data.setOpCode(opCodeTextField.getText());
        data.setMBR(MBRtextField.getText());
        data.setCCR(CCRtextField.getText());
        data.setSource(sourceTextField.getText());
        data.setOperand(operandTextField.getText());
    }


    // observe modifications
    public boolean isModified(DataBinding data) {
        if (PCtextField.getText() != null ? !PCtextField.getText().equals(data.getPC()) : data.getPC() != null)
            return true;
        if (MARtextField.getText() != null ? !MARtextField.getText().equals(data.getMAR()) : data.getMAR() != null)
            return true;
        if (aModeTextField.getText() != null ? !aModeTextField.getText().equals(data.getAddressingMode()) : data.getAddressingMode() != null)
            return true;
        if (opCodeTextField.getText() != null ? !opCodeTextField.getText().equals(data.getOpCode()) : data.getOpCode() != null)
            return true;
        if (MBRtextField.getText() != null ? !MBRtextField.getText().equals(data.getMBR()) : data.getMBR() != null)
            return true;
        if (CCRtextField.getText() != null ? !CCRtextField.getText().equals(data.getCCR()) : data.getCCR() != null)
            return true;
        if (sourceTextField.getText() != null ? !sourceTextField.getText().equals(data.getSource()) : data.getSource() != null)
            return true;
        if (operandTextField.getText() != null ? !operandTextField.getText().equals(data.getOperand()) : data.getOperand() != null)
            return true;
        return false;
    }
}

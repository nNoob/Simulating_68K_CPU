package gui;

import javax.swing.*;

/*
 * Created by Ahmed on 10/26/2016.
 */
public class MainFrame extends JFrame {
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
    private JTextField newSourceTextField;
    private JTextField newOperandTextField;
    private JTextField newInstructionAddressTextField;
    private JButton executeNextButton;
    private JButton writeButton;
    private JTextField editAddressTextField;
    private JTextField editValueTextField;
    private FrameListener frameListener;
    DataBinding dataBinding;

    public void registerAsListener(FrameListener fl) {
        this.frameListener = fl;
    }

    public MainFrame() {
        super();
        makeButton.setName("make");
        writeButton.setName("write");
        executeNextButton.setName("execute");


        makeButton.addActionListener(e -> {
            int[] ar = new int[1];
            // TODO: transform the instruction builded into an integer
            // TODO: and pass it to the method below
            //

            //
            frameListener.loadProgramRequested(ar, Integer.parseInt(newInstructionAddressTextField.getText()));
        });

        writeButton.addActionListener(e -> {
            // TODO: pass the function below the proper arguements
            int ar[] = new int[1];
            ar[0] = Integer.parseInt(editValueTextField.getText());
            frameListener.loadProgramRequested(ar, Integer.parseInt(editAddressTextField.getText()));
        });
        executeNextButton.addActionListener(e -> frameListener.nextStepRequested());
    }

    private static MainFrame frame = new MainFrame();

    public static MainFrame getInstance() {
        return frame;
    }

    public static JPanel getMainPanel() {
        return frame.mainPanel;
    }


    public void setData(DataBinding data) {
        dataBinding = data;
        PCtextField.setText(data.getPC());
        MARtextField.setText(data.getMAR());
        aModeTextField.setText(data.getaMode());
        opCodeTextField.setText(data.getOpCode());
        MBRtextField.setText(data.getMBR());
        CCRtextField.setText(data.getCCR());
    }

    public void getData(DataBinding data) {
        // Manage memory panel
        data.setNewInstOpCode((String) operationComboBox.getSelectedItem());
        data.setNewInstDirection((String) directionComboBox.getSelectedItem());
        data.setNewInstAMode((String) aModeComboBox.getSelectedItem());
        data.setSource(newSourceTextField.getText());
        data.setOperand(newOperandTextField.getText());
        data.setInstructionAddress(newInstructionAddressTextField.getText());
        data.setEditAddress(editAddressTextField.getText());
        data.setEditValue(editValueTextField.getText());
    }


    public boolean isModified(DataBinding data) {
        if (PCtextField.getText() != null ? !PCtextField.getText().equals(data.getPC()) : data.getPC() != null)
            return true;
        if (MARtextField.getText() != null ? !MARtextField.getText().equals(data.getMAR()) : data.getMAR() != null)
            return true;
        if (aModeTextField.getText() != null ? !aModeTextField.getText().equals(data.getaMode()) : data.getaMode() != null)
            return true;
        if (opCodeTextField.getText() != null ? !opCodeTextField.getText().equals(data.getOpCode()) : data.getOpCode() != null)
            return true;
        if (MBRtextField.getText() != null ? !MBRtextField.getText().equals(data.getMBR()) : data.getMBR() != null)
            return true;
        if (CCRtextField.getText() != null ? !CCRtextField.getText().equals(data.getCCR()) : data.getCCR() != null)
            return true;
        if (newSourceTextField.getText() != null ? !newSourceTextField.getText().equals(data.getSource()) : data.getSource() != null)
            return true;
        if (newOperandTextField.getText() != null ? !newOperandTextField.getText().equals(data.getOperand()) : data.getOperand() != null)
            return true;
        if (newInstructionAddressTextField.getText() != null ? !newInstructionAddressTextField.getText().equals(data.getInstructionAddress()) : data.getInstructionAddress() != null)
            return true;
        if (editAddressTextField.getText() != null ? !editAddressTextField.getText().equals(data.getEditAddress()) : data.getEditAddress() != null)
            return true;
        if (editValueTextField.getText() != null ? !editValueTextField.getText().equals(data.getEditValue()) : data.getEditValue() != null)
            return true;
        return false;
    }
}

package GUI;

import javax.swing.*;

/**
 * Created by Ahmed on 10/26/2016.
 */
public class mainFrame {
    private JPanel mainPanel;
    private JTable memoryTable;
    private JTextField PCtextField;
    private JTextField MARtextField;
    private JTextField D0textField;
    private JTextField A0textField;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField MBRtextField;
    private JTextField CCRtextField;


    private mainFrame() {
        createUIComponents();
    }

    private static mainFrame frame = null;

    public static JPanel getMainPanel() {
        if (frame == null)
            return (frame = new mainFrame()).mainPanel;
        return frame.mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

// RANDOM SHIT
//        // just for testing
//        DefaultTableModel defaultTableModel = new DefaultTableModel();
//        defaultTableModel.addColumn("Index");
//        defaultTableModel.addColumn("Data");
//        String data[][] = new String[256][2];
//        for (int i = 0; i < 256; i++) {
//            memory[i] = (15 << 4);
//            defaultTableModel.addRow(new String[]{Integer.toString(i + 1), Integer.toString(memory[i])});
//        }
//        memoryTable.setModel(defaultTableModel);
//        // end of testing
    }


}

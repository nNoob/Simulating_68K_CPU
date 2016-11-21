package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static Core.Model.CPU.memory;

/**
 * Created by Ahmed on 10/26/2016.
 */
public class mainFrame {
    private JPanel mainPanel;
    private JTextField PCtextField;
    private JTextField MARtextField;
    private JTable memoryTable;
    private JTextField MBRtextField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField D0textField;
    private JTextField A0textField;
    private JTextField CCRtextField;


    private mainFrame() {
    }

    private static mainFrame frame = null;

    private static JPanel getMainPanel() {
        if (frame == null)
            return (frame = new mainFrame()).mainPanel;
        return frame.mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        // just for testing
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Index");
        defaultTableModel.addColumn("Data");
        String data[][] = new String[memory.length][2];
        for (int i = 0; i < 265; i++) {
            data[i] = new String[]{Integer.toString(i + 1), Integer.toString(memory[i])};
            defaultTableModel.addRow(data[i]);
        }
        memoryTable.setModel(defaultTableModel);
        // end of testing
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("mainFrame");
        frame.setContentPane(getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

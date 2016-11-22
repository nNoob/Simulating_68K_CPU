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
// RANDOM SHIT REMOVED !!!
    }


}

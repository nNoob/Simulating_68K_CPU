package Core.Controller;

import javax.swing.*;

import static GUI.mainFrame.getMainPanel;

/**
 * Created by Ahmed on 11/22/2016.
 */
public class Main {
    static void setUIFlavour() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setUIFlavour();
        JFrame frame = new JFrame("mainFrame");
        frame.setContentPane(getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

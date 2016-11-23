package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ahmed on 11/23/2016.
 */
public class Listener implements ActionListener {
    MainFrame mainFrame = MainFrame.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        String operation = ((JButton) (e.getSource())).getName();

    }

    void respondToAction(DataBinding data, String operation) {
        switch (operation) {
            case "make":
                mainFrame.getData(data);
                break;
            case "write":
                mainFrame.setData(data);
                break;
            case "execute":
                mainFrame.getData(data);
                break;
            default:
                break;
        }
    }

    void Error(String errorMsg) {
        JOptionPane.showMessageDialog(null, errorMsg);
    }

    int makeButtonAction(DataBinding data) {
        int instruction = 0;
        int opCode = Integer.getInteger(data.getNewInstAMode());
        int aMode = Integer.getInteger(data.getNewInstAMode());
        int direction = Integer.getInteger(data.getNewInstDirection());

        instruction |= (opCode << 4);
        instruction |= aMode;
        instruction |= (direction << 2);
        return instruction;
    }

    void writeButtonAction(DataBinding data) {

    }

    void executeNextButtonAction(DataBinding data) {

    }
}

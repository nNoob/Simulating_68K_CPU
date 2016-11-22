package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ahmed on 11/23/2016.
 */
public class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String operation = ((JButton) (e.getSource())).getName();

    }

    void respondToAction(DataBinding data, String operation) {
        MainFrame mainFrame = MainFrame.getInstance();
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

}

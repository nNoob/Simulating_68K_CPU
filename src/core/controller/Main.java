package core.controller;

import core.model.CPU;
import gui.MainFrame;

import javax.swing.*;

import static gui.MainFrame.getMainPanel;

/*
 * Created by Ahmed on 11/22/2016.
 */
public class Main {

    private static void setUIFlavour() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setUIFlavour();
        MainFrame frame = new MainFrame();
        frame.setContentPane(getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        CPU cpu = new CPU();

        Controller appController = new Controller(frame, cpu);
        frame.registerAsListener(appController);

    }
}

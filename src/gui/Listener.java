package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Created by Ahmed on 11/23/2016.
 */
public class Listener implements ActionListener {
    DataBinding dataBinding;

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = ((JButton) (e.getSource())).getName();

    }

    int makeButtonAction(DataBinding dataBinding) {
        int instruction = (getOpCode(dataBinding.getOpCode()) << 4);
        instruction |= getAMode(dataBinding.getNewInstAMode());
        instruction |= getDirection(dataBinding.getNewInstDirection()) << 2;
        return instruction;
    }

    private int getOpCode(String opCode) {
        switch (opCode) {
            case "MOVE":
                return 0;
            case "ADD":
                return 1;
            case "SUB":
                return 2;
            case "BRA":
                return 3;
            case "CMP":
                return 4;
            case "BEQ":
                return 5;
            case "BNE":
                return 6;
            case "EXG":
                return 7;
            case "STOP":
                return 15;
        }
        //Return stop
        return 15;
    }

    private int getAMode(String aMode) {
        return Integer.getInteger(aMode);
    }

    private int getDirection(String direction) {
        return Integer.getInteger(direction);
    }

}

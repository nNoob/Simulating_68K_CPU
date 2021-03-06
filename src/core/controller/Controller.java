package core.controller;

import core.model.CPU;
import core.model.CPUData;
import gui.DataBinding;
import gui.FrameListener;
import gui.MainFrame;


/*
 * Created by Ahmed on 11/22/2016.
 */

public class Controller implements FrameListener {

    private CPU cpu;
    private MainFrame mainFrame;
    private DataBinding dataBinding;

    public Controller(MainFrame mainFrame, CPU cpu) {
        this.cpu = cpu;
        this.mainFrame = mainFrame;
        dataBinding = new DataBinding();
    }

    @Override
    public void nextStepRequested() {
        if (cpu.getState() == CPU.State.STOPPED)
            return;
        else if (cpu.getState() == CPU.State.EXECUTED)
            cpu.fetch();
        else if (cpu.getState() == CPU.State.FETCHED)
            cpu.execute();

        fillBindingData(cpu.getData(), dataBinding);

        mainFrame.setData(dataBinding);
    }

    @Override
    public void loadProgramRequested(int[] code, int startingAddress) {
        cpu.loadProgram(code, startingAddress);

        fillBindingData(cpu.getData(), dataBinding);
        mainFrame.setData(dataBinding);
    }

    private void fillBindingData(CPUData cpuData, DataBinding currentInstance) {
        currentInstance.setA0(cpuData.A0 + "");
        currentInstance.setCCR(cpuData.CCR + "");
        currentInstance.setD0(cpuData.D0 + "");
        currentInstance.setMAR(cpuData.MAR + "");
        currentInstance.setMBR(cpuData.MBR + "");
        currentInstance.setPC(cpuData.PC + "");
        currentInstance.setInstructionAddress(cpuData.IR + "");
        currentInstance.setOpCode(cpuData.IR + "");
    }
}

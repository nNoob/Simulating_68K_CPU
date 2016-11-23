package gui;

/**
 * Created by abdelrahman on 11/23/16.
 */
public interface FrameListener {

    /**
     * This method gets called whenever the "Next" button has been clicked
     * in the GUI. The GUI will request the controller to fetch/execute the next
     * instruction.
     */
    void nextStepRequested();

    /**
     * This method gets called whenever the user has written a program and requested it to
     * be loaded in memory.
     *
     * @param code: the program code as an array of integers.
     * @param startingAddress: the starting memory address where the program code will be placed
     */
    void loadProgramRequested(int[] code, int startingAddress);
}

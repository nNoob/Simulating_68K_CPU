package core.model;

import java.util.ArrayList;

/*
 * Created by abdelrahman on 11/22/16.
 */
public interface Processor {

    /**
     * loads a program as an array of integers each integer representing
     * an 8-bit memory location. the starting address is the starting address
     * of the program in memory
     */
    void loadProgram(int[] code, int startingAddress);

    /**
     * fetches the instruction pointed to by PC in memory
     * @returns a binary string of bits that is the instruction fetched
     * comprising the opcode and the operand
     */
    String fetch();

    /**
     * executes the instruction currently in the IR register
     * where the opcode and the operand are fetched from the previous
     * fetch cycle
     */
    void execute();

    /**
     * returns the current data inside the CPU registers
     * in a CPUData object
     */
    CPUData getData();

    /**
     * returns the an ArrayList of integers representing a current
     * snapshot of the memory
     */
     ArrayList<Integer> getMemory();
}

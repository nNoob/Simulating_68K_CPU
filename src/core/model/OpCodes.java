package core.model;

/**
 * Created by abdelrahman on 11/22/16.
 */
public enum OpCodes {
    MOVE(0),
    ADD(1),
    SUB(2),
    BRA(3),
    CMP(4),
    BEQ(5),
    BNE(6),
    EXG(7), // swaps the contents of two memory/register locations
    STOP(15);

    private final int value;

    OpCodes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

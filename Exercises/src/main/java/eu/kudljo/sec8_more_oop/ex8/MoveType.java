package eu.kudljo.sec8_more_oop.ex8;

public enum MoveType {
    UP(1),
    DOWN(-1);

    private final int directionValue;

    MoveType(int directionValue) {
        this.directionValue = directionValue;
    }

    public int getDirectionValue() {
        return directionValue;
    }
}

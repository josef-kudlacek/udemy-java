package eu.kudljo.sec9_collections.ex9;

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

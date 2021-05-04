package model;

public enum Movement {
    GO(1), STOP(0);

    public static final int GO_THRESHOLD = 4;

    private final int move;

    Movement(int move) {
        this.move = move;
    }

    public int move() {
        return move;
    }

    public static Movement of(int number) {
        if (number < GO_THRESHOLD) {
            return STOP;
        }
        return GO;
    }

}

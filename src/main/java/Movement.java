public enum Movement {
    GO(1), STOP(0);

    private final int move;

    Movement(int move) {
        this.move = move;
    }

    public int move(){
        return move;
    }
}

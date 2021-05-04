package model;

import java.util.Objects;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private static final int EXHAUSTED_PLAY_TURN = 0;

    public final String name;

    private int position;

    private int playTurns;

    public Car(String name, int playTurns) {
        this(name, playTurns, 0);
    }

    protected Car(String name, int playTurns, int position) {
        isValidName(name);
        this.name = name;
        this.playTurns = playTurns;
        this.position = position;
    }

    private void isValidName(String name) {
        if (Objects.isNull(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자리 이하의 이름을 입력해 주세요.");
        }
    }

    public void move(Movement movement) {
        isAbleToPlay();
        playTurns--;
        this.position += movement.move();
    }

    public int position() {
        return position;
    }

    private void isAbleToPlay() {
        if (playTurns == EXHAUSTED_PLAY_TURN) {
            throw new IllegalStateException("더이상 움직일 수 없습니다.");
        }
    }

    public String name() {
        return name;
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }

}

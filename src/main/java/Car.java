import java.util.Objects;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private static final int EXHAUSTED_PLAY_TURN = 0;

    public final String name;

    public int playTurns;

    public Car(String name, int playTurns) {
        isValidName(name);
        this.name = name;
        this.playTurns = playTurns;
    }

    private void isValidName(String name) {
        if (Objects.isNull(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자리 이하의 이름을 입력해 주세요.");
        }
    }

    public void play() {
        isAbleToPlay();
    }

    private void isAbleToPlay() {
        if (playTurns == EXHAUSTED_PLAY_TURN) {
            throw new IllegalStateException("더이상 움직일 수 없습니다.");
        }
    }
}

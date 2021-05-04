import java.util.Scanner;

public class InputView {

    public static final String ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static final String ENTER_PLAY_TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static String enterCarNames() {
        System.out.println(ENTER_CAR_NAMES_MESSAGE);
        String names = scanner.nextLine();
        return names;
    }

    public static int enterPlayTurns() {
        System.out.println(ENTER_PLAY_TURN_MESSAGE);
        int playTurns = scanner.nextInt();
        return playTurns;
    }
}

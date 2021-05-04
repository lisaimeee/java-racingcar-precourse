package view;

import model.Car;
import model.Cars;

import java.util.stream.Collectors;

public class PrintView {

    public static final String RACE_RESULT = "\n실행결과";

    public static final String FINAL_WINNER_MESSAGE = "가 최종 우승 했습니다.";

    public static final String NAME_POSITION_DELIMITER = ": ";

    public static final String CAR_NAME_DELIMITER = ",";

    public static final String NEW_LINE = "\n";

    public static final String CAR_POSITION_SIGN = "-";

    private PrintView() {

    }

    public static void printRaceResultMessage() {
        System.out.println(RACE_RESULT);
    }

    public static void printRaceResult(Cars cars) {
        String result = cars.racingCars()
                            .stream()
                            .map(PrintView::format)
                            .collect(Collectors.joining(NEW_LINE));
        System.out.println(result);
        System.out.println();
    }

    private static String format(Car car){
        return car.name + NAME_POSITION_DELIMITER + formatPosition(car.position());
    }

    private static String formatPosition(int number) {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < number; i++) {
            position.append(CAR_POSITION_SIGN);
        }
        return position.toString();
    }

    public static void printFinalWinner(Cars cars) {
        String winners = cars.winners()
                             .stream()
                             .map(Car::name)
                             .collect(Collectors.joining(CAR_NAME_DELIMITER));

        System.out.println(winners + FINAL_WINNER_MESSAGE);
    }
}

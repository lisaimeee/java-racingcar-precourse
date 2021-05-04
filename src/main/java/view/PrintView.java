package view;

import model.Car;
import model.Cars;

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
        StringBuilder result = new StringBuilder();
        for(Car car : cars.racingCars()){
            result.append(format(car))
                  .append(NEW_LINE);
        }
        System.out.println(result.toString());
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
        StringBuilder result = new StringBuilder();
        for (Car car : cars.winners()) {
            result.append(car.name()).append(CAR_NAME_DELIMITER);
        }
        String winners = result.toString();
        winners = winners.substring(0, winners.length() - 1);
        System.out.println(winners + FINAL_WINNER_MESSAGE);
    }
}

public class RacingController {

    public static void run() {
        String carNames = InputView.enterCarNames();
        int playTurns = InputView.enterPlayTurns();
        Cars cars = new Cars(carNames, playTurns);
        PrintView.printRaceResultMessage();
        race(cars, playTurns);
        PrintView.printFinalWinner(cars);
    }

    private static void race(Cars cars, int playTurns) {
        while (playTurns > 0) {
            cars.race();
            playTurns--;
            PrintView.printRaceResult(cars);
        }
    }
}

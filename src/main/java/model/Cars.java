package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Cars {

    public final String NAME_DELIMITER = ",";


    private final List<Car> racingCars;

    private final List<Car> winners = new ArrayList<>();

    public Cars(String names, int playTurns) {
        this.racingCars = createCars(names, playTurns);
    }

    protected Cars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    private List<Car> createCars(String names, int playTurns) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(NAME_DELIMITER)) {
            cars.add(new Car(name, playTurns));
        }
        return cars;
    }

    public void race() {
        racingCars.forEach(car -> car.move(Movement.of(RandomNumber.random1To9Number())));
    }

    public List<Car> racingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public List<Car> winners() {
        computeWinners();
        return winners;
    }

    private void computeWinners() {
        final int winnerPosition = computeWinnerPosition();
        for (Car car : racingCars) {
            addWinnersIfWinner(car, one -> one.isWinner(winnerPosition));
        }
    }

    private void addWinnersIfWinner(Car car, Predicate<Car> condition) {
        if (condition.test(car)) {
            winners.add(car);
        }
    }

    private int computeWinnerPosition() {
        if (racingCars.isEmpty()) {
            throw new IllegalStateException("경주에 참여한 자동차가 없습니다.");
        }
        List<Car> cars = new ArrayList<>(racingCars);
        cars.sort(Comparator.comparingInt(Car::position).reversed());
        return cars.get(0).position();
    }
}

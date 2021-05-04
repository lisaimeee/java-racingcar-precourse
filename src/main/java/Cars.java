import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    public final String NAME_DELIMITER = ",";


    private final List<Car> racingCars;

    public Cars(String names, int playTurns) {
        this.racingCars = createCars(names, playTurns);
    }

    protected Cars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    private List<Car> createCars(String names, int playTurns) {
        return Arrays.stream(names.split(NAME_DELIMITER))
                     .map(name -> new Car(name, playTurns))
                     .collect(Collectors.toList());
    }

    public void race() {
        racingCars.forEach(car -> car.move(Movement.of(RandomNumber.random1To9Number())));
    }

    public List<Car> racingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public List<Car> winners() {
        final int winnerPosition = winnerPosition();
        return racingCars.stream()
                         .filter(car -> car.position() == winnerPosition)
                         .collect(Collectors.toList());
    }

    private int winnerPosition() {
        return racingCars.stream()
                         .max(Comparator.comparingInt(Car::position))
                         .map(Car::position)
                         .orElseGet(() -> 0);
    }
}

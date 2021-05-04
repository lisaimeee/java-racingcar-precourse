import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> racingCars;

    private final int playTurns;

    protected Cars(List<Car> racingCars, int playTurns) {
        this.racingCars = racingCars;
        this.playTurns = playTurns;
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

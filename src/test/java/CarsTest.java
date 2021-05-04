import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 누가_우승했는지_알려준다() {
        int playTurns = 3;
        Car winner1 = new Car("win1", playTurns, 3);
        Car winner2 = new Car("win2", playTurns, 3);
        Car player1 = new Car("play1", playTurns, 0);
        Cars cars = new Cars(Arrays.asList(winner1, winner2, player1), playTurns);
        assertThat(cars.winners()).isNotEmpty()
                                  .hasSize(2)
                                  .contains(winner1, winner2);
    }
}

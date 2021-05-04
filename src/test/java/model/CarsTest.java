package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 누가_우승했는지_알려준다() {
        int playTurns = 3;
        Car winner1 = new Car("win1", playTurns, 3);
        Car winner2 = new Car("win2", playTurns, 3);
        Car player1 = new Car("play1", playTurns, 0);
        Cars cars = new Cars(Arrays.asList(winner1, winner2, player1));
        assertThat(cars.winners()).isNotEmpty().hasSize(2).contains(winner1, winner2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5=5", "a,b,c=3"}, delimiter = '=')
    void 자동차_이름은_쉽표를_기준으로_구분한다(String csv, int size) {
        int playTurns = 1;
        Cars cars = new Cars(csv, playTurns);
        assertThat(cars.racingCars())
                .hasSize(size);
    }
}

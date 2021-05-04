import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MovementTest {

    @ParameterizedTest
    @CsvSource({"1,STOP","3,STOP", "4,GO", "9,GO"})
    void _4_이상일_경우_전진하고_3_이하의_값이면_정지한다(int value, Movement expected) {
        assertThat(Movement.of(value)).isEqualTo(expected);
    }
}

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class CarTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        String name = "name";
        int playTurns = 1;
        Car car = new Car(name, playTurns);
        assertThat(car.name).isEqualTo(name);
    }

    @Test
    void 이름은_5자_이하만_가능하다() {
        String 여섯자리_이름 = "123456";
        int playTurns = 1;
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(여섯자리_이름, playTurns));
    }

    @Test
    void 자동차는_주어진_횟수동안_움직일_수_있다() {
        String name = "name";
        int playTurns = 0;
        Car car = new Car(name, playTurns);
        assertThatIllegalStateException().isThrownBy(car::play);
    }
}

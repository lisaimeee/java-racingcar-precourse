import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        String name = "name";
        Car car = new Car(name);
        assertThat(car.name).isEqualTo(name);
    }

    @Test
    void 이름은_5자_이하만_가능하다() {
        String 여섯자리_이름 = "123456";
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(여섯자리_이름));
    }
}

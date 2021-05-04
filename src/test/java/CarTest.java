import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다(){
        String name = "name";
        Car car = new Car(name);
        assertThat(car.name).isEqualTo(name);
    }

}

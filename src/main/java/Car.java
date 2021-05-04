import java.util.Objects;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    public final String name;

    public Car(String name) {
        isValidName(name);
        this.name = name;
    }

    private void isValidName(String name) {
        if(Objects.isNull(name) || name.length() > MAX_NAME_LENGTH ){
            throw new IllegalArgumentException("5자리 이하의 이름을 입력해 주세요.");
        }
    }
}

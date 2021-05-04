package model;

import java.util.Random;

public class RandomNumber {

    private static final Random random = new Random();

    private static final int BOUND_NINE = 9;

    private RandomNumber() {

    }

    public static int random1To9Number() {
        return random.nextInt(BOUND_NINE) + 1;
    }
}

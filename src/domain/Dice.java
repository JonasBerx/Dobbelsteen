package domain;

import java.util.Random;

public class Dice {
    public Dice() {

    }

    public int trow() {
        Random random = new Random();
        return random.nextInt(7) + random.nextInt(7);
    }
}

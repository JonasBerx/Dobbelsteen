package domain;

import java.util.Random;

public class Dice {
    public Dice() {

    }

    public int throwDice() {
        Random random = new Random();
        return random.nextInt(7) + random.nextInt(7);
    }
}

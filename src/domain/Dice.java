package domain;

import java.util.Random;

public class Dice {
    public Dice() {

    }

    public int throwDice() {
        int high = 7;
        int low = 1;
        int score;
        //Bij random is lower boundary 0 (inclusive) - Moet dus +1 doen op einde (lowerbound)
        Random random = new Random();

        int result = random.nextInt(high - low) + low;
        System.out.println(result);
        int result2 = random.nextInt(high - low) + low;
        System.out.println(result2);
        score = result + result2;
        if (result == result2) {
            score = (result + result2) * 2;
            return score;
        }

        return score;
    }
}

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    public int throwDice() {
        return (int)(Math.random()*6+1);
    }

    public List<Integer> throwDices(int count) {
        List<Integer> listToReturn = new ArrayList<Integer>();
        for (int i = 0; i <count ; i++) {
            listToReturn.add(throwDice());
        }
        return listToReturn;
    }
}

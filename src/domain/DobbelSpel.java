package domain;

import java.util.ArrayList;
import java.util.List;

public class DobbelSpel implements Observable {
    List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        for (int i = 0; i < observers.size(); i++) {
            if (observer != null) {
                if (observers.get(i) == observer) {
                    observers.remove(observer);
                }
            }
        }
    }

    @Override
    public void notifyObserver(Score score, Player player) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(player, score);
        }
    }
}

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
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Score score, Player player) {
        observers.forEach(o -> o.update(player, score));
    }
}

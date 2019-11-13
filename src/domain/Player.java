package domain;

import java.util.ArrayList;
import java.util.List;

public class Player implements Observable {
    private String name;
    private Score score;
    List<Observer> observers = new ArrayList<>();
    private boolean isAanDeBeurt;


    public Player() {
        this.name = "Unknown Player";
        this.score = new Score();
    }

    public Player(String name) {
        setName(name);
        setScore(new Score());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        } else {
            this.name = name;
        }
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        if (score == null) {
            throw new IllegalArgumentException("Oei je hebt een lege score toegevoegd");
        } else {
            this.score = score;
        }
    }

    public void setAanDeBeurt(boolean aanDeBeurt) {
        isAanDeBeurt = aanDeBeurt;
    }

    public boolean isAanDeBeurt() {
        return isAanDeBeurt;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
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

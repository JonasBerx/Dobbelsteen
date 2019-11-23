package domain;

import java.util.ArrayList;
import java.util.List;

public enum EventType {
    PLAYERVIEW(new ArrayList<>()),
    SCOREVIEW(new ArrayList<>());

    private List<Observer> observers;

    private EventType(List<Observer> observers) {
        this.observers = observers;
    }

    public void addObserver(Observer o){
        this.observers.add(o);
    }

    public List<Observer> getObservers(){
        return this.observers;
    }
}

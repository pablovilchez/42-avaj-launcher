package com.avaj.control;

import com.avaj.aircraft.Flyable;
import java.util.ArrayList;
import java.util.List;


public class Tower {
    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }

    protected void conditionChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}

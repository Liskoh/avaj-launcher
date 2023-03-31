package me.hjordan.avaj.objects.towers;

import me.hjordan.avaj.objects.aircrafts.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    protected List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        if (this.observers.contains(flyable))
            throw new RuntimeException("This aircraft is already registered.");

        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        if (!this.observers.contains(flyable))
            throw new RuntimeException("This aircraft is not registered.");

        observers.remove(flyable);
    }

    protected void conditionsChanged() {
            this.observers.forEach(Flyable::updateConditions);
    }
}

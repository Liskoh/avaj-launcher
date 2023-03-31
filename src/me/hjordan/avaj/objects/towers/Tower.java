package me.hjordan.avaj.objects.towers;

import me.hjordan.avaj.objects.aircrafts.Aircraft;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tower {

    protected List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        if (this.observers.contains(flyable))
            throw new RuntimeException("This aircraft is already registered.");



        if (this instanceof WeatherTower && flyable instanceof Aircraft aircraft) {
            observers.add(flyable);
            flyable.registerTower((WeatherTower) this);

            System.out.println("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() +
                    ") registered to weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        if (!this.observers.contains(flyable))
            throw new RuntimeException("This aircraft is not registered.");

        if (this instanceof WeatherTower && flyable instanceof Aircraft aircraft) {
            observers.remove(flyable);

            System.out.println("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() +
                    ") unregistered from weather tower.");
        }
    }

    protected void conditionsChanged() {
            this.observers.forEach(Flyable::updateConditions);
    }
}

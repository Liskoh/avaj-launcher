package me.hjordan.avaj.objects.aircrafts;

import me.hjordan.avaj.objects.towers.impl.WeatherTower;

public abstract class Flyable {

    public abstract void updateConditions();

    public void registerTower(WeatherTower tower) {}
}

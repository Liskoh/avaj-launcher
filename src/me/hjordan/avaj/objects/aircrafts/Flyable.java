package me.hjordan.avaj.objects.aircrafts;

import me.hjordan.avaj.objects.towers.impl.WeatherTower;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower tower);
}

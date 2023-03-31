package me.hjordan.avaj.objects.towers.impl;

import me.hjordan.avaj.objects.towers.Tower;

public class WeatherTower extends Tower {

    public WeatherTower() {
        super();
    }

    public void changeWeather() {
        this.conditionsChanged();
    }

}

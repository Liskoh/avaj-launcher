package me.hjordan.avaj.objects.aircrafts.impl;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.enums.WeatherType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.WeatherProvider;
import me.hjordan.avaj.objects.aircrafts.Aircraft;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;
import me.hjordan.avaj.utils.Utils;

import static me.hjordan.avaj.utils.Utils.*;
import static me.hjordan.avaj.utils.Const.*;
public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);

        this.type = VehicleType.HELICOPTER;
    }

    @Override
    public void updateConditions() {
        Utils.updateConditions(this.coordinates, this.tower, this.type, this);
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.tower = tower;
    }
}

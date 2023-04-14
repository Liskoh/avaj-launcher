package me.hjordan.avaj.objects.aircrafts.impl;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.aircrafts.Aircraft;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;
import me.hjordan.avaj.utils.Utils;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);

        this.type = VehicleType.HELICOPTER;
    }

    @Override
    public void updateConditions() {
        this.update();
    }
}

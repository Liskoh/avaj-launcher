package me.hjordan.avaj.objects.aircrafts.impl;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.aircrafts.Aircraft;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;
import me.hjordan.avaj.utils.Utils;

public class JetPlane extends Aircraft implements Flyable {

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);

        this.type = VehicleType.JETPLANE;
    }

    @Override
    public void updateConditions() {
        this.update();
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.tower = tower;
    }
}

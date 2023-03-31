package me.hjordan.avaj.objects.aircrafts.impl;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.enums.WeatherType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.WeatherProvider;
import me.hjordan.avaj.objects.aircrafts.Aircraft;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;

import static me.hjordan.avaj.utils.Utils.*;
import static me.hjordan.avaj.utils.Const.*;
public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);

        this.type = VehicleType.HELICOPTER;
    }

    @Override
    public void updateConditions() {
        final WeatherType weatherType = WeatherType.valueOf(
                WeatherProvider.getProvider().getCurrentWeather(this.coordinates));

        this.coordinates = setCoordinates(this.type, weatherType, this);

        assert this.coordinates != null;
        if (this.coordinates.getHeight() > MAX_HEIGHT)
            this.coordinates.setHeight(MAX_HEIGHT);
        else if (this.coordinates.getHeight() <= MIN_HEIGHT) {
            this.tower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.tower = tower;
    }
}

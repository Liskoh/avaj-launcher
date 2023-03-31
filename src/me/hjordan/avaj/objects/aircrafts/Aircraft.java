package me.hjordan.avaj.objects.aircrafts;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;

import static me.hjordan.avaj.utils.Utils.*;
public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected VehicleType type;
    protected WeatherTower tower;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = id;
        this.type = null;
        this.tower = null;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public VehicleType getType() {
        return this.type;
    }

}

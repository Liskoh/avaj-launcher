package me.hjordan.avaj.objects.aircrafts;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.enums.WeatherType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.WeatherProvider;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;
import me.hjordan.avaj.utils.Utils;

import static me.hjordan.avaj.utils.Const.MAX_HEIGHT;
import static me.hjordan.avaj.utils.Const.MIN_HEIGHT;

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

    protected void update() {
        final WeatherType weatherType = WeatherType.valueOf(
                WeatherProvider.getProvider().getCurrentWeather(coordinates));

        coordinates = Utils.setCoordinates(type, weatherType, this);

        assert coordinates != null;
        if (coordinates.getHeight() > MAX_HEIGHT)
            coordinates.setHeight(MAX_HEIGHT);
        else if (coordinates.getHeight() <= MIN_HEIGHT) {
            System.out.println(type + "#" + this.getName() + "(" + this.getId() + "): landing.");

            if (this instanceof Flyable)
                tower.unregister((Flyable) this);
        }
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

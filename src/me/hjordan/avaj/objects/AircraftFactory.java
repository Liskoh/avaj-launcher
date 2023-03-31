package me.hjordan.avaj.objects;

import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.aircrafts.impl.Helicopter;
import me.hjordan.avaj.utils.Utils;

import static me.hjordan.avaj.utils.Utils.*;

public class AircraftFactory {

    private static AircraftFactory instance = null;

    public AircraftFactory() {
        instance = this;
    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "Helicopter":
                return new Helicopter(incrementId(), name, coordinates);
            default:
                return null;
        }
    }

    public static AircraftFactory getInstance() {
        return instance;
    }
}

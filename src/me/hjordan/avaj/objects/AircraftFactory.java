package me.hjordan.avaj.objects;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.aircrafts.impl.Baloon;
import me.hjordan.avaj.objects.aircrafts.impl.Helicopter;
import me.hjordan.avaj.objects.aircrafts.impl.JetPlane;
import me.hjordan.avaj.utils.Utils;

import java.util.List;

import static me.hjordan.avaj.utils.Utils.*;

public class AircraftFactory {

    private static AircraftFactory instance = null;

    public AircraftFactory() {
        instance = this;
    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        return switch (type) {
            case "Helicopter" -> new Helicopter(incrementId(), name, coordinates);
            case "JetPlane" -> new JetPlane(incrementId(), name, coordinates);
            case "Baloon" -> new Baloon(incrementId(), name, coordinates);
            default -> null;
        };
    }

    public static AircraftFactory getInstance() {
        return instance;
    }
}

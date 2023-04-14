package me.hjordan.avaj.utils;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.enums.WeatherType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.WeatherProvider;
import me.hjordan.avaj.objects.aircrafts.Aircraft;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;

import static me.hjordan.avaj.utils.Const.MAX_HEIGHT;
import static me.hjordan.avaj.utils.Const.MIN_HEIGHT;

public class Utils {

    public static int CURRENT_ID = 0;

    public static int incrementId() {
        return ++CURRENT_ID;
    }

    public static Coordinates setCoordinates(VehicleType vehicleType,
                                             WeatherType weatherType,
                                             Aircraft aircraft) {

        final Coordinates coordinates = aircraft.getCoordinates();
        final String name = aircraft.getName();
        final long id = aircraft.getId();
        final String type = vehicleType.getType();

        switch (weatherType) {
            case SUN -> {
                printFormattedMessage(type, name, id, "It's sunny. We're having a good day.", weatherType);
                return switch (vehicleType) {
                    case HELICOPTER, JETPLANE -> new Coordinates(coordinates.getLongitude() + 10,
                            coordinates.getLatitude(),
                            coordinates.getHeight() + 2);
                    case BALLOON -> new Coordinates(coordinates.getLongitude() + 2,
                            coordinates.getLatitude(),
                            coordinates.getHeight() + 4);
                };
            }
            case RAIN -> {
                printFormattedMessage(type, name, id, "It's raining. Better watch out for lightening.", weatherType);
                return switch (vehicleType) {
                    case HELICOPTER -> new Coordinates(coordinates.getLongitude() + 5,
                            coordinates.getLatitude(),
                            coordinates.getHeight());
                    case JETPLANE -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude() + 5,
                            coordinates.getHeight());
                    case BALLOON -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 5);
                };
            }
            case FOG -> {
                printFormattedMessage(type, name, id, "It's foggy. We can't see anything.", weatherType);
                return switch (vehicleType) {
                    case HELICOPTER -> new Coordinates(coordinates.getLongitude() + 1,
                            coordinates.getLatitude(),
                            coordinates.getHeight());
                    case JETPLANE -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude() + 1,
                            coordinates.getHeight());
                    case BALLOON -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 3);
                };
            }
            case SNOW -> {
                printFormattedMessage(type, name, id, "It's snowing. We're gonna crash.", weatherType);
                return switch (vehicleType) {
                    case HELICOPTER -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 12);
                    case JETPLANE -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 7);
                    case BALLOON -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 15);
                };
            }
        }
        return null;
    }

    public static void printFormattedMessage(String type, String name, long id, String text, WeatherType weatherType) {
        final String message = type + "#" + name + "(" + id + "): " + text + " [" + weatherType + "]";

        System.out.println(message);
    }
}

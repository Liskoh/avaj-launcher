package me.hjordan.avaj.utils;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.enums.WeatherType;
import me.hjordan.avaj.objects.Coordinates;
import me.hjordan.avaj.objects.aircrafts.Aircraft;

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
                printFormattedMessage(type, name, id, "It's sunny. We're having a good day.");
                return switch (vehicleType) {
                    case HELICOPTER, JETPLANE -> new Coordinates(coordinates.getLongitude() + 10,
                            coordinates.getLatitude(),
                            coordinates.getHeight() + 2);
                    case BALLOON -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() + 4);
                };
            }
            case RAIN -> {
                printFormattedMessage(type, name, id, "It's raining. Better watch out for lightening.");
                return switch (vehicleType) {
                    case HELICOPTER -> new Coordinates(coordinates.getLongitude() + 5,
                            coordinates.getLatitude(),
                            coordinates.getHeight());
                    case JETPLANE -> new Coordinates(coordinates.getLongitude() + 7,
                            coordinates.getLatitude(),
                            coordinates.getHeight());
                    case BALLOON -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 5);
                };
            }
            case FOG -> {
                printFormattedMessage(type, name, id, "It's foggy. We can't see anything.");
                return switch (vehicleType) {
                    case HELICOPTER, JETPLANE -> new Coordinates(coordinates.getLongitude() + 1,
                            coordinates.getLatitude(),
                            coordinates.getHeight());
                    case BALLOON -> new Coordinates(coordinates.getLongitude(),
                            coordinates.getLatitude(),
                            coordinates.getHeight() - 3);
                };
            }
            case SNOW -> {
                printFormattedMessage(type, name, id, "It's snowing. We're gonna crash.");
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

    public static void printFormattedMessage(String type, String name, long id, String text) {
        final String message = type + "#" + name + "(" + id + "): " + text;

        System.out.println(message);
    }
}

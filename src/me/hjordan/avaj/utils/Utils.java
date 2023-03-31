package me.hjordan.avaj.utils;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.enums.WeatherType;
import me.hjordan.avaj.objects.Coordinates;

public class Utils {

    public static int CURRENT_ID = 0;

    public static int incrementId() {
        return ++CURRENT_ID;
    }


    public static Coordinates setCoordinates(VehicleType vehicleType,
                                      WeatherType weatherType,
                                      Coordinates coordinates) {
        switch (weatherType) {
            case SUN -> {
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
}

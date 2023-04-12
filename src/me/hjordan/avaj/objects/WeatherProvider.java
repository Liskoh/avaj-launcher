package me.hjordan.avaj.objects;

public class WeatherProvider {

    private static final WeatherProvider PROVIDER = new WeatherProvider();
    private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return PROVIDER;
    }

    public String getCurrentWeather(Coordinates coordinates) {
//        int coord = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
//        int random = (coordinates.getLongitude() +
//                        coordinates.getLatitude() +
//                        coordinates.getHeight()) %
//                weather.length;
//
//        System.err.println("Coordinates: " + coord);
//        System.err.println("Weather: " + random);

        final int random = (int) (Math.random() * 4);

        return weather[random];
    }
}

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
        int random = (coordinates.getLongitude() +
                        coordinates.getLatitude() +
                        coordinates.getHeight()) %
                weather.length - 1;
        return weather[random];
    }
}

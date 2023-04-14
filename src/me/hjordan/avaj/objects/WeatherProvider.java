package me.hjordan.avaj.objects;

import me.hjordan.avaj.enums.WeatherType;
import me.hjordan.avaj.utils.Const;

public class WeatherProvider {

    private static final WeatherProvider PROVIDER = new WeatherProvider();
    private final String[] weather;

    private WeatherProvider() {
        this.weather = new String[Const.WEATHER_COUNT];

        for (int i = 0; i < Const.WEATHER_COUNT; i++)
            this.weather[i] = WeatherType.values()[i].getType();
    }

    public static WeatherProvider getProvider() {
        return PROVIDER;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        final int coord = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        final int random = coord % Const.WEATHER_COUNT;

        return weather[random];
    }
}

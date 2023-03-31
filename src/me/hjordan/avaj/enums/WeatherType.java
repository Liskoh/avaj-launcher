package me.hjordan.avaj.enums;

public enum WeatherType {

    RAIN("RAIN"),
    FOG("FOG"),
    SUN("SUN"),
    SNOW("SNOW");

    private String type;

    WeatherType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}

package me.hjordan.avaj.enums;

public enum VehicleType {

    HELICOPTER("Helicopter"),
    JETPLANE("JetPlane"),
    BALLOON("Balloon");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}

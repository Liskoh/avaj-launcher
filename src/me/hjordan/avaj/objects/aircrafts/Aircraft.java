package me.hjordan.avaj.objects.aircrafts;

import me.hjordan.avaj.enums.VehicleType;
import me.hjordan.avaj.objects.Coordinates;

import static me.hjordan.avaj.utils.Utils.*;
public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected VehicleType type;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = id;
    }

}

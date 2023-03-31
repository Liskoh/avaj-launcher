package me.hjordan.avaj.objects;

import static me.hjordan.avaj.utils.Utils.*;
public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = id;
    }

}
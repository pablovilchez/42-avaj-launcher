package com.avaj.aircraft;

import com.avaj.weather.Coordinates;


abstract class Aircraft implements Flyable {
    protected final long id;
    protected final String name;
    protected  final Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }
}

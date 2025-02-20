package com.avaj.aircraft;

import com.avaj.control.WeatherTower;
import com.avaj.weather.Coordinates;


class Helicopter extends Aircraft {
    
    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String message = "Helicopter#" + this.name + "(" + this.id + "): ";
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 10,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 2
                );
                message += "This is hot.";
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 5,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
                );
                message += "Rain is wet.";
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 1,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
                );
                message += "I can't see anything.";
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 12
                );
                message += "My rotor is going to freeze!";
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            message += "landing.";
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
        Logger.log(message);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.log("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }   
}
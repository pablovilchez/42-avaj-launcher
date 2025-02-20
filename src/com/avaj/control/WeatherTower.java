package com.avaj.control;

import com.avaj.weather.Coordinates;
import com.avaj.weather.WeatherProvider;


public class WeatherTower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        
    }
}
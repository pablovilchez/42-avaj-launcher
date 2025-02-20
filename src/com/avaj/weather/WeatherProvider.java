package com.avaj.weather;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider;
    private final static String[] weather = {"FOG", "RAIN", "SNOW", "SUN"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int longitude = p_coordinates.getLongitude();
        int latitude = p_coordinates.getLatitude();
        int height = p_coordinates.getHeight();
        
        return weather[(longitude + latitude + height) % 4];
    }
}


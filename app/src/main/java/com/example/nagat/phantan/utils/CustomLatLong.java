package com.example.nagat.phantan.utils;

/**
 * Created by nagat on 24/4/2018.
 */

public class CustomLatLong {
        private double lat;
        private double log;

    public CustomLatLong(double lat, double log) {
        this.lat = lat;
        this.log = log;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }
}

package com.example.nagat.phantan.utils;

/**
 * Created by nagat on 24/4/2018.
 */

public class MyPoint {
    private CustomLatLong customLatLong;
    private int[] index;

    public MyPoint(CustomLatLong customLatLong, int[] index) {
        this.customLatLong = customLatLong;
        this.index = index;
    }

    public CustomLatLong getCustomLatLong() {
        return customLatLong;
    }

    public void setCustomLatLong(CustomLatLong customLatLong) {
        this.customLatLong = customLatLong;
    }

    public int[] getIndex() {
        return index;
    }

    public void setIndex(int[] index) {
        this.index = index;
    }
    public boolean isContain(int j) {
        for (int i : index) {
            if (i==j) return true;
        }
        return false;
    }
}

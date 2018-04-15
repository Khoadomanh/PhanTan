package com.example.nagat.phantan.model;

/**
 * Created by nagat on 12/4/2018.
 */

public class Sensor {
    private String idSensor;
    private double luongNuocHienTai;
    private double luongNuocTruocDo;
    private String maCayKetNoi;
    public Sensor() {

    }

    public Sensor(String idSensor, double luongNuocHienTai, double luongNuocTruocDo, String maCayKetNoi) {
        this.idSensor = idSensor;
        this.luongNuocHienTai = luongNuocHienTai;
        this.luongNuocTruocDo = luongNuocTruocDo;
        this.maCayKetNoi = maCayKetNoi;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    public double getLuongNuocHienTai() {
        return luongNuocHienTai;
    }

    public void setLuongNuocHienTai(double luongNuocHienTai) {
        this.luongNuocHienTai = luongNuocHienTai;
    }

    public double getLuongNuocTruocDo() {
        return luongNuocTruocDo;
    }

    public void setLuongNuocTruocDo(double luongNuocTruocDo) {
        this.luongNuocTruocDo = luongNuocTruocDo;
    }

    public String getMaCayKetNoi() {
        return maCayKetNoi;
    }

    public void setMaCayKetNoi(String maCayKetNoi) {
        this.maCayKetNoi = maCayKetNoi;
    }
}

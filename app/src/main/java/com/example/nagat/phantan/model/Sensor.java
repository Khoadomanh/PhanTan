package com.example.nagat.phantan.model;

/**
 * Created by nagat on 12/4/2018.
 */

public class Sensor {
    private String idSensor;
    private long luongNuocHienTai;
    private long luongNuocTruocDo;
    private String maCayKetNoi;
    public Sensor() {

    }

    public Sensor(String idSensor, long luongNuocHienTai, long luongNuocTruocDo, String maCayKetNoi) {
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

    public long getLuongNuocHienTai() {
        return luongNuocHienTai;
    }

    public void setLuongNuocHienTai(long luongNuocHienTai) {
        this.luongNuocHienTai = luongNuocHienTai;
    }

    public long getLuongNuocTruocDo() {
        return luongNuocTruocDo;
    }

    public void setLuongNuocTruocDo(long luongNuocTruocDo) {
        this.luongNuocTruocDo = luongNuocTruocDo;
    }

    public String getMaCayKetNoi() {
        return maCayKetNoi;
    }

    public void setMaCayKetNoi(String maCayKetNoi) {
        this.maCayKetNoi = maCayKetNoi;
    }
}

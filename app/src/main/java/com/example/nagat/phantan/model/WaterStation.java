package com.example.nagat.phantan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class WaterStation {
    //ma nguon nuoc dinh danh
    private String tenTram;
    private String diaDiem;
    private double latitude; //vi do
    private double longitude; //kinh do
    private String tinhTrang;
    private long dungTichChua;

    public long getDungTichChua() {
        return dungTichChua;
    }

    public void setDungTichChua(long dungTichChua) {
        this.dungTichChua = dungTichChua;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    private List<String> hinhAnh = new ArrayList<>();
    public WaterStation() {

    }

    public WaterStation(String tenTram, String diaDiem, double latitude, double longitude, List<String> hinhAnh,String tinhTrang) {
        this.tenTram = tenTram;
        this.diaDiem = diaDiem;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hinhAnh = hinhAnh;
        this.tinhTrang = tinhTrang;
    }



    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public List<String> getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(List<String> hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}

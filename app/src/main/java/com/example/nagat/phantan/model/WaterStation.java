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
    private long latitude; //vi do
    private long longitude; //kinh do
    private List<String> hinhAnh = new ArrayList<>();
    private long luongNuocConLai;
    public WaterStation() {

    }

    public WaterStation(String tenTram, String diaDiem, long latitude, long longitude, List<String> hinhAnh,long luongNuocConLai) {
        this.tenTram = tenTram;
        this.diaDiem = diaDiem;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hinhAnh = hinhAnh;
        this.luongNuocConLai = luongNuocConLai;
    }

    public long getLuongNuocConLai() {
        return luongNuocConLai;
    }

    public void setLuongNuocConLai(long luongNuocConLai) {
        this.luongNuocConLai = luongNuocConLai;
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

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }


    public List<String> getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(List<String> hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}

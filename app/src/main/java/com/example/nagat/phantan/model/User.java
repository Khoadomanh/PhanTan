package com.example.nagat.phantan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagat on 27/3/2018.
 */

public class User {
    private String maUser;
    private String tenHienThi;
    private String trangThai;
    private String diaDiem;
    private String luongNuocCanTuoi;
    private List<String> hinhAnh = new ArrayList<>();
    private long latitude; //vi do
    private long longitude; //kinh do

    public User() {

    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }

    public User(String tenHienThi, String trangThai, String diaDiem, String luongNuocCanTuoi, List<String> hinhAnh, long latitude, long longitude, String maUser) {
        this.tenHienThi = tenHienThi;
        this.trangThai = trangThai;
        this.diaDiem = diaDiem;
        this.luongNuocCanTuoi = luongNuocCanTuoi;
        this.hinhAnh = hinhAnh;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maUser = maUser;

    }

    public String getTenHienThi() {
        return tenHienThi;
    }

    public void setTenHienThi(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getLuongNuocCanTuoi() {
        return luongNuocCanTuoi;
    }

    public void setLuongNuocCanTuoi(String luongNuocCanTuoi) {
        this.luongNuocCanTuoi = luongNuocCanTuoi;
    }

    public List<String> getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(List<String> hinhAnh) {
        this.hinhAnh = hinhAnh;
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
}

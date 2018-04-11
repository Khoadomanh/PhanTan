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
    private String email;
    private List<String> hinhAnh = new ArrayList<>();
    private double latitude; //vi do
    private double longitude; //kinh do

    public User() {

    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }

    public User(String tenHienThi, String trangThai, String diaDiem,  List<String> hinhAnh, double latitude, double longitude, String maUser,String email) {
        this.tenHienThi = tenHienThi;
        this.trangThai = trangThai;
        this.diaDiem = diaDiem;
        this.hinhAnh = hinhAnh;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maUser = maUser;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    public List<String> getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(List<String> hinhAnh) {
        this.hinhAnh = hinhAnh;
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
}

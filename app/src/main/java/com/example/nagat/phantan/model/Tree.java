package com.example.nagat.phantan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class Tree {
    //ma cay dinh dang ma loai cay - thu tu them.
    private String maCay;
    private String tenCay;
    private String trangThai;
    private String diaDiem;
    private double latitude; //vi do
    private double longitude; //kinh do
    private List<String> hinhAnh = new ArrayList<>();
    private User currentUserWatering; //nguoi hien tai dang tuoi
    private long luongNuocMax;
    private String maSensor; //sensor gan' voi cay
    public Tree() {

    }

    public String getMaCay() {
        return maCay;
    }

    public void setMaCay(String maCay) {
        this.maCay = maCay;
    }

    public Tree(String tenCay, String trangThai, String diaDiem, double latitude, double longitude, List<String> hinhAnh, long luongNuocMax, String maCay,String maSensor) {
        this.tenCay = tenCay;
        this.trangThai = trangThai;
        this.diaDiem = diaDiem;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hinhAnh = hinhAnh;
        this.luongNuocMax = luongNuocMax;
        this.maCay = maCay;

    }
    public Tree(String tenCay, String trangThai, String diaDiem, double latitude, double longitude,  long luongNuocMax, String maCay,String maSensor) {
        this.tenCay = tenCay;
        this.trangThai = trangThai;
        this.diaDiem = diaDiem;
        this.latitude = latitude;
        this.longitude = longitude;
        this.luongNuocMax = luongNuocMax;
        this.maCay = maCay;
        this.maSensor = maSensor;
    }

    public String getMaSensor() {
        return maSensor;
    }

    public void setMaSensor(String maSensor) {
        this.maSensor = maSensor;
    }

    public User getCurrentUserWatering() {
        return currentUserWatering;
    }

    public void setCurrentUserWatering(User currentUserWatering) {
        this.currentUserWatering = currentUserWatering;
    }

    public String getTenCay() {
        return tenCay;
    }

    public void setTenCay(String tenCay) {
        this.tenCay = tenCay;
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

    public double getLuongNuocMax() {
        return luongNuocMax;
    }

    public void setLuongNuocMax(long luongNuocMax) {
        this.luongNuocMax = luongNuocMax;
    }
}

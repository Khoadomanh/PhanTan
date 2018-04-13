package com.example.nagat.phantan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagat on 27/3/2018.
 */

public class User {
    //ma user quy dinh tinh nguyen vien la TNV- so thu tu dang ky
    //quy dinh Nhan vien la NV - so thu tu dang ky
    //quy dinh admin la AD - so thu tu dang ky
    private String maUser;
    private String tenHienThi;
    private String trangThai;
    private boolean gioiTinh;
    private String vaiTro;
    private String treeWatering;
    private String email;
    private String avatar;
    private double latitude; //vi do
    private double longitude; //kinh do

    public String getTreeWatering() {
        return treeWatering;
    }

    public void setTreeWatering(String treeWatering) {
        this.treeWatering = treeWatering;
    }

    public User() {

    }

    public User(String maUser, String tenHienThi, String trangThai, boolean gioiTinh, String vaiTro, String email, String avatar, double latitude, double longitude) {
        this.maUser = maUser;
        this.tenHienThi = tenHienThi;
        this.trangThai = trangThai;
        this.gioiTinh = gioiTinh;
        this.vaiTro = vaiTro;
        this.email = email;
        this.avatar = avatar;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
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

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

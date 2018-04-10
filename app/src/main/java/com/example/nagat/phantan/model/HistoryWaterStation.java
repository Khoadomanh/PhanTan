package com.example.nagat.phantan.model;

import java.util.Date;

/**
 * Created by nagat on 27/3/2018.
 */

public class HistoryWaterStation {
    private String maNguoiLay;
    private String tenNguoiLay;
    private long luongNuoc;
    private Date thoiGianLay;

    public HistoryWaterStation() {

    }

    public String getMaNguoiLay() {
        return maNguoiLay;
    }

    public void setMaNguoiLay(String maNguoiLay) {
        this.maNguoiLay = maNguoiLay;
    }

    public HistoryWaterStation(String tenNguoiLay, long luongNuoc, Date thoiGianLay, String maNguoiLay) {
        this.tenNguoiLay = tenNguoiLay;
        this.luongNuoc = luongNuoc;
        this.thoiGianLay = thoiGianLay;
        this.maNguoiLay = maNguoiLay;

    }

    public String getTenNguoiLay() {
        return tenNguoiLay;
    }

    public void setTenNguoiLay(String tenNguoiLay) {
        this.tenNguoiLay = tenNguoiLay;
    }

    public long getLuongNuoc() {
        return luongNuoc;
    }

    public void setLuongNuoc(long luongNuoc) {
        this.luongNuoc = luongNuoc;
    }

    public Date getThoiGianLay() {
        return thoiGianLay;
    }

    public void setThoiGianLay(Date thoiGianLay) {
        this.thoiGianLay = thoiGianLay;
    }
}

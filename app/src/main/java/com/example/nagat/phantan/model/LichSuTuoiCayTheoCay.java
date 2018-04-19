package com.example.nagat.phantan.model;

import java.util.Date;

/**
 * Created by nagat on 10/4/2018.
 */

public class LichSuTuoiCayTheoCay {

    private String tenNguoiTuoi;
    private String maNguoiTuoi;
    private double luongNuocTuoi;
    private long ngayGioTuoi;
    private String vaiTroNguoiToi;

    public String getVaiTroNguoiToi() {
        return vaiTroNguoiToi;
    }

    public void setVaiTroNguoiToi(String vaiTroNguoiToi) {
        this.vaiTroNguoiToi = vaiTroNguoiToi;
    }

    public LichSuTuoiCayTheoCay()  {

    }

    public String getTenNguoiTuoi() {
        return tenNguoiTuoi;
    }

    public void setTenNguoiTuoi(String tenNguoiTuoi) {
        this.tenNguoiTuoi = tenNguoiTuoi;
    }

    public String getMaNguoiTuoi() {
        return maNguoiTuoi;
    }

    public void setMaNguoiTuoi(String maNguoiTuoi) {
        this.maNguoiTuoi = maNguoiTuoi;
    }

    public double getLuongNuocTuoi() {
        return luongNuocTuoi;
    }

    public void setLuongNuocTuoi(double luongNuocTuoi) {
        this.luongNuocTuoi = luongNuocTuoi;
    }

    public long getNgayGioTuoi() {
        return ngayGioTuoi;
    }

    public void setNgayGioTuoi(long ngayGioTuoi) {
        this.ngayGioTuoi = ngayGioTuoi;
    }

    public LichSuTuoiCayTheoCay(String tenNguoiTuoi, String maNguoiTuoi, long luongNuocTuoi, long ngayGioTuoi) {

        this.tenNguoiTuoi = tenNguoiTuoi;
        this.maNguoiTuoi = maNguoiTuoi;
        this.luongNuocTuoi = luongNuocTuoi;
        this.ngayGioTuoi = ngayGioTuoi;
    }
}

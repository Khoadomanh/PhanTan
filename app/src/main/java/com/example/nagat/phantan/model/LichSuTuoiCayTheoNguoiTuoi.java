package com.example.nagat.phantan.model;

import java.util.Date;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class LichSuTuoiCayTheoNguoiTuoi {

    private String maCayTuoi;
    private String tenCayTuoi;
    private double luongNuocTuoi;
    private long thoiGianTuoi;

    public LichSuTuoiCayTheoNguoiTuoi() {

    }

    public String getMaCayTuoi() {
        return maCayTuoi;
    }

    public void setMaCayTuoi(String maCayTuoi) {
        this.maCayTuoi = maCayTuoi;
    }

    public LichSuTuoiCayTheoNguoiTuoi(String tenCayTuoi, long luongNuocTuoi, long thoiGianTuoi, String maCayTuoi) {
        this.tenCayTuoi = tenCayTuoi;
        this.luongNuocTuoi = luongNuocTuoi;
        this.thoiGianTuoi = thoiGianTuoi;
        this.maCayTuoi = maCayTuoi;

    }

    public String getTenCayTuoi() {
        return tenCayTuoi;
    }

    public void setTenCayTuoi(String tenCayTuoi) {
        this.tenCayTuoi = tenCayTuoi;
    }

    public double getLuongNuocTuoi() {
        return luongNuocTuoi;
    }

    public void setLuongNuocTuoi(double luongNuocTuoi) {
        this.luongNuocTuoi = luongNuocTuoi;
    }

    public long getThoiGianTuoi() {
        return thoiGianTuoi;
    }

    public void setThoiGianTuoi(long thoiGianTuoi) {
        this.thoiGianTuoi = thoiGianTuoi;
    }
}

package com.example.nagat.phantan.model;

import java.util.Date;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class LichSuTuoiCayTheoNguoiTuoi {

    private String maCayTuoi;
    private String tenCayTuoi;
    private long luongNuocTuoi;
    private Date thoiGianTuoi;

    public LichSuTuoiCayTheoNguoiTuoi() {

    }

    public String getMaCayTuoi() {
        return maCayTuoi;
    }

    public void setMaCayTuoi(String maCayTuoi) {
        this.maCayTuoi = maCayTuoi;
    }

    public LichSuTuoiCayTheoNguoiTuoi(String tenCayTuoi, long luongNuocTuoi, Date thoiGianTuoi, String maCayTuoi) {
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

    public long getLuongNuocTuoi() {
        return luongNuocTuoi;
    }

    public void setLuongNuocTuoi(long luongNuocTuoi) {
        this.luongNuocTuoi = luongNuocTuoi;
    }

    public Date getThoiGianTuoi() {
        return thoiGianTuoi;
    }

    public void setThoiGianTuoi(Date thoiGianTuoi) {
        this.thoiGianTuoi = thoiGianTuoi;
    }
}

package com.example.nagat.phantan.model;

import java.util.Date;

/**
 * Created by nagat on 10/4/2018.
 */

public class LichSuTuoiCayTheoCay {

    private String tenNguoiTuoi;
    private String maNguoiTuoi;
    private long luongNuocTuoi;
    private Date ngayGioTuoi;

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

    public long getLuongNuocTuoi() {
        return luongNuocTuoi;
    }

    public void setLuongNuocTuoi(long luongNuocTuoi) {
        this.luongNuocTuoi = luongNuocTuoi;
    }

    public Date getNgayGioTuoi() {
        return ngayGioTuoi;
    }

    public void setNgayGioTuoi(Date ngayGioTuoi) {
        this.ngayGioTuoi = ngayGioTuoi;
    }

    public LichSuTuoiCayTheoCay(String tenNguoiTuoi, String maNguoiTuoi, long luongNuocTuoi, Date ngayGioTuoi) {

        this.tenNguoiTuoi = tenNguoiTuoi;
        this.maNguoiTuoi = maNguoiTuoi;
        this.luongNuocTuoi = luongNuocTuoi;
        this.ngayGioTuoi = ngayGioTuoi;
    }
}

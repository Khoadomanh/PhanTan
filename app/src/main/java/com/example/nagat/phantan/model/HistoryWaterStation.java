package com.example.nagat.phantan.model;

import java.util.Date;

/**
 * Created by nagat on 27/3/2018.
 */

public class HistoryWaterStation {
    private String idNguoiLayNuoc;
    private String idNguocNuoc;
    private int luongNuocDaLay;
    private Date ngayLayNuoc;

    public HistoryWaterStation(String idNguoiLayNuoc, String idNguocNuoc, int luongNuocDaLay, Date ngayLayNuoc) {
        this.idNguoiLayNuoc = idNguoiLayNuoc;
        this.idNguocNuoc = idNguocNuoc;
        this.luongNuocDaLay = luongNuocDaLay;
        this.ngayLayNuoc = ngayLayNuoc;
    }

    public String getIdNguoiLayNuoc() {
        return idNguoiLayNuoc;
    }

    public void setIdNguoiLayNuoc(String idNguoiLayNuoc) {
        this.idNguoiLayNuoc = idNguoiLayNuoc;
    }

    public String getIdNguocNuoc() {
        return idNguocNuoc;
    }

    public void setIdNguocNuoc(String idNguocNuoc) {
        this.idNguocNuoc = idNguocNuoc;
    }

    public int getLuongNuocDaLay() {
        return luongNuocDaLay;
    }

    public void setLuongNuocDaLay(int luongNuocDaLay) {
        this.luongNuocDaLay = luongNuocDaLay;
    }

    public Date getNgayLayNuoc() {
        return ngayLayNuoc;
    }

    public void setNgayLayNuoc(Date ngayLayNuoc) {
        this.ngayLayNuoc = ngayLayNuoc;
    }
}

package com.example.nagat.phantan.model;

import java.util.Date;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class HistoryWaterTree {
    private String idNguoiDaTuoi;
    private String idCaytuoi;
    private int luongNuocDaTuoi;
    private Date thoiDiemTuoi;

    public HistoryWaterTree(String idNguoiDaTuoi, String idWaterStation, int luongNuocDaTuoi, Date thoiDiemTuoi) {
        this.idNguoiDaTuoi = idNguoiDaTuoi;
        this.idCaytuoi = idWaterStation;
        this.luongNuocDaTuoi = luongNuocDaTuoi;
        this.thoiDiemTuoi = thoiDiemTuoi;
    }

    public String getIdNguoiDaTuoi() {
    
        return idNguoiDaTuoi;
    }

    public void setIdNguoiDaTuoi(String idNguoiDaTuoi) {
        this.idNguoiDaTuoi = idNguoiDaTuoi;
    }

    public String getIdWaterStation() {
        return idCaytuoi;
    }

    public void setIdWaterStation(String idWaterStation) {
        this.idCaytuoi = idWaterStation;
    }

    public int getLuongNuocDaTuoi() {
        return luongNuocDaTuoi;
    }

    public void setLuongNuocDaTuoi(int luongNuocDaTuoi) {
        this.luongNuocDaTuoi = luongNuocDaTuoi;
    }

    public Date getThoiDiemTuoi() {
        return thoiDiemTuoi;
    }

    public void setThoiDiemTuoi(Date thoiDiemTuoi) {
        this.thoiDiemTuoi = thoiDiemTuoi;
    }
}

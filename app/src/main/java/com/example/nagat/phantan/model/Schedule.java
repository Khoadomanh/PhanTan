package com.example.nagat.phantan.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class Schedule {
    private String idNguoiDatLich;
    private Date thoiGianDat;
    private String tenKeHoach;
    private String ghiChu;
    private List<Tree> dsCayDinhTuoi;


    public Schedule(String idNguoiDatLich, Date thoiGianDat, String tenKeHoach, String ghiChu, List<Tree> dsCayDinhTuoi) {
        this.idNguoiDatLich = idNguoiDatLich;
        this.thoiGianDat = thoiGianDat;
        this.tenKeHoach = tenKeHoach;
        this.ghiChu = ghiChu;
        this.dsCayDinhTuoi = dsCayDinhTuoi;
    }

    public String getIdNguoiDatLich() {
        return idNguoiDatLich;
    }

    public void setIdNguoiDatLich(String idNguoiDatLich) {
        this.idNguoiDatLich = idNguoiDatLich;
    }

    public Date getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Date thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public String getTenKeHoach() {
        return tenKeHoach;
    }

    public void setTenKeHoach(String tenKeHoach) {
        this.tenKeHoach = tenKeHoach;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<Tree> getDsCayDinhTuoi() {
        return dsCayDinhTuoi;
    }

    public void setDsCayDinhTuoi(List<Tree> dsCayDinhTuoi) {
        this.dsCayDinhTuoi = dsCayDinhTuoi;
    }
}

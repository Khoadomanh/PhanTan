package com.example.nagat.phantan.model;

import java.util.List;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class WaterStation {
    private String idTramLayNuoc;
    private String trangThai;
    private int dungTichTram;
    private int dungTichThucTe;
    private String diaDiem;
    private List<User> dsNguoiDangLayNuoc;
    private List<HistoryWaterStation> lichSuLayNuoc;

    public WaterStation(String idTramLayNuoc, String trangThai, int dungTichTram, int dungTichThucTe, String diaDiem, List<User> dsNguoiDangLayNuoc, List<HistoryWaterStation> lichSuLayNuoc) {
        this.idTramLayNuoc = idTramLayNuoc;
        this.trangThai = trangThai;
        this.dungTichTram = dungTichTram;
        this.dungTichThucTe = dungTichThucTe;
        this.diaDiem = diaDiem;
        this.dsNguoiDangLayNuoc = dsNguoiDangLayNuoc;
        this.lichSuLayNuoc = lichSuLayNuoc;
    }

    public String getIdTramLayNuoc() {

        return idTramLayNuoc;
    }

    public void setIdTramLayNuoc(String idTramLayNuoc) {
        this.idTramLayNuoc = idTramLayNuoc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getDungTichTram() {
        return dungTichTram;
    }

    public void setDungTichTram(int dungTichTram) {
        this.dungTichTram = dungTichTram;
    }

    public int getDungTichThucTe() {
        return dungTichThucTe;
    }

    public void setDungTichThucTe(int dungTichThucTe) {
        this.dungTichThucTe = dungTichThucTe;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public List<User> getDsNguoiDangLayNuoc() {
        return dsNguoiDangLayNuoc;
    }

    public void setDsNguoiDangLayNuoc(List<User> dsNguoiDangLayNuoc) {
        this.dsNguoiDangLayNuoc = dsNguoiDangLayNuoc;
    }

    public List<HistoryWaterStation> getLichSuLayNuoc() {
        return lichSuLayNuoc;
    }

    public void setLichSuLayNuoc(List<HistoryWaterStation> lichSuLayNuoc) {
        this.lichSuLayNuoc = lichSuLayNuoc;
    }
}

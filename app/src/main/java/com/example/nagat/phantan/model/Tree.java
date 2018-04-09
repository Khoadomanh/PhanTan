package com.example.nagat.phantan.model;

import android.media.Image;

import java.util.List;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class Tree {
    private String idCay;
    private String tenCay;
    private String diaDiem;
    private int luongNuocMax;
    private int luongNuocHienTai;
    private String trangThai;
    private List<Image> anhCuaCay;
    private List<HistoryWaterTree> lichSuTuoiCay;
    private static User nguoiDangTuoiCay;

    public Tree(String idCay, String tenCay, String diaDiem, int luongNuocMax, int luongNuocHienTai, String trangThai) {
        this.idCay = idCay;
        this.tenCay = tenCay;
        this.diaDiem = diaDiem;
        this.luongNuocMax = luongNuocMax;
        this.luongNuocHienTai = luongNuocHienTai;
        this.trangThai = trangThai;
    }

    public Tree(String idCay, String tenCay, String diaDiem, int luongNuocMax, int luongNuocHienTai, String trangThai, List<Image> anhCuaCay, List<HistoryWaterTree> lichSuTuoiCay) {
        this.idCay = idCay;
        this.tenCay = tenCay;
        this.diaDiem = diaDiem;
        this.luongNuocMax = luongNuocMax;
        this.luongNuocHienTai = luongNuocHienTai;
        this.trangThai = trangThai;
        this.anhCuaCay = anhCuaCay;
        this.lichSuTuoiCay = lichSuTuoiCay;
    }

    public String getIdCay() {

        return idCay;
    }

    public void setIdCay(String idCay) {
        this.idCay = idCay;
    }

    public String getTenCay() {
        return tenCay;
    }

    public void setTenCay(String tenCay) {
        this.tenCay = tenCay;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public int getLuongNuocMax() {
        return luongNuocMax;
    }

    public void setLuongNuocMax(int luongNuocMax) {
        this.luongNuocMax = luongNuocMax;
    }

    public int getLuongNuocHienTai() {
        return luongNuocHienTai;
    }

    public void setLuongNuocHienTai(int luongNuocHienTai) {
        this.luongNuocHienTai = luongNuocHienTai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<Image> getAnhCuaCay() {
        return anhCuaCay;
    }

    public void setAnhCuaCay(List<Image> anhCuaCay) {
        this.anhCuaCay = anhCuaCay;
    }

    public List<HistoryWaterTree> getLichSuTuoiCay() {
        return lichSuTuoiCay;
    }

    public void setLichSuTuoiCay(List<HistoryWaterTree> lichSuTuoiCay) {
        this.lichSuTuoiCay = lichSuTuoiCay;
    }

    public static User getNguoiDangTuoiCay() {
        return nguoiDangTuoiCay;
    }

    public static void setNguoiDangTuoiCay(User nguoiDangTuoiCay) {
        Tree.nguoiDangTuoiCay = nguoiDangTuoiCay;
    }
}

package com.example.nagat.phantan.utils;

import com.example.nagat.phantan.model.LichSuTuoiCayTheoCay;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoNguoiTuoi;
import com.example.nagat.phantan.model.Sensor;
import com.example.nagat.phantan.model.Tree;
import com.example.nagat.phantan.ui.LoginActivity;
import com.example.nagat.phantan.ui.Utils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagat on 27/4/2018.
 */

public class API {
    public static void setHistory(final String maSensor, final String maNguoiTuoi, final String tenNguoiTuoi, final String vaiTroNguoiTuoi, final String keyTree, final String tenCay) {
        FirebaseDatabase.getInstance().getReference().child("sensors").child(maSensor).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sensor sensor = dataSnapshot.getValue(Sensor.class);
                LichSuTuoiCayTheoCay lichSuTuoiCayTheoCay = new LichSuTuoiCayTheoCay();
                lichSuTuoiCayTheoCay.setMaNguoiTuoi(maNguoiTuoi);
                lichSuTuoiCayTheoCay.setNgayGioTuoi(System.currentTimeMillis());
                lichSuTuoiCayTheoCay.setLuongNuocTuoi(sensor.getLuongNuocHienTai()-sensor.getLuongNuocTruocDo());
                lichSuTuoiCayTheoCay.setTenNguoiTuoi(tenNguoiTuoi);
                lichSuTuoiCayTheoCay.setVaiTroNguoiToi(vaiTroNguoiTuoi);
                FirebaseDatabase.getInstance().getReference().child("LichSuTuoiCayTheoCay").child(keyTree).push().setValue(lichSuTuoiCayTheoCay);
                LichSuTuoiCayTheoNguoiTuoi lichSuTuoiCayTheoNguoiTuoi = new LichSuTuoiCayTheoNguoiTuoi();
                lichSuTuoiCayTheoNguoiTuoi.setLuongNuocTuoi(sensor.getLuongNuocHienTai()-sensor.getLuongNuocTruocDo());
                lichSuTuoiCayTheoNguoiTuoi.setMaCayTuoi(keyTree);
                lichSuTuoiCayTheoNguoiTuoi.setTenCayTuoi(tenCay);
                lichSuTuoiCayTheoNguoiTuoi.setThoiGianTuoi(System.currentTimeMillis());
                FirebaseDatabase.getInstance().getReference().child("LichSuTuoiCayTheoNguoiTuoi").child(Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL)).push().setValue(lichSuTuoiCayTheoNguoiTuoi);
                FirebaseDatabase.getInstance().getReference().child("sensors").child(maSensor).child("luongNuocTruocDo").setValue(sensor.getLuongNuocHienTai());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public static List<Tree> getAllTree() {
        final List<Tree> trees = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("trees").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Tree tree = dataSnapshot.getValue(Tree.class);
                trees.add(tree);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return trees;
    }

}

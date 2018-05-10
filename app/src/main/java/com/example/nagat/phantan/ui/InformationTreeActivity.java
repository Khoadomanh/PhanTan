package com.example.nagat.phantan.ui;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.nagat.phantan.BaseActivity;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.adapter.HistoryWaterTreeForTreeAdapter;
import com.example.nagat.phantan.fragment.FragmentHistoryWater;
import com.example.nagat.phantan.fragment.FragmentReportTreeToAdmin;
import com.example.nagat.phantan.fragment.FragmentWaterTreeForTree;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoCay;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoNguoiTuoi;
import com.example.nagat.phantan.model.Sensor;
import com.example.nagat.phantan.model.Tree;
import com.example.nagat.phantan.model.User;
import com.example.nagat.phantan.utils.Contants;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Date;

public class InformationTreeActivity extends BaseActivity {
    private String keyTree;
    private Tree currentTree;
    private ValueEventListener valueEventListenerTree;
    private ValueEventListener valueEventListenerSensor;
    private TextView tvTenTree;
    private TextView tvDiaDiemTree;
    private TextView luongNuocDaTuoi;
    private SeekBar seekBar;
    private TextView tvTrangThaiCay;
    private Button btTuoiCay;
    private Button btTuoiCayXong;
    private TextView tvNguoiDangTuoi;
    private double luongNuocMax;
    private String idNguoiDangNhap;
    private ArrayList<ImageView> arrHinhAnh = new ArrayList<>();
    private String maSensor;
    private String tenCay;
    private TextView tvLuongNuocDaTuoi;
    private TextView tvLuongNuocHienTai;
    private TextView tvLuongNuocMax;
    private Button btLichSuCay;
    private Button btTimDuongToiCay;
    private double latitude;
    private double longitude;
    private Button btReport;
    private RelativeLayout rl_tinh_nguyen_vien;
    private RelativeLayout rl_nhan_vien;
    private Button btReportTNV;
    private Button btTimDuongTNV;
    private boolean dangTuoi = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_tree);
        keyTree = getIntent().getStringExtra(Contants.KEYTREE);
        if (keyTree == null) {
            throw new IllegalArgumentException("Must pass EXTRA_POST_KEY");
        }
        this.setupUI(this.getWindow().getDecorView().findViewById(android.R.id.content));
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        idNguoiDangNhap = Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL);

        rl_nhan_vien = findViewById(R.id.view_nhan_cong);
        rl_tinh_nguyen_vien = findViewById(R.id.view_tinh_nguyen_vien);
        if (MainActivity.vaiTro.equals(Contants.NHAN_VIEN)) {
            rl_nhan_vien.setVisibility(View.VISIBLE);
            rl_tinh_nguyen_vien.setVisibility(View.GONE);
        } else {
            rl_nhan_vien.setVisibility(View.GONE);
            rl_tinh_nguyen_vien.setVisibility(View.VISIBLE);
        }

        btReportTNV = findViewById(R.id.btReportTNV);
        btTimDuongTNV = findViewById(R.id.btTimDuongTNV);
        btReportTNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentReportTreeToAdmin fragmentReportTreeToAdmin = new FragmentReportTreeToAdmin(currentTree);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.full, fragmentReportTreeToAdmin);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btTimDuongTNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new LatLng(latitude, longitude));
                onBackPressed();
            }
        });
        //setColor statusbar
        tvLuongNuocDaTuoi = findViewById(R.id.luongNuocDaTuoi);
        tvLuongNuocHienTai = findViewById(R.id.luongNuocHienTai);
        tvLuongNuocMax = findViewById(R.id.luongNuocMax);
        btReport = findViewById(R.id.btReport);
        btReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentReportTreeToAdmin fragmentReportTreeToAdmin = new FragmentReportTreeToAdmin(currentTree);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.full, fragmentReportTreeToAdmin);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btTimDuongToiCay = findViewById(R.id.btTimDuong);
        btTimDuongToiCay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new LatLng(latitude, longitude));
                onBackPressed();
            }
        });
        btLichSuCay = findViewById(R.id.btLichSu);
        btLichSuCay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentWaterTreeForTree fragmentHistoryWater = new FragmentWaterTreeForTree(keyTree);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.full, fragmentHistoryWater);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        tvTenTree = findViewById(R.id.name_tree);
        tvDiaDiemTree = findViewById(R.id.address_tree);
        luongNuocDaTuoi = findViewById(R.id.luongNuocDaTuoi);
        seekBar = findViewById(R.id.mSeekBar);
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        btTuoiCay = findViewById(R.id.btTuoiCay);
        btTuoiCay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child("trees").child(keyTree).child("currentUserWatering").setValue(MainActivity.USERCURRENT);
                FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL)).child("treeWatering").setValue(keyTree);
                dangTuoi = true;
            }
        });
        btTuoiCayXong = findViewById(R.id.btDoneWater);
        btTuoiCayXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khi nguoi dung an vao tuoi cay xong
                MyUtil.showDialog(InformationTreeActivity.this, "Tưới Cây Xong", "Bạn có chắc đã hoàn thành việc tưới cây?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("trees").child(keyTree).child("currentUserWatering").setValue(null);
                        FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL)).child("treeWatering").setValue(null);
                        dangTuoi = false;
                        setHistory();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // click no dothing
                    }
                });

                //set lich su tuoi cay is here;

            }
        });
        tvNguoiDangTuoi = findViewById(R.id.currentWater);
        tvTrangThaiCay = findViewById(R.id.trangThaiCay);
        ImageView imageView1 = findViewById(R.id.piture1);
        ImageView imageView2 = findViewById(R.id.piture2);
        ImageView imageView3 = findViewById(R.id.piture3);
        arrHinhAnh.add(imageView1);
        arrHinhAnh.add(imageView2);
        arrHinhAnh.add(imageView3);
        valueEventListenerTree = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final Tree tree = dataSnapshot.getValue(Tree.class);
                currentTree = tree;
                tvTenTree.setText(tree.getTenCay());
                tenCay = tree.getTenCay();
                tvDiaDiemTree.setText(tree.getDiaDiem());
                luongNuocMax = tree.getLuongNuocMax();
                latitude = tree.getLatitude();
                longitude = tree.getLongitude();
                tvLuongNuocMax.setText(luongNuocMax + " ml");
                tvTrangThaiCay.setText("Trạng thái cây: " + tree.getTrangThai());
                seekBar.setMax((int) luongNuocMax);
                if (tree.getHinhAnh() != null) {
                    //set hinh anh is here;
                }
                if (tree.getCurrentUserWatering() != null) {
                    if (Utils.usernameFromEmail(tree.getCurrentUserWatering().getEmail()).equals(idNguoiDangNhap)) {
                        btTuoiCayXong.setVisibility(View.VISIBLE);
                        btTuoiCay.setVisibility(View.GONE);
                        tvNguoiDangTuoi.setVisibility(View.GONE);
                    } else if (tree.getCurrentUserWatering() != null) {
                        btTuoiCayXong.setVisibility(View.GONE);
                        btTuoiCay.setVisibility(View.GONE);
                        tvNguoiDangTuoi.setVisibility(View.VISIBLE);
                        tvNguoiDangTuoi.setText("Người đang tưới: " + tree.getCurrentUserWatering().getMaUser());
                    } else {
                        btTuoiCayXong.setVisibility(View.GONE);
                        btTuoiCay.setVisibility(View.VISIBLE);
                        tvNguoiDangTuoi.setVisibility(View.GONE);

                    }
                } else {
                    btTuoiCayXong.setVisibility(View.GONE);
                    btTuoiCay.setVisibility(View.VISIBLE);
                    tvNguoiDangTuoi.setVisibility(View.GONE);
                }
                FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL)).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        String treeWatering = user.getTreeWatering();
                        maNguoiTuoi = user.getMaUser();
                        tenNguoiTuoi = user.getTenHienThi();
                        vaiTroNguoiTuoi = user.getVaiTro();
                        if (treeWatering != null) {
                            if (!treeWatering.equals(keyTree)) {
                                btTuoiCayXong.setVisibility(View.GONE);
                                btTuoiCay.setVisibility(View.GONE);
                                tvNguoiDangTuoi.setVisibility(View.VISIBLE);
                                tvNguoiDangTuoi.setText("Bạn đang tưới cây: " + treeWatering);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                maSensor = tree.getMaSensor().getIdSensor();
                getSensor(tree.getMaSensor().getIdSensor());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        FirebaseDatabase.getInstance().getReference().child("trees").child(keyTree).addValueEventListener(valueEventListenerTree);
    }

    private String maNguoiTuoi;
    private String tenNguoiTuoi;
    private String vaiTroNguoiTuoi;

    private void setHistory() {
        FirebaseDatabase.getInstance().getReference().child("sensors").child(maSensor).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sensor sensor = dataSnapshot.getValue(Sensor.class);
                if ((sensor.getLuongNuocHienTai() - sensor.getLuongNuocTruocDo()) > 0) {
                    LichSuTuoiCayTheoCay lichSuTuoiCayTheoCay = new LichSuTuoiCayTheoCay();
                    lichSuTuoiCayTheoCay.setMaNguoiTuoi(maNguoiTuoi);
                    lichSuTuoiCayTheoCay.setNgayGioTuoi(System.currentTimeMillis());
                    lichSuTuoiCayTheoCay.setLuongNuocTuoi(sensor.getLuongNuocHienTai() - sensor.getLuongNuocTruocDo());
                    lichSuTuoiCayTheoCay.setTenNguoiTuoi(tenNguoiTuoi);
                    lichSuTuoiCayTheoCay.setVaiTroNguoiToi(vaiTroNguoiTuoi);
                    FirebaseDatabase.getInstance().getReference().child("LichSuTuoiCayTheoCay").child(keyTree).push().setValue(lichSuTuoiCayTheoCay);
                    LichSuTuoiCayTheoNguoiTuoi lichSuTuoiCayTheoNguoiTuoi = new LichSuTuoiCayTheoNguoiTuoi();
                    lichSuTuoiCayTheoNguoiTuoi.setLuongNuocTuoi(sensor.getLuongNuocHienTai() - sensor.getLuongNuocTruocDo());
                    lichSuTuoiCayTheoNguoiTuoi.setMaCayTuoi(keyTree);
                    lichSuTuoiCayTheoNguoiTuoi.setTenCayTuoi(tenCay);
                    lichSuTuoiCayTheoNguoiTuoi.setThoiGianTuoi(System.currentTimeMillis());
                    FirebaseDatabase.getInstance().getReference().child("LichSuTuoiCayTheoNguoiTuoi").child(Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL)).push().setValue(lichSuTuoiCayTheoNguoiTuoi);
                    FirebaseDatabase.getInstance().getReference().child("sensors").child(maSensor).child("luongNuocTruocDo").setValue(sensor.getLuongNuocHienTai());
                    FirebaseDatabase.getInstance().getReference().child("trees").child(keyTree).child("maSensor").child("luongNuocTruocDo").setValue(sensor.getLuongNuocHienTai());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private boolean tuoiQuaNuoc = false;

    private void getSensor(String maSensor) {
        valueEventListenerSensor = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sensor sensor = dataSnapshot.getValue(Sensor.class);
                seekBar.setProgress((int) sensor.getLuongNuocHienTai());
                tvLuongNuocHienTai.setText(sensor.getLuongNuocHienTai() + " ml");
                if (sensor.getLuongNuocHienTai() > luongNuocMax) {
                    if (!tuoiQuaNuoc) {
                        if (dangTuoi) {
                            tuoiQuaNuoc = true;
                            show();
                        }

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        FirebaseDatabase.getInstance().getReference().child("sensors").child(maSensor).addValueEventListener(valueEventListenerSensor);
    }

    private void show() {
        MyUtil.showDialog(this, "Cảnh báo", "Cây đã đủ lượng nước", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (valueEventListenerTree != null) {
            FirebaseDatabase.getInstance().getReference().child("trees").child(keyTree).removeEventListener(valueEventListenerTree);
        }
        super.onDestroy();
    }
}

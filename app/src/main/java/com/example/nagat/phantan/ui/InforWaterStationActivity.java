package com.example.nagat.phantan.ui;

import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nagat.phantan.BaseActivity;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.fragment.FragmentReportWaterStationToAdmin;
import com.example.nagat.phantan.model.WaterStation;
import com.example.nagat.phantan.utils.Contants;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;

import de.hdodenhof.circleimageview.CircleImageView;

public class InforWaterStationActivity extends BaseActivity {
    private String keyWaterStation;
    private WaterStation currentWaterStation;
    private TextView name_water_station;
    private TextView address_water_station;
    private TextView dung_tich_chua;
    private TextView trang_thai;
    private Button btChiDuong;
    private Button btReport;
    private RelativeLayout rlHetNuoc;
    private CircleImageView avatar_tree;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_water_station);
        this.setupUI(this.getWindow().getDecorView().findViewById(android.R.id.content));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        avatar_tree = findViewById(R.id.avatar_tree);
        imageView1 = findViewById(R.id.piture1);
        imageView2 = findViewById(R.id.piture2);
        imageView3 = findViewById(R.id.piture3);
        //setColor statusbar
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
        }
        keyWaterStation = getIntent().getStringExtra(Contants.KEYWATERSTATION);
        if (keyWaterStation == null) {
            throw new IllegalArgumentException("Must pass EXTRA_WATER_STATION");
        }
        name_water_station = findViewById(R.id.name_water_station);
        address_water_station = findViewById(R.id.address_water_station);
        dung_tich_chua = findViewById(R.id.dung_tich_chua);
        trang_thai = findViewById(R.id.trang_thai);
        btChiDuong = findViewById(R.id.btChiDuong);
        btReport = findViewById(R.id.btReport);
        btReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentReportWaterStationToAdmin fragmentReportWaterStationToAdmin = new FragmentReportWaterStationToAdmin(currentWaterStation);
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.full,fragmentReportWaterStationToAdmin);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        rlHetNuoc = findViewById(R.id.rlHetNuoc);
        btChiDuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new LatLng(latitude,longitude));
                onBackPressed();
            }
        });
        initUI();
    }
    private void initUI() {
        FirebaseDatabase.getInstance().getReference().child("water-station").child(keyWaterStation).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WaterStation waterStation = dataSnapshot.getValue(WaterStation.class);
                currentWaterStation = waterStation;
                latitude = waterStation.getLatitude();
                longitude = waterStation.getLongitude();
                name_water_station.setText(waterStation.getTenTram());
                address_water_station.setText(waterStation.getDiaDiem());
                dung_tich_chua.setText(MyUtil.convertMLToL(waterStation.getDungTichChua()));
                trang_thai.setText(waterStation.getTinhTrang());
                if (waterStation.getHinhAnh().size()>2) {
                    Glide.with(InforWaterStationActivity.this)
                            .load(waterStation.getHinhAnh().get(0))
                            .override(50,50)
                            .centerCrop()
                            .fitCenter()
                            .placeholder(R.drawable.loading)
                            .into(avatar_tree);
                    Glide.with(InforWaterStationActivity.this)
                            .load(waterStation.getHinhAnh().get(0))
                            .override(100,100)
                            .centerCrop()
                            .fitCenter()
                            .placeholder(R.drawable.loading)
                            .into(imageView1);
                    Glide.with(InforWaterStationActivity.this)
                            .load(waterStation.getHinhAnh().get(1))
                            .override(100,100)
                            .centerCrop()
                            .fitCenter()
                            .placeholder(R.drawable.loading)
                            .into(imageView2);
                    Glide.with(InforWaterStationActivity.this)
                            .load(waterStation.getHinhAnh().get(2))
                            .override(100,100)
                            .centerCrop()
                            .fitCenter()
                            .placeholder(R.drawable.loading)
                            .into(imageView3);
                }
                if (waterStation.getTinhTrang().equals(Contants.HET_NUOC)) {
                    rlHetNuoc.setVisibility(View.VISIBLE);
                } else {
                    rlHetNuoc.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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


}

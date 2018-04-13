package com.example.nagat.phantan.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.nagat.phantan.BaseActivity;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.common.GPSTracker;
import com.example.nagat.phantan.fragment.FragmentBanDo;
import com.example.nagat.phantan.fragment.FragmentHistoryWater;
import com.example.nagat.phantan.fragment.FragmentInfor;
import com.example.nagat.phantan.fragment.FragmentListTree;
import com.example.nagat.phantan.fragment.FragmentReportToAdmin;
import com.example.nagat.phantan.fragment.FragmentSchedule;
import com.example.nagat.phantan.model.User;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private TextView navTenNguoiDung;
    private TextView navChucVu;
    private TextView navViTriHienTai;
    private ValueEventListener valueEventListener;
    private int menuId = R.menu.menu_ban_do;
    private String email = FirebaseAuth.getInstance()
            .getCurrentUser().getEmail();
    private CircleImageView imAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setupUI(this.getWindow().getDecorView().findViewById(android.R.id.content));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        0);
        } else {
            // Permission has already been granted
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        displaySelectedScreen(R.id.item_maps);
        FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(FirebaseAuth.getInstance()
                .getCurrentUser().getEmail())).child("trangThai").onDisconnect().setValue("offline");
        updateStatusEachSecond(FirebaseAuth.getInstance()
                .getCurrentUser());
        navTenNguoiDung = headerView.findViewById(R.id.navTenNguoiDung);
        navChucVu = headerView.findViewById(R.id.navChucVu);
        navViTriHienTai = headerView.findViewById(R.id.navViTriHienTai);
        imAvatar = headerView.findViewById(R.id.imageView);
        initUI();
    }


    public void onChangeAvatar(){
        Glide.with(this).load(MyUtil.PATH_AVATA).into(imAvatar);
    }


    private void initUI() {
//        GPSTracker gpsTracker = new GPSTracker(this);
//        gpsTracker.getClassLoader();
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user;
                if (dataSnapshot!=null) {
                    user = dataSnapshot.getValue(User.class);
                    navTenNguoiDung.setText(user.getTenHienThi());
                    navChucVu.setText(user.getVaiTro());
                    if(MyUtil.PATH_AVATA == null){
                        MyUtil.setImageUser(user.getAvatar(),imAvatar);
                    }
                    else{
                        Glide.with(MainActivity.this).load(MyUtil.PATH_AVATA).into(imAvatar);
                    }
                    Log.e(TAG,"address: "+Utils.getAddressFromLatAndLong(user.getLatitude(),user.getLongitude()));
                    navViTriHienTai.setText(Utils.getAddressFromLatAndLong(user.getLatitude(),user.getLongitude()));
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(FirebaseAuth.getInstance()
                .getCurrentUser().getEmail())).addValueEventListener(valueEventListener);
    }
    private void updateStatusEachSecond(final FirebaseUser firebaseUser) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (FirebaseAuth.getInstance().getCurrentUser()!= null) {
                    FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(firebaseUser.getEmail())).child("trangThai").setValue("online");
                }

            }
        },0,1000);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(menuId, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);
        if (item.getItemId() == R.id.item_signout) {
            signOut();
        }
        return true;
    }
    private void signOut() {
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail()));
        databaseReference.child("trangThai").setValue("offline");
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        if (itemId == R.id.item_maps) {
            fragment = new FragmentBanDo();
            menuId = R.menu.menu_ban_do;
            invalidateOptionsMenu();
        } else if (itemId == R.id.item_schelude) {
            fragment = new FragmentSchedule();
            menuId = R.menu.menu_dat_lich;
            invalidateOptionsMenu();
        } else if (itemId == R.id.item_history) {
            fragment = new FragmentHistoryWater();
            menuId = R.menu.menu_ban_do;
            invalidateOptionsMenu();

        } else if (itemId == R.id.item_edit) {

        } else if (itemId == R.id.item_report) {
            fragment = new FragmentReportToAdmin();
            menuId = R.menu.menu_ban_do;
            invalidateOptionsMenu();

        } else if (itemId == R.id.item_signout) {

        } else if(itemId == R.id.change_infor){
            fragment = new FragmentInfor();
            menuId = R.menu.menu_ban_do;
            invalidateOptionsMenu();
        }else if(itemId == R.id.item_list_tree){
            fragment = new FragmentListTree();
            menuId = R.menu.menu_ban_do;
            invalidateOptionsMenu();

        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    protected void onDestroy() {
        if (valueEventListener!=null) {
            FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(email)).removeEventListener(valueEventListener);
        }
        super.onDestroy();
    }
}

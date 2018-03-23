package com.example.nagat.phantan;

import android.Manifest;
import android.content.pm.PackageManager;
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
import android.view.Menu;
import android.view.MenuItem;


import com.example.nagat.phantan.fragment.FragmentBanDo;
import com.example.nagat.phantan.fragment.FragmentHistoryWater;
import com.example.nagat.phantan.fragment.FragmentInfor;
import com.example.nagat.phantan.fragment.FragmentListTree;
import com.example.nagat.phantan.fragment.FragmentReportToAdmin;
import com.example.nagat.phantan.fragment.FragmentSchedule;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int menuId = R.menu.menu_ban_do;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        navigationView.setNavigationItemSelectedListener(this);
        displaySelectedScreen(R.id.item_maps);
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

        return true;
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
}

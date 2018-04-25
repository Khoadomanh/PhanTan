package com.example.nagat.phantan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.nagat.phantan.fragment.FragmentListReportTree;
import com.example.nagat.phantan.fragment.FragmentListReportWaterStation;

/**
 * Created by nagat on 25/4/2018.
 */



public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new FragmentListReportTree();
                break;
            case 1:
                frag = new FragmentListReportWaterStation();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Tình trạng cây";
                break;
            case 1:
                title = "Tình trạng nguồn nước";
                break;
        }
        return title;
    }
}

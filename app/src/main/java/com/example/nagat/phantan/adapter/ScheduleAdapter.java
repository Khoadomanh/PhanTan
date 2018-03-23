package com.example.nagat.phantan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.HistoryWaterTree;
import com.example.nagat.phantan.model.Schedule;

import java.util.ArrayList;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>{

    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<Schedule> list;

    public ScheduleAdapter(Context con, ArrayList<Schedule> list) {
        mContext = con;
        layoutInflater = LayoutInflater.from(mContext);
        this.list = list;
    }

    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater
                .inflate(R.layout.item_schelude, parent, false);

        return new ScheduleAdapter.ScheduleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ScheduleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        public ScheduleViewHolder(View itemView) {
            super(itemView);
        }
    }
}
package com.example.nagat.phantan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.HistoryWaterTree;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class HistoryWaterTreeAdapter extends RecyclerView.Adapter<HistoryWaterTreeAdapter.ListHistoryViewHolder>{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private ArrayList<HistoryWaterTree> list;

        public HistoryWaterTreeAdapter(Context con, ArrayList<HistoryWaterTree> list) {
            mContext = con;
            layoutInflater = LayoutInflater.from(mContext);
            this.list = list;
        }

        @Override
        public ListHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = layoutInflater
                    .inflate(R.layout.item_history, parent, false);

            return new ListHistoryViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ListHistoryViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

    public class ListHistoryViewHolder extends RecyclerView.ViewHolder{
        public ListHistoryViewHolder(View itemView) {
            super(itemView);
        }
    }
}
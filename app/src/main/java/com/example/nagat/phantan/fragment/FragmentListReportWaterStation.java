package com.example.nagat.phantan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.adapter.OnClickLisner;
import com.example.nagat.phantan.adapter.ReportTreeAdapter;
import com.example.nagat.phantan.adapter.ReportWaterStationAdapter;
import com.example.nagat.phantan.ui.InforWaterStationActivity;
import com.example.nagat.phantan.ui.InformationTreeActivity;
import com.example.nagat.phantan.utils.Contants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nagat on 25/4/2018.
 */

public class FragmentListReportWaterStation  extends Fragment{

    public FragmentListReportWaterStation() {
        // Required empty public constructor
    }


    RecyclerView rv;
    ReportWaterStationAdapter adapter;
    DatabaseReference mDatabaseReference;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_list_tree, container, false);
        rv = v.findViewById(R.id.rv_list_tree);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("report-water-station");
        adapter = new ReportWaterStationAdapter(getActivity(),mDatabaseReference);
        adapter.setOnClickLisner(new OnClickLisner() {
            @Override
            public void OnClick(String key) {
                Intent intent = new Intent(getActivity(), InforWaterStationActivity.class);
                intent.putExtra(Contants.KEYWATERSTATION,key);
                startActivity(intent);
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        return v;
    }
}
package com.example.nagat.phantan.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.adapter.HistoryWaterTreeAdapter;
import com.example.nagat.phantan.adapter.HistoryWaterTreeForTreeAdapter;
import com.example.nagat.phantan.ui.InformationTreeActivity;
import com.example.nagat.phantan.ui.LoginActivity;
import com.example.nagat.phantan.ui.Utils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nagat on 19/4/2018.
 */

@SuppressLint("ValidFragment")
public class FragmentWaterTreeForTree extends Fragment {
    RecyclerView rv;
    HistoryWaterTreeForTreeAdapter adapter;
    DatabaseReference mDatabaseReference;
    private String keyTree;
    private TextView tvTitle;
    private ImageView imageView;

    public FragmentWaterTreeForTree(String keyTree) {
        this.keyTree = keyTree;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("LichSuTuoiCayTheoCay").child(keyTree);
        adapter  = new HistoryWaterTreeForTreeAdapter(getActivity(),mDatabaseReference);
        View v =  inflater.inflate(R.layout.fragment_list_history_water_for_tree, container, false);
        tvTitle = v.findViewById(R.id.tvTitle);
        tvTitle.setText("Lịch Sử Tưới Cây "+keyTree);
        imageView = v.findViewById(R.id.ivBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        rv = v.findViewById(R.id.rv_history);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        return  v;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Lịch sử tưới cây");
    }
}

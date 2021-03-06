package com.example.nagat.phantan.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.adapter.HistoryWaterTreeAdapter;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoNguoiTuoi;
import com.example.nagat.phantan.ui.LoginActivity;
import com.example.nagat.phantan.ui.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class FragmentHistoryWater extends Fragment {
    RecyclerView rv;
    HistoryWaterTreeAdapter adapter;
    DatabaseReference mDatabaseReference;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_list_history_water, container, false);
        rv = v.findViewById(R.id.rv_history);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("LichSuTuoiCayTheoNguoiTuoi").child(Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL));
        adapter = new HistoryWaterTreeAdapter(getActivity(),mDatabaseReference);
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

package com.example.nagat.phantan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.adapter.ScheduleAdapter;
import com.example.nagat.phantan.model.Schedule;

import java.util.ArrayList;

/**
 * Created by nagat on 20/3/2018.
 */


public class FragmentSchedule extends Fragment {
    RecyclerView rv;
    ScheduleAdapter adapter;
    RelativeLayout rl_no_tran;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_schedule, container, false);
        rv = v.findViewById(R.id.rv_schelude);
        adapter = new ScheduleAdapter(getActivity(),new ArrayList<Schedule>());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        rl_no_tran = v.findViewById(R.id.rl_no_tran);
        rl_no_tran.setVisibility(View.GONE);
        return  v;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Kê hoạch");
    }
}
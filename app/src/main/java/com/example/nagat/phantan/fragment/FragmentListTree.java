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
import com.example.nagat.phantan.adapter.TreeAdapter;
import com.example.nagat.phantan.model.Tree;

import java.util.ArrayList;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class FragmentListTree extends Fragment {
    RecyclerView rv;
    TreeAdapter adapter;
    ArrayList<Tree> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_list_tree, container, false);
        rv = v.findViewById(R.id.rv_list_tree);

        adapter = new TreeAdapter(getActivity(),list);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        return  v;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Danh sách cây");
    }
}

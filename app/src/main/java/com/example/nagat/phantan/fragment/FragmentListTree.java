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
import com.example.nagat.phantan.adapter.TreeAdapter;
import com.example.nagat.phantan.model.HistoryWaterTree;
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

        Tree tree1 = new Tree("1", "Xà cừ", "D35", 500, 200, "Sống" );
        Tree tree2 = new Tree("2", "Bằng lăng", "T", 400, 200, "Sống" );
        Tree tree3 = new Tree("3", "Xà cừ", "TC", 500, 400, "Sống" );
        Tree tree4 = new Tree("4", "Bằng lăng", "D35", 400, 500, "Sống" );
        Tree tree5 = new Tree("5", "Xà cừ", "B1", 500, 200, "Sống" );
        Tree tree6 = new Tree("6", "Xoài", "D9", 400, 200, "Sống" );
        Tree tree7 = new Tree("7", "Xà cừ", "D35", 500, 200, "Chết" );
        Tree tree8 = new Tree("8", "Bằng lăng", "D35", 400, 200, "Sống" );

        list.add(tree1);
        list.add(tree2);
        list.add(tree3);
        list.add(tree4);
        list.add(tree5);
        list.add(tree6);
        list.add(tree7);
        list.add(tree8);


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

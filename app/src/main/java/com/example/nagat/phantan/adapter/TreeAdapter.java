package com.example.nagat.phantan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.Tree;

import java.util.ArrayList;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class TreeAdapter  extends RecyclerView.Adapter<TreeAdapter.ListTreeViewHolder> {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<Tree> list;

    public TreeAdapter(Context con, ArrayList<Tree> list) {
        mContext = con;
        layoutInflater = LayoutInflater.from(mContext);
        this.list = list;
    }

    @Override
    public TreeAdapter.ListTreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater
                .inflate(R.layout.item_list_tree, parent, false);

        return new TreeAdapter.ListTreeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TreeAdapter.ListTreeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ListTreeViewHolder extends RecyclerView.ViewHolder {
        public ListTreeViewHolder(View itemView) {
            super(itemView);
        }
    }

}
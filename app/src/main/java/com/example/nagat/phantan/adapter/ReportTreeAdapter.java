package com.example.nagat.phantan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.ReportTree;
import com.example.nagat.phantan.ui.InforWaterStationActivity;
import com.example.nagat.phantan.ui.Utils;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by nagat on 25/4/2018.
 */

public class ReportTreeAdapter extends RecyclerView.Adapter<ReportTreeAdapter.TreeViewHolder> {

    private List<ReportTree> list  = new ArrayList<>();;
    private LayoutInflater layoutInflater;
    private Context context;
    private DatabaseReference mDataBase;
    private OnClickLisner onClickLisner;
    public void setOnClickLisner (OnClickLisner onClickLisner) {
        this.onClickLisner = onClickLisner;
    }
    public ReportTreeAdapter(Context context,DatabaseReference mDataBase) {
        this.context = context;
        this.mDataBase = mDataBase;
        layoutInflater = LayoutInflater.from(context);
        mDataBase.orderByChild("timeSendReport").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ReportTree reportTree = dataSnapshot.getValue(ReportTree.class);
                list.add(reportTree);
                notifyItemInserted(list.size() -1 );
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @Override
    public TreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_report_tree,parent,false);
        return new TreeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TreeViewHolder holder, int position) {
        ReportTree reportTree = list.get(position);
        holder.id_tree.setText(reportTree.getTreeReport().getMaCay());
        holder.tv_date.setText("Ngày: "+ MyUtil.converLongDateToStringNgayThangName(reportTree.getTimeSendReport()));
        holder.tvReport.setText(reportTree.getMessageReport());
        if (reportTree.getTreeReport().getHinhAnh().size()>0) {
            Glide.with(context)
                    .load(reportTree.getTreeReport().getHinhAnh().get(0))
                    .override(50,50)
                    .centerCrop()
                    .fitCenter()
                    .placeholder(R.drawable.loading)
                    .into(holder.iv_avatar);
        }
        holder.setOnClick(reportTree.getTreeReport().getMaCay());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TreeViewHolder extends RecyclerView.ViewHolder {

        CircleImageView iv_avatar;
        TextView id_tree;
        TextView tv_date;
        TextView tvReport;
        View view;

        public TreeViewHolder(View itemView) {
            super(itemView);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
            id_tree = itemView.findViewById(R.id.id_tree);
            tv_date = itemView.findViewById(R.id.tv_date);
            tvReport = itemView.findViewById(R.id.tvReport);
            view = itemView;
        }
        void setOnClick(final String key) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickLisner.OnClick(key);
                }
            });
        }
    }
}

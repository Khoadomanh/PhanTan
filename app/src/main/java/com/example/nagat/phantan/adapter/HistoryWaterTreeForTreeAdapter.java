package com.example.nagat.phantan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoCay;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoNguoiTuoi;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class HistoryWaterTreeForTreeAdapter extends RecyclerView.Adapter<HistoryWaterTreeForTreeAdapter.ListHistoryViewHolder> {

    private static final String TAG = "LichSuTuoiCayTheoCay";
    private Context mContext;
    private LayoutInflater layoutInflater;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;
    private List<LichSuTuoiCayTheoCay> list = new ArrayList<>();
    private List<String> listIDs = new ArrayList<>();

    public HistoryWaterTreeForTreeAdapter(Context con, DatabaseReference mDatabaseReference) {
        mContext = con;
        layoutInflater = LayoutInflater.from(mContext);
        this.mDatabaseReference = mDatabaseReference;
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                LichSuTuoiCayTheoCay ls = dataSnapshot.getValue(LichSuTuoiCayTheoCay.class);
                listIDs.add(dataSnapshot.getKey());
                list.add(ls);
                notifyItemInserted(list.size() -1 );
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                LichSuTuoiCayTheoCay newLs = dataSnapshot.getValue(LichSuTuoiCayTheoCay.class);
                String keyHistory = dataSnapshot.getKey();

                int historyIndex = listIDs.indexOf(keyHistory);
                if (historyIndex >-1) {
                    list.set(historyIndex,newLs);
                    notifyItemChanged(historyIndex);
                } else {
                    Log.e(TAG, "onChildChanged:unknown_child:" + keyHistory);
                }

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String keyHistory = dataSnapshot.getKey();

                // [START_EXCLUDE]
                int historyIndex = listIDs.indexOf(keyHistory);
                if (historyIndex > -1) {
                    // Remove data from the list
                    listIDs.remove(historyIndex);
                    list.remove(historyIndex);

                    // Update the RecyclerView
                    notifyItemRemoved(historyIndex);
                } else {
                    Log.w(TAG, "onChildRemoved:unknown_child:" + keyHistory);
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "LichSuTuoiCayTheoCay:onCancelled", databaseError.toException());
                Toast.makeText(mContext, "Failed to load LichSuTuoiCayTheoNguoiTuoi.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        mDatabaseReference.orderByChild("ngayGioTuoi").addChildEventListener(childEventListener);
        mChildEventListener = childEventListener;
    }
    public void clearChildEventListener() {
        if (mChildEventListener!=null) {
            mDatabaseReference.removeEventListener(mChildEventListener);
        }
    }
    @Override
    public ListHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater
                .inflate(R.layout.item_history, parent, false);

        return new ListHistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListHistoryViewHolder holder, int position) {
        LichSuTuoiCayTheoCay ls = list.get(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvNgayTuoi;
        TextView tvMaCay;
        TextView tvTenCay;
        TextView tvLuongNuocTuoi;
        TextView tvThoiGianTuoiTheoGioPhut;

        public ListHistoryViewHolder(View itemView) {
            super(itemView);
            tvNgayTuoi = itemView.findViewById(R.id.date_water);
            tvMaCay = itemView.findViewById(R.id.maCay);
            tvTenCay = itemView.findViewById(R.id.tenCay);
            tvLuongNuocTuoi = itemView.findViewById(R.id.luongNuocTuoi);
            tvThoiGianTuoiTheoGioPhut = itemView.findViewById(R.id.thoiGianTuoi);
        }
    }
}
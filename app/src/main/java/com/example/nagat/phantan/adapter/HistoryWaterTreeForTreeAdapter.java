package com.example.nagat.phantan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoCay;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoNguoiTuoi;
import com.example.nagat.phantan.ui.Utils;
import com.example.nagat.phantan.utils.Contants;
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
                .inflate(R.layout.item_history_water_tree, parent, false);

        return new ListHistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListHistoryViewHolder holder, int position) {
        LichSuTuoiCayTheoCay ls = list.get(position);
        if (ls.getVaiTroNguoiToi().equals(Contants.TINH_NGUYEN_VIEN)) {
            //set Image tinh nguyen vien
        } else if (ls.getVaiTroNguoiToi().equals(Contants.NHAN_VIEN)) {
            //set Image nhan vien;
        } else {
            //set image cho admin;
        }
        holder.tv_date_history_water.setText(MyUtil.converLongDateToStringNgayThangName(ls.getNgayGioTuoi()));
        holder.tv_time_history_water.setText(MyUtil.converLongDateToStringGioPhut(ls.getNgayGioTuoi()));
        holder.tv_water.setText(ls.getLuongNuocTuoi()+" ml");
        holder.tv_name_people_history.setText(ls.getMaNguoiTuoi() +" "+ls.getTenNguoiTuoi());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListHistoryViewHolder extends RecyclerView.ViewHolder {

        ImageView img_role_people;
        TextView tv_date_history_water;
        TextView tv_time_history_water;
        TextView tv_water;
        TextView tv_name_people_history;

        public ListHistoryViewHolder(View itemView) {
            super(itemView);

            img_role_people = itemView.findViewById(R.id.img_role_people);
            tv_date_history_water = itemView.findViewById(R.id.tv_date_history_water);
            tv_time_history_water = itemView.findViewById(R.id.tv_time_history_water);
            tv_water = itemView.findViewById(R.id.tv_water);
            tv_name_people_history = itemView.findViewById(R.id.tv_name_people_history);
        }
    }
}
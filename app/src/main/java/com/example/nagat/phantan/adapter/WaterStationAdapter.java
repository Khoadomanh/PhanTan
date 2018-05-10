package com.example.nagat.phantan.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.Tree;
import com.example.nagat.phantan.model.WaterStation;
import com.example.nagat.phantan.ui.LoginActivity;
import com.example.nagat.phantan.ui.MainActivity;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by nagat on 24/4/2018.
 */

public class WaterStationAdapter extends RecyclerView.Adapter<WaterStationAdapter.WaterStationViewHolder> {
    private Context context;
    private DatabaseReference mDataBase;
    private LayoutInflater layoutInflater;
    private ArrayList<WaterStation> list = new ArrayList<>();
    private OnClickLisner onClickLisner;
    public void setOnClick(OnClickLisner onClickLisner) {
        this.onClickLisner = onClickLisner;
    }
    public WaterStationAdapter(Context context, DatabaseReference mDataBase) {
        this.context = context;
        this.mDataBase = mDataBase;
        layoutInflater = LayoutInflater.from(context);
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                WaterStation waterStation = dataSnapshot.getValue(WaterStation.class);
                list.add(waterStation);
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
        };
        mDataBase.orderByChild("tenTram").addChildEventListener(childEventListener);
    }

    @Override
    public WaterStationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list_water_station,parent,false);
        return new WaterStationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WaterStationViewHolder holder, int position) {
            WaterStation waterStation = list.get(position);
            holder.tv_status_list.setText(waterStation.getTinhTrang());
            double lat1 = MainActivity.USERCURRENT.getLatitude();
            double long1 = MainActivity.USERCURRENT.getLongitude();
            double lat2 = waterStation.getLatitude();
            double long2 = waterStation.getLongitude();
            holder.tv_distance.setText(MyUtil.convertDistanceToString(MyUtil.distanceBetweenUser(lat1,long1,lat2,long2)));
            holder.tv_address_water_station.setText(waterStation.getDiaDiem());
            holder.tv_name_water_station.setText(waterStation.getTenTram());
            if (waterStation.getHinhAnh().size()>0) {
                Glide.with(context)
                        .load(waterStation.getHinhAnh().get(0)) // image url
                        .placeholder(R.drawable.loading) // any placeholder to load at start// any image in case of error
                        .override(50, 50)// resizing
                        .centerCrop()
                        .into(holder.iv_water_station);
            }
            holder.setOnClick(waterStation.getTenTram());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class WaterStationViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name_water_station;
        private TextView tv_address_water_station;
        private TextView tv_distance;
        private TextView tv_status_list;
        private ImageView iv_water_station;
        private View view;
        public WaterStationViewHolder(View v ) {
            super(v);
            tv_name_water_station = v.findViewById(R.id.tv_name_water_station);
            tv_address_water_station = v.findViewById(R.id.tv_address_water_station);
            tv_distance = v.findViewById(R.id.tv_distance);
            tv_status_list = v.findViewById(R.id.tv_status_list);
            iv_water_station = v.findViewById(R.id.iv_water_station);
            view = v;

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

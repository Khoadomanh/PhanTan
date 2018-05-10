package com.example.nagat.phantan.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.LichSuTuoiCayTheoNguoiTuoi;
import com.example.nagat.phantan.model.Sensor;
import com.example.nagat.phantan.model.Tree;
import com.example.nagat.phantan.ui.InformationTreeActivity;
import com.example.nagat.phantan.ui.MainActivity;
import com.example.nagat.phantan.utils.Contants;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Win 8.1 Version 2 on 23/03/2018.
 */

public class TreeAdapter  extends RecyclerView.Adapter<TreeAdapter.ListTreeViewHolder> {

    private ValueEventListener valueEventListenerSensor;
    private static final String TAG = "trees";
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<Tree> list = new ArrayList<>();
    private OnClickLisner onClickLisner;
    public void setOnClickLisner (OnClickLisner onClickLisner) {
        this.onClickLisner = onClickLisner;
    }

    public TreeAdapter(Context con, DatabaseReference mDatabaseReference) {
        mContext = con;
        layoutInflater = LayoutInflater.from(mContext);
        this.mDatabaseReference = mDatabaseReference;
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Tree tree = dataSnapshot.getValue(Tree.class);
                list.add(tree);
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
                Log.e(TAG, "Trees:onCancelled", databaseError.toException());
                Toast.makeText(mContext, "Failed to load LichSuTuoiCayTheoNguoiTuoi.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        mDatabaseReference.orderByChild("maCay").addChildEventListener(childEventListener);
        mChildEventListener = childEventListener;


    }

    public void clearChildEventListener() {
        if (mChildEventListener!=null) {
            mDatabaseReference.removeEventListener(mChildEventListener);
        }
    }
    @Override
    public TreeAdapter.ListTreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater
                .inflate(R.layout.item_list_tree, parent, false);

        return new TreeAdapter.ListTreeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TreeAdapter.ListTreeViewHolder holder, int position) {
        Tree tree = list.get(position);
        if( tree.getHinhAnh().size() != 0)
        setImageTree(holder.ivTree, tree.getHinhAnh().get(0));
        holder.tvNameTree.setText(tree.getMaCay() + ": " + tree.getTenCay() );
        double lat1 = MainActivity.USERCURRENT.getLatitude();
        double long1 = MainActivity.USERCURRENT.getLongitude();
        double lat2 = tree.getLatitude();
        double long2 = tree.getLongitude();
        holder.tvDistance.setText(MyUtil.convertDistanceToString(MyUtil.distanceBetweenUser(lat1,long1,lat2,long2)));
        getSensor(tree.getMaSensor().getIdSensor(), holder.waterCurrent);
        holder.tvAddressTree.setText(tree.getDiaDiem());
        holder.statusTree.setText(tree.getTrangThai());
        holder.setOnClick(tree.getMaCay());

    }

    private  void setImageTree(CircleImageView image, String url){
        Glide.with(mContext)
                .load(url) // image url
                .placeholder(R.drawable.loading) // any placeholder to load at start// any image in case of error
                .override(50, 50)// resizing
        .centerCrop()
        .into(image);
    }

    private void getSensor(String maSensor, final TextView tv) {
        valueEventListenerSensor = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sensor sensor = dataSnapshot.getValue(Sensor.class);
                tv.setText(sensor.getLuongNuocHienTai()+" ml");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        FirebaseDatabase.getInstance().getReference().child("sensors").child(maSensor).addValueEventListener(valueEventListenerSensor);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListTreeViewHolder extends RecyclerView.ViewHolder {
//        ImageView imgRolePeople;
//        TextView tvDateWater;
//        TextView tvWater;
//        TextView tvNamePeople;
//        TextView tvTimeWater;

        CircleImageView ivTree;
        TextView tvNameTree;
        TextView tvDistance;
        TextView waterCurrent;
        TextView statusTree;
        TextView tvAddressTree;
        View view;
        public ListTreeViewHolder(View itemView) {
            super(itemView);
//            imgRolePeople = itemView.findViewById(R.id.img_role_people);
//            tvDateWater = itemView.findViewById(R.id.tv_date_history_water);
//            tvTimeWater = itemView.findViewById(R.id.tv_time_history_water);
//            tvWater = itemView.findViewById(R.id.tvWater);
//            tvNamePeople = itemView.findViewById(R.id.tv_name_people_history);
            ivTree = itemView.findViewById(R.id.iv_tree_list);
            tvNameTree = itemView.findViewById(R.id.tv_name_tree_list);
            tvDistance = itemView.findViewById(R.id.tv_distance);
            waterCurrent = itemView.findViewById(R.id.tv_water_current_list);
            statusTree = itemView.findViewById(R.id.tv_status_list);
            tvAddressTree = itemView.findViewById(R.id.tv_address_tree_list);
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
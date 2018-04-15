package com.example.nagat.phantan.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nagat.phantan.model.Tree;
import com.example.nagat.phantan.model.User;
import com.example.nagat.phantan.ui.InforWaterStationActivity;
import com.example.nagat.phantan.ui.InformationTreeActivity;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.ui.LoginActivity;
import com.example.nagat.phantan.ui.Utils;
import com.example.nagat.phantan.utils.Contants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagat on 20/3/2018.
 */

public class FragmentBanDo extends Fragment{
    private TextView tvInforTree;
    private GoogleMap mMap;
    private UiSettings mUiSettings;
    LatLng MELBOURNE = new LatLng(21.004364, 105.843980);
    List<Tree> listTree = new ArrayList<>();
    List<LatLng> listWaterStation = new ArrayList<>();

    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;
    MapFragment mapFragment;
    MapView mMapView;
    private GoogleMap googleMap;
    private String cayDangTuoi;
    private ChildEventListener childEventListener;
    public static FragmentBanDo init() {
        return new FragmentBanDo();
    }
    private TextView tvCayDangTuoi;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_test_map, container, false);
        addWaterStation();
        mMapView = (MapView) view.findViewById(R.id.mapView);
        tvCayDangTuoi = view.findViewById(R.id.cayDangTuoi);
        FirebaseDatabase.getInstance().getReference().child("users").child(Utils.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user.getTreeWatering()!=null ){
                    tvCayDangTuoi.setVisibility(View.VISIBLE);
                    cayDangTuoi = user.getTreeWatering();
                    tvCayDangTuoi.setText("Cây bạn đang tưới: "+user.getTreeWatering());
                } else {
                    tvCayDangTuoi.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        tvCayDangTuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InformationTreeActivity.class);
                intent.putExtra(Contants.KEYTREE,cayDangTuoi);
                startActivity(intent);
            }
        });
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                googleMap.setMyLocationEnabled(true);
                addTree();
                Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.ic_tree);
                Bitmap imgWater = BitmapFactory.decodeResource(getResources(), R.drawable.ic_water_station);

                int height = 50;
                int width = 50;


                Bitmap smallMarkerWater  = Bitmap.createScaledBitmap(imgWater, width, height, false);
                BitmapDescriptor bitmapDescriptorWater = BitmapDescriptorFactory.fromBitmap(smallMarkerWater);


                for(int i = 0; i < listWaterStation.size(); i++) {
                    Marker marker = googleMap.addMarker(new MarkerOptions()
                            .position(listWaterStation.get(i))
                            .title("D35_XC1110")
                            .snippet("Population: 4,137,400")
                            .icon(bitmapDescriptorWater)
                    );
                    marker.setTag(1);
                }


                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setRotateGesturesEnabled(false);
                googleMap.getUiSettings().setScrollGesturesEnabled(true);
                googleMap.getUiSettings().setTiltGesturesEnabled(false);

                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        Integer clickCount = (Integer) marker.getTag();
                        if (clickCount.compareTo(0) == 0) {
                            Intent intent = new Intent(getActivity(), InformationTreeActivity.class);
                            intent.putExtra(Contants.KEYTREE,marker.getTitle());
                            startActivity(intent);

                        }else if(clickCount.compareTo(1) == 0){
                            Intent intent = new Intent(getActivity(), InforWaterStationActivity.class);
                            startActivity(intent);
                        }
                        else{

                        }

                    }
                });

                CameraPosition cameraPosition = new CameraPosition.Builder().target(MELBOURNE).zoom(16).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        return view;
    }
   private void addMarker(Tree tree) {
       final Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.ic_tree);
       int height = 50;
       int width = 50;
       final Bitmap smallMarker = Bitmap.createScaledBitmap(img, width, height, false);
       final BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(smallMarker);
       Marker marker = googleMap.addMarker(new MarkerOptions()
               .position(new LatLng(tree.getLatitude(),tree.getLongitude()))
               .title(tree.getMaCay())
               .snippet(tree.getTenCay())
               .icon(bitmapDescriptor)
       );
       marker.setTag(0);
   }

    private void addTree(){

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Tree tree = dataSnapshot.getValue(Tree.class);
                addMarker(tree);

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
        FirebaseDatabase.getInstance().getReference().child("trees").addChildEventListener(childEventListener);
    }

    private  void addWaterStation(){
        LatLng water01 = new LatLng(21.003783, 105.843759);
        LatLng water02 = new LatLng(21.003703, 105.847006);
        listWaterStation.add(water01);
        listWaterStation.add(water02);


    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Trang chủ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



}

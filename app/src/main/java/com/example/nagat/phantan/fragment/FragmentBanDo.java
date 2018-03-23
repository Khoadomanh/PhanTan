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

import com.example.nagat.phantan.InforWaterStationActivity;
import com.example.nagat.phantan.InformationTreeActivity;
import com.example.nagat.phantan.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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
    List<LatLng> listTree = new ArrayList<>();
    List<LatLng> listWaterStation = new ArrayList<>();

    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;
    MapFragment mapFragment;
    MapView mMapView;
    private GoogleMap googleMap;


    public static FragmentBanDo init() {
        return new FragmentBanDo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_test_map, container, false);
        addTree();
        addWaterStation();
        mMapView = (MapView) view.findViewById(R.id.mapView);
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

                Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.ic_tree);
                Bitmap imgWater = BitmapFactory.decodeResource(getResources(), R.drawable.ic_water_station);

                int height = 50;
                int width = 50;
                Bitmap smallMarker = Bitmap.createScaledBitmap(img, width, height, false);
                BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(smallMarker);

                Bitmap smallMarkerWater  = Bitmap.createScaledBitmap(imgWater, width, height, false);
                BitmapDescriptor bitmapDescriptorWater = BitmapDescriptorFactory.fromBitmap(smallMarkerWater);
                for(int i = 0; i < listTree.size(); i++) {
                    Marker marker = googleMap.addMarker(new MarkerOptions()
                            .position(listTree.get(i))
                            .title("D35_XC1110")
                            .snippet("Population: 4,137,400")
                            .icon(bitmapDescriptor)
                    );
                    marker.setTag(0);
                }

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


    private  void addTree(){
        LatLng tree01 = new LatLng(21.004364, 105.843980);
        LatLng tree02 = new LatLng(21.004364, 105.847322);
        LatLng tree03 = new LatLng(21.005639, 105.846886);
        LatLng tree04 = new LatLng(21.006237,105.846110);
        LatLng tree05 = new LatLng(21.006447,105.842307);
        listTree.add(tree01);
        listTree.add(tree02);
        listTree.add(tree03);
        listTree.add(tree04);
        listTree.add(tree05);

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

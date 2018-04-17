package com.example.nagat.phantan.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.example.nagat.phantan.utils.DirectionsJSONParser;
import com.example.nagat.phantan.utils.MyUtil;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nagat on 20/3/2018.
 */

public class FragmentBanDo extends Fragment implements OnMapReadyCallback{
    private TextView tvInforTree;
    private UiSettings mUiSettings;
    LatLng MELBOURNE = new LatLng(21.004364, 105.843980);
    List<Tree> listTree = new ArrayList<>();
    List<LatLng> listWaterStation = new ArrayList<>();
    private Polyline line;
    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;
    MapFragment mapFragment;
    MapView mMapView;
    private GoogleMap mMap;
    private String cayDangTuoi;
    private ChildEventListener childEventListener;
    public static FragmentBanDo init() {
        return new FragmentBanDo();
    }
    private TextView tvCayDangTuoi;
    private EventBus eventBus;

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(LatLng latLgnEnd) {
        Log.e("Khoado","latTree = " + latLgnEnd.latitude);
        drawPathBetweenTwoPoint(MyUtil.getLocationUser(),latLgnEnd);
        Log.e("Khoado","latUser = " + MyUtil.getLocationUser().latitude);
        if (line!=null) {
            Log.e("Khoado","remove line");
            line.remove();
        }
    }

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

        mMapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void addMarker(Tree tree) {
       final Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.ic_tree);
       int height = 50;
       int width = 50;
       final Bitmap smallMarker = Bitmap.createScaledBitmap(img, width, height, false);
       final BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(smallMarker);
       Marker marker = mMap.addMarker(new MarkerOptions()
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


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.mMap.setMyLocationEnabled(true);
        addTree();
        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.ic_tree);
        Bitmap imgWater = BitmapFactory.decodeResource(getResources(), R.drawable.ic_water_station);

        int height = 50;
        int width = 50;


        Bitmap smallMarkerWater  = Bitmap.createScaledBitmap(imgWater, width, height, false);
        BitmapDescriptor bitmapDescriptorWater = BitmapDescriptorFactory.fromBitmap(smallMarkerWater);


        for(int i = 0; i < listWaterStation.size(); i++) {
            Marker marker = this.mMap.addMarker(new MarkerOptions()
                    .position(listWaterStation.get(i))
                    .title("D35_XC1110")
                    .snippet("Population: 4,137,400")
                    .icon(bitmapDescriptorWater)
            );
            marker.setTag(1);
        }


        this.mMap.getUiSettings().setZoomControlsEnabled(true);
        this.mMap.getUiSettings().setRotateGesturesEnabled(false);
        this.mMap.getUiSettings().setScrollGesturesEnabled(true);
        this.mMap.getUiSettings().setTiltGesturesEnabled(false);

        this.mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
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
        this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    private void drawPathBetweenTwoPoint(LatLng start,LatLng end ) {
        // Getting URL to the Google Directions API
        String url = getDirectionsUrl(start, end);

        DownloadTask downloadTask = new DownloadTask();
        // Start downloading json data from Google Directions API
        downloadTask.execute(url);
    }
    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            String data = "";

            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();


            parserTask.execute(result);

        }
    }


    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList();
                lineOptions = new PolylineOptions();

                List<HashMap<String, String>> path = result.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                lineOptions.addAll(points);
                lineOptions.width(12);
                lineOptions.color(Color.RED);
                lineOptions.geodesic(true);

            }
// Drawing polyline in the Google Map for the i-th route
            if (lineOptions!=null) {
                line = mMap.addPolyline(lineOptions);
            }

        }
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";
        String mode = "mode=driving";
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor + "&" + mode;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;


        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
}

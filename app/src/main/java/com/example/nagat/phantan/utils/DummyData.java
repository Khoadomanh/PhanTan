package com.example.nagat.phantan.utils;

import com.example.nagat.phantan.model.Sensor;
import com.example.nagat.phantan.model.Tree;
import com.example.nagat.phantan.model.WaterStation;
import com.example.nagat.phantan.ui.Utils;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nagat on 13/4/2018.
 */

public class DummyData {
    public static void addSensor() {
        Sensor sensor1 = new Sensor("Sensor1",50,50,"AQ-001");
        Sensor sensor2 = new Sensor("Sensor2",30,30,"AQ-002");
        Sensor sensor3 = new Sensor("Sensor3",60,60,"AQ-003");
        Sensor sensor4 = new Sensor("Sensor4",30,30,"AQ-004");
        Sensor sensor5 = new Sensor("Sensor5",60,60,"AQ-005");
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor1").setValue(sensor1);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor2").setValue(sensor2);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor3").setValue(sensor3);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor4").setValue(sensor4);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor5").setValue(sensor5);
    }
    public static void addTree() {
        Tree tree1 = new Tree("Cây nhãn","Tốt",
                Utils.getAddressFromLatAndLong(21.004364,105.843980),21.004364,105.843980,100,"AQ-001");
        Tree tree2 = new Tree("Cây bàng","Tốt",
                Utils.getAddressFromLatAndLong(21.004364,105.847322),21.004364,105.847322,120,"AQ-002");
        Tree tree3 = new Tree("Cây xoài","Tốt",
                Utils.getAddressFromLatAndLong(21.005639,105.846886),21.005639,105.846886,150,"AQ-003");
        Tree tree4 = new Tree("Cây ổi","Tốt",
                Utils.getAddressFromLatAndLong(21.006237,105.846110),21.006237,105.846110,110,"AQ-004");
        Tree tree5 = new Tree("Cây táo","Tốt",
                Utils.getAddressFromLatAndLong(21.006447,105.842307),21.006447,105.842307,90,"AQ-005");
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-001").setValue(tree1);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-002").setValue(tree2);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-003").setValue(tree3);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-004").setValue(tree4);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-005").setValue(tree5);

    }
    public static void addWaterStation()  {
        WaterStation waterStation1 = new WaterStation("TN-001",
                Utils.getAddressFromLatAndLong(21.003783,105.843759),21.003783,105.843759,null,Contants.CON_NUOC);
        WaterStation waterStation2 = new WaterStation("TN-002",
                Utils.getAddressFromLatAndLong(21.003703,105.847006),21.003703,105.847006,null,Contants.HET_NUOC);
        FirebaseDatabase.getInstance().getReference().child("water-station").child("TN-001").setValue(waterStation1);
        FirebaseDatabase.getInstance().getReference().child("water-station").child("TN-002").setValue(waterStation2);
    }
}

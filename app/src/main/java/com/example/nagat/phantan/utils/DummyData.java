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

        Sensor sensor3 = new Sensor("Sensor3",60,60,"AQ-003");
        Sensor sensor4 = new Sensor("Sensor4",30,30,"AQ-004");
        Sensor sensor5 = new Sensor("Sensor5",60,60,"AQ-005");
        Sensor sensor6 = new Sensor("Sensor7",30,30,"BM-002");
        Sensor sensor7 = new Sensor("Sensor6",50,50,"BM-001");
        Sensor sensor8 = new Sensor("Sensor8",50,50,"AQ-006");
        Sensor sensor9 = new Sensor("Sensor9",30,30,"AQ-007");
        Sensor sensor10 = new Sensor("Sensor10",60,60,"BM-003");
        Sensor sensor11 = new Sensor("Sensor11",30,30,"BM-004");
        Sensor sensor12 = new Sensor("Sensor12",60,60,"AQ-008");
        Sensor sensor13 = new Sensor("Sensor13",50,50,"AQ-009");
        Sensor sensor14 = new Sensor("Sensor14",30,30,"AQ-010");
        Sensor sensor15 = new Sensor("Sensor15",60,60,"AQ-011");
        Sensor sensor16 = new Sensor("Sensor16",30,30,"AQ-012");
        Sensor sensor17 = new Sensor("Sensor17",60,60,"AQ-013");
        Sensor sensor18 = new Sensor("Sensor18",60,60,"BM-005");
        Sensor sensor19 = new Sensor("Sensor19",60,60,"AQ-014");
        Sensor sensor20 = new Sensor("Sensor20",60,60,"AQ-015");
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor6").setValue(sensor6);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor7").setValue(sensor7);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor3").setValue(sensor3);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor4").setValue(sensor4);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor5").setValue(sensor5);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor8").setValue(sensor8);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor9").setValue(sensor9);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor10").setValue(sensor10);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor11").setValue(sensor11);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor12").setValue(sensor12);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor13").setValue(sensor13);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor14").setValue(sensor14);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor15").setValue(sensor15);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor16").setValue(sensor16);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor17").setValue(sensor17);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor18").setValue(sensor18);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor19").setValue(sensor19);
        FirebaseDatabase.getInstance().getReference().child("sensors").child("Sensor20").setValue(sensor20);
    }
    public static void addTree() {
        Tree tree1 = new Tree("Cây phượng vĩ","Tốt",
                Utils.getAddressFromLatAndLong(21.004812,105.844948),21.004812,105.844948,1000,"BM-001","Sensor7");
        Tree tree2 = new Tree("Cây Lim","Tốt",
                Utils.getAddressFromLatAndLong(21.004767,105.844573),21.004767,105.844573,1200,"BM-002","Sensor6");
        Tree tree3 = new Tree("Cây xoài","Tốt",
                Utils.getAddressFromLatAndLong(21.004747,105.844417),21.004747,105.844417,1500,"AQ-003","Sensor3");
        Tree tree4 = new Tree("Cây ổi","Tốt",
                Utils.getAddressFromLatAndLong(21.004782,105.844852),21.004782,105.844852,1100,"AQ-004","Sensor4");
        Tree tree5 = new Tree("Cây táo","Tốt",
                Utils.getAddressFromLatAndLong(21.004757,105.844347),21.004757,105.844347,900,"AQ-005","Sensor5");
        Tree tree6 = new Tree("Cây hồng xiêm","Tốt",
                Utils.getAddressFromLatAndLong(21.004922,105.843725),21.004922,105.843725,900,"AQ-006","Sensor8");
        Tree tree7 = new Tree("Cây nhãn","Tốt",
                Utils.getAddressFromLatAndLong(21.004922,105.843725),21.004922,105.843725,900,"AQ-007","Sensor9");
        Tree tree8 = new Tree("Cây hoa sữa","Tốt",
                Utils.getAddressFromLatAndLong(21.005648,105.843591),21.005648,105.843591,900,"BM-003","Sensor10");
        Tree tree9 = new Tree("Cây Xoan","Tốt",
                Utils.getAddressFromLatAndLong(21.004777,105.844557),21.004777,105.844557,900,"BM-004","Sensor11");
        Tree tree10 = new Tree("Cây Cam Cảnh","Tốt",
                Utils.getAddressFromLatAndLong(21.004827,105.844498),21.004827,105.844498,900,"AQ-008","Sensor12");
        Tree tree11 = new Tree("Cây Cam","Tốt",
                Utils.getAddressFromLatAndLong(21.004812,105.844948),21.004812,105.844948,900,"AQ-009","Sensor13");
        Tree tree12 = new Tree("Cây xà cừ","Tốt",
                Utils.getAddressFromLatAndLong(21.004937,105.843988),21.004937,105.843988,900,"AQ-010","Sensor14");
        Tree tree13 = new Tree("Cây bàng","Tốt",
                Utils.getAddressFromLatAndLong(21.004807,105.844626),21.004807,105.844626,900,"AQ-011","Sensor15");
        Tree tree14 =  new Tree("Cây táo","Tốt",
                Utils.getAddressFromLatAndLong(21.004782,105.844047),21.004782,105.844047,900,"AQ-012","Sensor16");
        Tree tree15 = new Tree("Cây xoài","Tốt",
                Utils.getAddressFromLatAndLong(21.005217,105.845769),21.005217,105.845769,900,"AQ-013","Sensor17");
        Tree tree16 = new Tree("Cây Gỗ Xưa","Tốt",
                Utils.getAddressFromLatAndLong(21.005207,105.844229),21.005207,105.844229,900,"BM-005","Sensor18");
        Tree tree17 = new Tree("Cây Vú Sữa","Tốt",
                Utils.getAddressFromLatAndLong(21.005187,105.844868),21.005187,105.844868,900,"AQ-014","Sensor19");
        Tree tree18 = new Tree("Cây Xoài","Tốt",
                Utils.getAddressFromLatAndLong(21.005001,105.844255),21.005001,105.844255,900,"AQ-015","Sensor20");
        FirebaseDatabase.getInstance().getReference().child("trees").child("BM-001").setValue(tree1);
        FirebaseDatabase.getInstance().getReference().child("trees").child("BM-002").setValue(tree2);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-003").setValue(tree3);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-004").setValue(tree4);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-005").setValue(tree5);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-006").setValue(tree6);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-007").setValue(tree7);
        FirebaseDatabase.getInstance().getReference().child("trees").child("BM-003").setValue(tree8);
        FirebaseDatabase.getInstance().getReference().child("trees").child("BM-004").setValue(tree9);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-008").setValue(tree10);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-009").setValue(tree11);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-010").setValue(tree12);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-011").setValue(tree13);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-012").setValue(tree14);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-013").setValue(tree15);
        FirebaseDatabase.getInstance().getReference().child("trees").child("BM-005").setValue(tree16);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-014").setValue(tree17);
        FirebaseDatabase.getInstance().getReference().child("trees").child("AQ-015").setValue(tree18);

    }
    public static void addWaterStation()  {
        WaterStation waterStation1 = new WaterStation("TN-001",
                Utils.getAddressFromLatAndLong(21.003783,105.843759),21.003783,105.843759,null,Contants.CON_NUOC);
        WaterStation waterStation2 = new WaterStation("TN-002",
                Utils.getAddressFromLatAndLong(21.003703,105.847006),21.003703,105.847006,null,Contants.HET_NUOC);
        WaterStation waterStation3 = new WaterStation("TN-003",
                Utils.getAddressFromLatAndLong(21.005011,105.843461),21.005011,105.843461,null,Contants.CON_NUOC);
        WaterStation waterStation4 = new WaterStation("TN-004",
                Utils.getAddressFromLatAndLong(21.004951,105.844131),21.004951,105.844131,null,Contants.CON_NUOC);
        FirebaseDatabase.getInstance().getReference().child("water-station").child("TN-003").setValue(waterStation3);
        FirebaseDatabase.getInstance().getReference().child("water-station").child("TN-004").setValue(waterStation4);
    }
}

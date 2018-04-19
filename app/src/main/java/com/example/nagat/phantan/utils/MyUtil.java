package com.example.nagat.phantan.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;

import com.bumptech.glide.Glide;
import com.example.nagat.phantan.App;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.common.GPSTracker;
import com.example.nagat.phantan.model.User;
import com.example.nagat.phantan.ui.Utils;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Win 8.1 Version 2 on 12/04/2018.
 */


public class MyUtil {
    public static Uri PATH_AVATA = null;
    public static final String FOLDER_STORAGE_IMG = "images";
    public static final String FOLDER_AVATAR_IMG = "images";
    public static final String URL_STORAGE_REFERENCE = "gs://phantan-8efe2.appspot.com";

    public static void showDialog(Context context,String title,String message,DialogInterface.OnClickListener clickYes,DialogInterface.OnClickListener clickNo) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, clickYes)
                .setNegativeButton(android.R.string.no, clickNo)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    public static void setImageUser(String urlPhotoUser, CircleImageView imageAvatar) {
        if (imageAvatar == null)
            return;

        if (urlPhotoUser == null) {
            imageAvatar.setImageResource(R.drawable.avatar_default);
            return;
        }
        Glide.with(imageAvatar.getContext())
                .load(urlPhotoUser).centerCrop()
                .fitCenter()
                .into(imageAvatar);
    }
    public static String convertLongDateToStringDate(long ngayGio) {
        Date today = new Date();
        DateFormat formatter= new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return  formatter.format((long)ngayGio);
    }
    public static String converLongDateToStringNgayThang(long ngayGio) {
        DateFormat formatter= new SimpleDateFormat("dd-M");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return  formatter.format((long)ngayGio);
    }
    public static String converLongDateToStringNgayThangName(long ngayGio) {
        DateFormat formatter= new SimpleDateFormat("dd-M-yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return  formatter.format((long)ngayGio);
    }
    public static String converLongDateToStringGioPhut(long ngayGio) {
        DateFormat formatter= new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return  formatter.format((long)ngayGio);
    }
    private static GPSTracker gps;
    public static LatLng getLocationUser() {
        gps = new GPSTracker(App.self());
        return new LatLng(gps.getLatitude(),gps.getLongitude());


    }

}

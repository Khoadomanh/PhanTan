package com.example.nagat.phantan.utils;

import android.net.Uri;

import com.bumptech.glide.Glide;
import com.example.nagat.phantan.R;

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
    ;

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
    public static String converLongDateToStringGioPhut(long ngayGio) {
        DateFormat formatter= new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return  formatter.format((long)ngayGio);
    }
}

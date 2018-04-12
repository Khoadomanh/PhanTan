package com.example.nagat.phantan.utils;

/**
 * Created by Win 8.1 Version 2 on 12/04/2018.
 */


public class MyUtil {
    public static final String FOLDER_STORAGE_IMG = "images";
    public static final String FOLDER_AVATAR_IMG = "images";
    public static final String URL_STORAGE_REFERENCE = "";

    public static String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }


}

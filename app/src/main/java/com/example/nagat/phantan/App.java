package com.example.nagat.phantan;

import android.app.Application;
import android.content.Context;

import com.example.nagat.phantan.ui.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by TuVD on 7/17/2017.
 */

public class App extends Application {
    private static App sInstance;
//    private Gson mGSon;

    public static App self() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

//        mGSon = new Gson();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

//    public Gson getGSon() {
//        return mGSon;
//    }

}

package com.example.nagat.phantan;

import android.app.Application;
import android.content.Context;



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

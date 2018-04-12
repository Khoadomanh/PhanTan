package com.example.nagat.phantan.ui;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;

import com.example.nagat.phantan.App;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by nagat on 11/4/2018.
 */

public class Utils {
    private static Integer indexOfUser = 0;
    public static String taoMaUser(final String userID) {
        FirebaseDatabase.getInstance().getReference().child("indexOfCurrentUser").runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                Integer p = mutableData.getValue(Integer.class);
                if (p == null) {
                    mutableData.setValue(1);
                    return Transaction.success(mutableData);
                }
                p = p+1;
                indexOfUser = p;
                mutableData.setValue(p);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                if (indexOfUser<10) FirebaseDatabase.getInstance().getReference().child("users").child(userID).child("maUser").setValue("TNV-00" + indexOfUser) ;
                else if (indexOfUser<100)   FirebaseDatabase.getInstance().getReference().child("users").child(userID).child("maUser").setValue("TNV-0"+indexOfUser);
                else   FirebaseDatabase.getInstance().getReference().child("users").child(userID).child("maUser").setValue("TNV-"+indexOfUser);
            }
        });
        if (indexOfUser<10) return ("TNV-00" + indexOfUser);
        else if (indexOfUser<100) return ("TNV-0"+indexOfUser);
        else return ("TNV-"+indexOfUser);
    }
    public static String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }
    public static String getAddressFromLatAndLong(Double latitude,Double longitude) {
        String postalCode;
        Geocoder geocoder = new Geocoder(App.self(), Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0);
                postalCode = addresses.get(0).getPostalCode();
                return address;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

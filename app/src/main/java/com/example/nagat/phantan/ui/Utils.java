package com.example.nagat.phantan.ui;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

/**
 * Created by nagat on 11/4/2018.
 */

public class Utils {
    private static Integer indexOfUser = 0;
    public static String taoMaUser() {
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
}

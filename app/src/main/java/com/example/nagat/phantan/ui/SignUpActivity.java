package com.example.nagat.phantan.ui;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nagat.phantan.BaseActivity;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.common.GPSTracker;
import com.example.nagat.phantan.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by nagat on 27/3/2018.
 */

public class SignUpActivity extends BaseActivity {
    private EditText etUsername, etPassword, etTenNguoiDung;
    private Button btSignUp;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private GPSTracker gps;
    private static final String TAG = "SignUpActivity";
    private List<String> listKeyUser = new ArrayList<>();
    private ChildEventListener childEventListener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPasssword);
        etTenNguoiDung = findViewById(R.id.etName);
        btSignUp = findViewById(R.id.btSignUp);
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkform() && !checkEmailIsExist() && checkGPS()) {
                    signUp();
                }
            }
        });
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                listKeyUser.add(dataSnapshot.getKey());
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
        mDatabase.child("users").addChildEventListener(childEventListener);
    }

    private boolean checkGPS() {
        gps = new GPSTracker(SignUpActivity.this);

        // check if GPS enabled
        if (gps.canGetLocation()) {
            return true;
        } else {
            gps.showSettingsAlert();
            return false;
        }
    }
    private boolean checkEmailIsExist() {
        String keySignUp = usernameFromEmail(etUsername.getText().toString());
        if (listKeyUser.contains(keySignUp)) {
            etUsername.setError("Email đã tồn tại");
            return true;
        } else {
            etUsername.setError(null);
            return false;
        }
    }

    private boolean checkform() {
        boolean result = true;
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError("Required");
            result = false;
        } else if (!etUsername.getText().toString().contains("@gmail.com")) {
            etUsername.setError("Tên đăng nhập phải có @gmail.com");
            result = false;
        } else {
            etUsername.setError(null);
        }

        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Required");
            result = false;
        } else {
            etPassword.setError(null);
        }
        if (TextUtils.isEmpty(etTenNguoiDung.getText().toString())) {
            etTenNguoiDung.setError("Required");
            result = false;
        } else {
            etTenNguoiDung.setError(null);
        }

        return result;
    }

    private void signUp() {
        showProgress("Loading...");
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());
                hideProgress();
                if (task.isSuccessful()) {
                    onAuthSuccess(task.getResult().getUser());
                } else {
                    Toast.makeText(SignUpActivity.this, "Tên đăng nhập hoặc mật khẩu chưa đúng",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void onAuthSuccess(FirebaseUser user) {
        String username = usernameFromEmail(user.getEmail());
        String tenNguoiDung = etTenNguoiDung.getText().toString().trim();
        Log.d("Khoa do:", "onAuthSuccess");
        // Write new user
        writeNewUser(username, tenNguoiDung, user.getEmail());

        // Go to MainActivity
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        finish();
    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    private void writeNewUser(String userId, String name, String email) {
        Log.d(TAG, "writeNewUser: ");
        User user = new User();
        user.setMaUser(Utils.taoMaUser(userId));
        user.setTenHienThi(name);
        user.setEmail(email);
        user.setLatitude(gps.getLatitude());
        user.setLongitude(gps.getLongitude());
        user.setTrangThai("online");

        user.setVaiTro("Tình nguyện viên");
        mDatabase.child("users").child(userId).setValue(user);
    }


    @Override
    protected void onDestroy() {
        mDatabase.removeEventListener(childEventListener);
        super.onDestroy();
    }
}

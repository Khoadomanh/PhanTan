package com.example.nagat.phantan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nagat.phantan.BaseActivity;
import com.example.nagat.phantan.R;

/**
 * Created by nagat on 27/3/2018.
 */

public class SignUpActivity extends BaseActivity {
    private EditText etUsername,etPassword,etTenNguoiDung;
    private Button btSignUp;
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
                checkForm();
            }
        });
    }
    private void checkForm() {
        String userName = etUsername.getText().toString().trim();
        String passWord = etPassword.getText().toString().trim();
        String tenNguoiDung = etTenNguoiDung.getText().toString().trim();
        if (userName.equals("")) {
            etUsername.setError("Tên đăng nhập không hợp lệ");
        } else if (passWord.length() < 6) {
            etPassword.setError("Password phải có ít nhất 6 ký tự");
        } else if (tenNguoiDung.equals("")) {
            etTenNguoiDung.setError("Tên người dùng không hợp lệ");
        } else {
            login();
        }
    }
    private void login() {
        Intent i = new Intent(SignUpActivity.this, MainActivity.class);
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}

package com.example.nagat.phantan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagat.phantan.BaseActivity;
import com.example.nagat.phantan.R;

public class LoginActivity extends BaseActivity {

    private Button btLogin;
    private EditText etUserName,etPassword;
    private TextView tvDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_log_in);
        this.setupUI(this.getWindow().getDecorView().findViewById(android.R.id.content));
        btLogin = findViewById(R.id.btLogin);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPasssword);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("khoa","user: "+etUserName.getText()+" password: "+etPassword.getText());
                if (etUserName.getText().toString().equals("1")&& etPassword.getText().toString().equals("1")) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "User name and password are not correct", Toast.LENGTH_SHORT).show();
                    etUserName.requestFocus();
                }


            }
        });
        tvDangKy = findViewById(R.id.tvDangKy);
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.nagat.phantan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private Button btLogin;
    private EditText etUserName,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btLogin = findViewById(R.id.btLogin);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPasssword);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("khoa","user: "+etUserName.getText()+" password: "+etPassword.getText());
                if (etUserName.getText().toString().equals("test123")&& etPassword.getText().toString().equals("123456")) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "User name and password are not correct", Toast.LENGTH_SHORT).show();
                    etUserName.requestFocus();
                }


            }
        });
    }
}
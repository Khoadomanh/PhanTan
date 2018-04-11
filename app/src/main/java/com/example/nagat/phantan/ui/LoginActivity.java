package com.example.nagat.phantan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    private Button btLogin;
    private EditText etUserName,etPassword;
    private TextView tvDangKy;
    private FirebaseAuth auth;
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
                if (checkform()) {
                    logIn();
                }
                else {
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

        auth = FirebaseAuth.getInstance();

    }
    private boolean checkform() {
        boolean result = true;
        if (TextUtils.isEmpty(etUserName.getText().toString())) {
            etUserName.setError("Required");
            result = false;
        } else if (!etUserName.getText().toString().contains("@gmail.com")) {
            etUserName.setError("Tên đăng nhập phải có @gmail.com");
            result = false;
        } else {
            etUserName.setError(null);
        }

        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Required");
            result = false;
        } else {
            etPassword.setError(null);
        }

        return result;
    }
    @Override
    public void onStart() {
        super.onStart();

        // Check auth on Activity start
        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void logIn() {
        showProgress("Loading...");
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        auth.signInWithEmailAndPassword(username,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "logIn:onComplete:" + task.isSuccessful());
                hideProgress();
                if (task.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu chưa đúng",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

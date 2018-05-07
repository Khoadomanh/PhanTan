package com.example.nagat.phantan.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nagat.phantan.BaseActivity;
import com.example.nagat.phantan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by nagat on 7/5/2018.
 */

public class ChangePasswordActivity extends BaseActivity {

    EditText old_password;
    EditText new_password;
    EditText repeat_new_passwrod;
    Button change_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_change_password);
        old_password = findViewById(R.id.old_password);
        new_password = findViewById(R.id.new_password);
        repeat_new_passwrod = findViewById(R.id.repeat_new_password);
        change_password =  findViewById(R.id.change_password);
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    showProgress();
                    FirebaseAuth.getInstance().getCurrentUser().updatePassword(new_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ChangePasswordActivity.this,"Thay đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
                                hideProgress();
                                onBackPressed();
                            }
                        }
                    });
                }
            }
        });
    }

    private boolean validate() {
        if (new_password.getText().toString().trim().isEmpty()) {
            new_password.setError("Mật khẩu mới ko thể trống");
            return false;
        }
        if (!old_password.getText().toString().equals(LoginActivity.passwordUser)) {
            old_password.setError("Mật khẩu cũ sai");
            return false;
        }
        if (!new_password.getText().toString().equals(repeat_new_passwrod.getText().toString())) {
            repeat_new_passwrod.setError("Mật khẩu chưa trùng khớp");
            return false;
        }
        return true;
    }
}

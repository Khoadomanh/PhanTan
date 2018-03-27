package com.example.nagat.phantan;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.nagat.phantan.ui.MainActivity;

/**
 * This is the common base class of the activities.
 * It contains the shared properties of the child activity.
 * Created by TuVD on 7/17/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private boolean mIsDetachedFromWindow = false;
    private ProgressDialog mProgressDialog;

    public Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    public synchronized void showProgress(String message) {
        if (!TextUtils.isEmpty(message)) {
            mProgressDialog.setMessage(message);
        }


        if (!mProgressDialog.isShowing() && !isFinishing()) {
            mProgressDialog.show();
        }
    }
    public void setupUI(final View view) {
        if (!(view instanceof EditText) && !(view instanceof Button) && !(view instanceof ImageButton)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(final View view, final MotionEvent motionEvent) {
                    hideSoftKeyboard(view);
                    return false;
                }
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); ++i) {
                this.setupUI(((ViewGroup) view).getChildAt(i));
            }
        }
    }
    public void hideSoftKeyboard(final View view) {
        ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public void showProgress() {
        showProgress(null);
    }

    public synchronized void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing() && !mIsDetachedFromWindow) {
            mProgressDialog.dismiss();
        }
    }


    @Override
    public void onDetachedFromWindow() {
        mIsDetachedFromWindow = true;
        super.onDetachedFromWindow();
    }

    @Override
    public void onBackPressed() {
        if (this instanceof MainActivity) {
            hideSoftKeyboard(this.getWindow().getDecorView().findViewById(android.R.id.content));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.common_app_finish));
            builder.setPositiveButton(getString(R.string.common_ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCompat.finishAffinity(BaseActivity.this);
                }
            });

            builder.setNegativeButton(getString(R.string.common_cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.setCancelable(true);
            builder.show();

        } else {
            hideSoftKeyboard(this.getWindow().getDecorView().findViewById(android.R.id.content));
            super.onBackPressed();
        }
    }


}

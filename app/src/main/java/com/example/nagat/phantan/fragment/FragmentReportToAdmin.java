package com.example.nagat.phantan.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.ReportSystem;
import com.example.nagat.phantan.ui.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Win 8.1 Version 2 on 22/03/2018.
 */

public class FragmentReportToAdmin extends Fragment {
    private RelativeLayout rl_status_1;
    private RelativeLayout rl_status_2;
    private RelativeLayout rl_status_3;
    private EditText etReport;
    private TextView tvSend;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_report, container, false);
        rl_status_1 = view.findViewById(R.id.status1);
        rl_status_2 = view.findViewById(R.id.status2);
        rl_status_3 = view.findViewById(R.id.status3);
        etReport = view.findViewById(R.id.etReport);
        tvSend = view.findViewById(R.id.tvSend);
        rl_status_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etReport.setText("Tôi tưới nước nhưng lượng nước không được cập nhật");
            }
        });
        rl_status_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etReport.setText("Tôi nhấn vào tưới nước nhưng apps không phản hồi");
            }
        });
        rl_status_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etReport.setText("Tôi không thể cập nhật được thông tin cá nhân");
            }
        });
        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etReport.getText().toString().trim()!=null) {
                    showProcess("Sending....");
                    ReportSystem reportSystem = new ReportSystem(MainActivity.USERCURRENT,etReport.getText().toString().trim(),System.currentTimeMillis());
                    FirebaseDatabase.getInstance().getReference().child("report-system").push().setValue(reportSystem).addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            hideProgress();
                            Toast.makeText(FragmentReportToAdmin.this.getActivity(), "Cảm ơn phản hồi của bạn về hệ thống", Toast.LENGTH_SHORT).show();
                            etReport.setText(null);
                        }
                    });
                }
            }
        });
        return view;

    }
    private boolean mIsDetachedFromWindow = false;
    private ProgressDialog mProgressDialog;
    private void showProcess(String message) {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setCanceledOnTouchOutside(false);
        if (!TextUtils.isEmpty(message)) {
            mProgressDialog.setMessage(message);
        }


        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }
    public synchronized void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing() && !mIsDetachedFromWindow) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Báo cáo");
    }
}
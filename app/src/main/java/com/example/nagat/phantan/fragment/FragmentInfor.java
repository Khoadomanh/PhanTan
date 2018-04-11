package com.example.nagat.phantan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Win 8.1 Version 2 on 22/03/2018.
 */


public class FragmentInfor extends Fragment {

    @BindView(R.id.tv_name_infor)
    TextView tvNameInfor;
    @BindView(R.id.tv_name_infor_large)
    TextView tvNameInforLarge;
    @BindView(R.id.btn_edit_name_display)
    Button btnEditNameDisplay;
    @BindView(R.id.tv_sex_user)
    TextView tvSexUser;
    @BindView(R.id.role)
    TextView tvRoleUser;
    @BindView(R.id.ln_change_password)
    LinearLayout lnChangePassword;
    @BindView(R.id.img_avatar_infor)
    CircleImageView imageAvatar;


    User user = new User();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Thông tin người dùng");
    }

    private void bindView() {

    }
}
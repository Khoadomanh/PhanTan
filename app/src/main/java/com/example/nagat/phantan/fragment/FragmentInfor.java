package com.example.nagat.phantan.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nagat.phantan.BuildConfig;
import com.example.nagat.phantan.R;
import com.example.nagat.phantan.model.User;
import com.example.nagat.phantan.ui.LoginActivity;
import com.example.nagat.phantan.utils.MyUtil;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Win 8.1 Version 2 on 22/03/2018.
 */


public class FragmentInfor extends Fragment  implements View.OnClickListener {

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

    @BindView(R.id.tv_status_user)
    TextView tvStatusUser;

    private DatabaseReference myRef;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final int IMAGE_GALLERY_REQUEST = 1;
    private static final int IMAGE_CAMERA_REQUEST = 2;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private File pathImageCamera;

    User user = new User();
    final CharSequence[] options = {"Camera", "Gallery"};
    String stDateFormat = DateFormat.format("yyyy-MM-dd_hhmmss", new Date()).toString();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(this, view);

        imageAvatar.setOnClickListener(this);

        myRef = LoginActivity.mDatabase.getReference().child("users");

        myRef.keepSynced(true);

        myRef.child(MyUtil.usernameFromEmail(LoginActivity.SIGN_IN_EMAIL));
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                tvNameInfor.setText(user.getTenHienThi());
                tvNameInforLarge.setText(user.getTenHienThi());

                if (user.isGioiTinh())
                    tvSexUser.setText("Nam");
                else
                    tvSexUser.setText("Nữ");

                setImageUser(user.getAvatar(), imageAvatar);
                tvRoleUser.setText(user.getVaiTro());
                tvStatusUser.setText(user.getTrangThai());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Thông tin người dùng");
    }

    private void bindView() {

    }

    public void setImageUser(String urlPhotoUser, CircleImageView imageAvatar) {
        if (imageAvatar == null)
            return;

        if (urlPhotoUser.equals("Null")) {
            imageAvatar.setImageResource(R.drawable.avatar_default);
            return;
        }
        Glide.with(imageAvatar.getContext())
                .load(urlPhotoUser).centerCrop()
                .fitCenter()
                .into(imageAvatar);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.img_avatar_infor:
                changeAvatar();
                break;
        }
    }

    private void changeAvatar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Source ");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Camera")) {
                    allowStoragePermissions();
                }
                if (options[item].equals("Gallery")) {
                    photoGallery();
                }
            }
        });
        builder.show();
    }

    private void photoGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_picture_title)), IMAGE_GALLERY_REQUEST);
    }

    public void allowStoragePermissions() {
        int permission = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    getActivity(),
                    PERMISSIONS,
                    REQUEST_EXTERNAL_STORAGE
            );
        } else {
            photoCameraIntent();
        }
    }

    private void photoCameraIntent() {

        pathImageCamera = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), stDateFormat + "camera.jpg");

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri photoURI = FileProvider.getUriForFile(getActivity(),
                BuildConfig.APPLICATION_ID + ".provider",
                pathImageCamera);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        startActivityForResult(intent, IMAGE_CAMERA_REQUEST);
    }

    private void sendFile(StorageReference storageReference, final File file) {
        if (storageReference != null) {
            Uri photoURI = FileProvider.getUriForFile(getActivity(),
                    BuildConfig.APPLICATION_ID + ".provider",
                    file);
            UploadTask uploadTask = storageReference.putFile(photoURI);
            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    setImageUser(downloadUrl.toString(), imageAvatar);
                    myRef.child(MyUtil.usernameFromEmail(user.getEmail())).child("avatar").setValue(downloadUrl.toString());
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }
    }

    private void sendFile(StorageReference storageReference, final Uri file) {
        if (storageReference != null) {
            StorageReference imageGalleryRef = storageReference.child(stDateFormat + "_gallery");
            UploadTask uploadTask = imageGalleryRef.putFile(file);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    setImageUser(downloadUrl.toString(), imageAvatar);
                    myRef.child(MyUtil.usernameFromEmail(user.getEmail())).child("").setValue(downloadUrl.toString());
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        StorageReference storageRef = storage.getReferenceFromUrl(MyUtil.URL_STORAGE_REFERENCE).child(MyUtil.FOLDER_AVATAR_IMG);

        if (requestCode == IMAGE_GALLERY_REQUEST) {
            if (resultCode == RESULT_OK) {
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    sendFile(storageRef, selectedImageUri);
                } else {

                }
            }
        } else if (requestCode == IMAGE_CAMERA_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (pathImageCamera != null && pathImageCamera.exists()) {
                    StorageReference imageCameraRef = storageRef.child(pathImageCamera.getName() + "_camera");
                    sendFile(imageCameraRef, pathImageCamera);
                } else {

                }
            }
        }
    }

}
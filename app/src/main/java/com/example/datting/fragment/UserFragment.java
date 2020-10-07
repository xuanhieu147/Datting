package com.example.datting.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.datting.R;
import com.example.datting.activity.SettingActivity;
import com.example.datting.activity.ThongTinActivity;


public class UserFragment extends Fragment {
    private ImageView imgSetting, imgAvatar;


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        imgSetting = view.findViewById(R.id.imgSetting);
        imgAvatar = view.findViewById(R.id.imgAvatarUser);
        onClick();
        return view;
    }

    private void onClick() {
        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SettingActivity.class));
            }
        });
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ThongTinActivity.class));
            }
        });
    }

}
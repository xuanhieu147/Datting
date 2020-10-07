package com.example.datting.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.datting.R;
import com.example.datting.class_khac.ButtonClick;
import com.example.datting.class_khac.SetColorStatusBar;


public class NgonNguFragment extends Fragment {

    private TextView tvBoQua;
    ButtonClick buttonClick;


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        buttonClick = (ButtonClick) activity;
    }
    public NgonNguFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ngon_ngu, container, false);
        tvBoQua = view.findViewById(R.id.tvBoQua);
        tvBoQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick.ButtonClicked(view);
            }
        });
        return view;
    }


}
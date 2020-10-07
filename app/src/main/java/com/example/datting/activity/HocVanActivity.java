package com.example.datting.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datting.R;
import com.google.android.material.textfield.TextInputEditText;

public class HocVanActivity extends AppCompatActivity {
    private TextView tvCongty, tvNgheNghiep;
    private TextInputEditText edCongty, edNgheNghiep;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_van);
        init();
        onClick();


    }

    private void onClick() {

        edCongty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCongty.setTextColor(getResources().getColor(R.color.colorTim));
                tvNgheNghiep.setTextColor(getResources().getColor(R.color.colorXam));
            }
        });
        edNgheNghiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCongty.setTextColor(getResources().getColor(R.color.colorXam));
                tvNgheNghiep.setTextColor(getResources().getColor(R.color.colorTim));
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        tvCongty = findViewById(R.id.tvTenCongTy);
        tvNgheNghiep = findViewById(R.id.tvNgheNghiep);
        edCongty = findViewById(R.id.edCongTy);
        edNgheNghiep = findViewById(R.id.edNgheNgiep);
        imgBack = findViewById(R.id.imgback);
    }
}
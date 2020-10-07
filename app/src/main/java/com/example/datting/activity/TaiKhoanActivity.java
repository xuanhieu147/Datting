package com.example.datting.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datting.R;

import net.igenius.customcheckbox.CustomCheckBox;

public class TaiKhoanActivity extends AppCompatActivity {
    private CustomCheckBox checkBoxNam, checkBoxNu;
    private EditText edDate, edName;
    private TextView tvHoTen, tvNgaySinh;
    private ImageView imgBack;
    int selectedYear = 2000;
    int selectedMonth = 6;
    int selectedDayOfMonth = 14;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        init();
        datePickerD();
        onClick();


    }

    private void onClick() {
        checkBoxNam.setOnCheckedChangeListener(new CustomCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CustomCheckBox checkBox, boolean isChecked) {
                if (checkBoxNam.isChecked() == true) {
                    checkBoxNu.setChecked(false);
                }

            }
        });
        checkBoxNu.setOnCheckedChangeListener(new CustomCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CustomCheckBox checkBox, boolean isChecked) {
                if (checkBoxNu.isChecked() == true) {
                    checkBoxNam.setChecked(false);
                }
            }
        });
        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
                tvNgaySinh.setTextColor(getResources().getColor(R.color.colorTim));
                tvHoTen.setTextColor(getResources().getColor(R.color.colorXam));
                edName.setTextColor(getResources().getColor(R.color.colorXam));
                edDate.setTextColor(getResources().getColor(R.color.colorBlack));
            }
        });
        edName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHoTen.setTextColor(getResources().getColor(R.color.colorTim));
                tvNgaySinh.setTextColor(getResources().getColor(R.color.colorXam));
                edName.setTextColor(getResources().getColor(R.color.colorBlack));
                edDate.setTextColor(getResources().getColor(R.color.colorXam));
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void datePickerD() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {

                edDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        };

// Create DatePickerDialog (Spinner Mode):
         datePickerDialog = new DatePickerDialog(this,
                dateSetListener, selectedYear, selectedMonth, selectedDayOfMonth);
    }

    private void init() {
        checkBoxNam = findViewById(R.id.customCheckBox);
        checkBoxNu = findViewById(R.id.customCheckBox2);
        tvHoTen = findViewById(R.id.tvHoTen);
        tvNgaySinh = findViewById(R.id.tvNgaySinh);
        imgBack = findViewById(R.id.imgback);
        edName = findViewById(R.id.edName);
        edDate = findViewById(R.id.edDate);
    }
}
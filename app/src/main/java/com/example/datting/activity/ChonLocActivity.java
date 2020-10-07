package com.example.datting.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.datting.R;

import io.apptik.widget.MultiSlider;

public class ChonLocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_loc);
        final TextView min2 = (TextView) findViewById(R.id.minValue2);
        final TextView max2 = (TextView) findViewById(R.id.maxValue2);
        final TextView min3 = (TextView) findViewById(R.id.minValue3);
        MultiSlider multiSlider2 = (MultiSlider) findViewById(R.id.range_slider2);
        MultiSlider multiSlider3 = (MultiSlider) findViewById(R.id.range_slider3);

        multiSlider2.getThumb(1).setValue(30).setEnabled(true);
        min2.setText(String.valueOf(multiSlider2.getThumb(0).getValue()));
        max2.setText(String.valueOf(multiSlider2.getThumb(1).getValue()));

        multiSlider3.getThumb(0).setValue(0).setEnabled(false);
        multiSlider3.getThumb(1).setValue(50).setEnabled(true);
        min3.setText(String.valueOf(multiSlider3.getThumb(1).getValue()));
        multiSlider2.setOnThumbValueChangeListener(new MultiSlider.SimpleChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int
                    thumbIndex, int value) {
                if (thumbIndex == 0) {
                    min2.setText(String.valueOf(value));
                } else {
                    max2.setText(String.valueOf(value));
                }
            }
        });
        multiSlider3.setOnThumbValueChangeListener(new MultiSlider.SimpleChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int
                    thumbIndex, int value) {
               min3.setText(String.valueOf(value));
            }
        });
    }
}
package com.example.datting.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.datting.R;
import com.example.datting.adapter.PagerAdapter;
import com.example.datting.class_khac.ButtonClick;

public class ItemActivity extends AppCompatActivity implements ButtonClick {
    public int positionItem;
    PagerAdapter pagerAdapter;
    ViewPager viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Intent intent = this.getIntent();
        positionItem = intent.getIntExtra("positionItem", 0);
        viewPager2 = findViewById(R.id.item_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager2.setPageMargin(20);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setCurrentItem(positionItem);
        getPosition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
    @Override
    public void ButtonClicked(View view) {
        viewPager2.setCurrentItem(positionItem + 1);
    }

    private void getPosition() {
        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                positionItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



}
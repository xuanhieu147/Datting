package com.example.datting.class_khac;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.example.datting.R;
import com.example.datting.activity.HomeActivity;

public class SetColorStatusBar {
    Activity activity;

    public SetColorStatusBar(Activity activity) {
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getColorStatus() {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.colorPWhite));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getColorStatusChieuCao() {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.hong));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getColorStatusCanNang() {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.green));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getColorStatusRuouBia() {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.xanh));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getColorStatusHutThuoc() {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.xanh2));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getColorStatusNgonNgu() {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.xanhlacay));
    }
}

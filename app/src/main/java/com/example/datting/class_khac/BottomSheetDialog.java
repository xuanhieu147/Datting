package com.example.datting.class_khac;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import com.example.datting.R;
import com.example.datting.adapter.ViewpagerAdapter;
import com.example.datting.model.BatGap;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetBehavior mBehavior;
    public ViewPager viewPager;
    ViewpagerAdapter viewpagerAdapter;
    List<BatGap> photos;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.item_bottom, null);
        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        mBehavior.setPeekHeight(0);
        ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
        viewPager = view.findViewById(R.id.viewPager);
        viewpagerAdapter = new ViewpagerAdapter(getContext(), addList());
        viewPager.setAdapter(viewpagerAdapter);
//        RelativeLayout.LayoutParams card = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        card.setMargins(30,120,30,10);
//
//        view.setLayoutParams(card);
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        mBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED){
                    dismiss();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
    private List<BatGap> addList() {

        photos = new ArrayList<>();
        photos.add(new BatGap(R.drawable.gaixinh1, 20, "Umi Chan", "Pham Van Dong"));
        photos.add(new BatGap(R.drawable.gaixinh2, 18, "Trần Y", "Cau Giay"));
        photos.add(new BatGap(R.drawable.gaixinh3, 19, "Yến", "Dong Da"));
        photos.add(new BatGap(R.drawable.gaixinh4, 22, "Quỳnh", "Hai Ba Trung"));
        return photos;
    }
}

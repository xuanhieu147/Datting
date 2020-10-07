package com.example.datting.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.datting.R;
import com.example.datting.adapter.ViewpagerAdapter;
import com.example.datting.model.BatGap;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MucDichDialog extends BottomSheetDialogFragment {
        private BottomSheetBehavior mBehavior;


        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            Dialog dialog = super.onCreateDialog(savedInstanceState);
            View view = View.inflate(getContext(), R.layout.item_mucdich, null);
            dialog.setContentView(view);
            mBehavior = BottomSheetBehavior.from((View) view.getParent());
            mBehavior.setPeekHeight(600);
            ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
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

}

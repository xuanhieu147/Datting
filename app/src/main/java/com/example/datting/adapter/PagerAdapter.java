package com.example.datting.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.datting.fragment.CanNangFragment;
import com.example.datting.fragment.ChieuCaoFragment;
import com.example.datting.fragment.HutThuocFragment;
import com.example.datting.fragment.NgonNguFragment;
import com.example.datting.fragment.RuouBiaFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 5;
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position) {
            case 0:
                fragment = new ChieuCaoFragment();
                break;
            case 1:
                fragment = new CanNangFragment();
                break;
            case 2:
                fragment = new RuouBiaFragment();
                break;
            case 3:
                fragment = new HutThuocFragment();
                break;
            case 4:
                fragment = new NgonNguFragment();
                break;
            default:
                return null;
        }
        return fragment;
    }
}

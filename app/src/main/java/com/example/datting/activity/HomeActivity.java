package com.example.datting.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.datting.R;
import com.example.datting.fragment.ChatFragment;
import com.example.datting.fragment.ExploiFragment;
import com.example.datting.fragment.NoNameFragment;
import com.example.datting.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private ActionBar toolbar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this, R.color.colorPWhite));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       // navigation.setItemIconTintList(null);
        loadFragment(new ExploiFragment());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_laban:
                 //   item.setIcon(getResources().getDrawable(R.drawable.laban_2));
                    fragment = new ExploiFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dnoname:
                  //  item.setIcon(getResources().getDrawable(R.drawable.noname_2));
                    fragment = new NoNameFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_chat:
                  //  item.setIcon(getResources().getDrawable(R.drawable.chat_2));
                    fragment = new ChatFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_accounts:
                   // item.setIcon(getResources().getDrawable(R.drawable.user));
                    fragment = new UserFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }


    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
package com.example.datting.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.datting.R;
import com.example.datting.adapter.GanDayAdapter;
import com.example.datting.adapter.ItemAdapter;
import com.example.datting.class_khac.BottomSheetDialog;
import com.example.datting.class_khac.SetColorStatusBar;
import com.example.datting.fragment.MucDichDialog;
import com.example.datting.model.BatGap;
import com.example.datting.model.Item_User;
import com.example.datting.model.UserGanDay;

import java.util.ArrayList;
import java.util.List;

public class ThongTinActivity extends AppCompatActivity {
    private LinearLayout tenTuoi;
    private ImageView imgBack;
    private TextView tvHocVan, tvVeBan, tvMucDich;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        setColorStatusBar();
        init();
        onClick();
        itemAdapter = new ItemAdapter(getApplicationContext(), addList(), new ItemAdapter.AdapterListener() {
            @Override
            public void OnClick(int position) {
                Intent intent = new Intent(getApplicationContext(), ItemActivity.class);
                intent.putExtra("positionItem", position);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(itemAdapter);

    }

    private void onClick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tenTuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TaiKhoanActivity.class));
            }
        });
        tvHocVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HocVanActivity.class));
            }
        });
        tvVeBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VeBanActivity.class));
            }
        });
        tvMucDich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MucDichDialog bottomSheetDialog = new MucDichDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });
    }

    private void init() {
        tenTuoi = findViewById(R.id.tenTuoi);
        imgBack = findViewById(R.id.imgback);
        tvHocVan = findViewById(R.id.tvHocVan);
        tvVeBan = findViewById(R.id.tvVeBan);
        tvMucDich = findViewById(R.id.tvMucDich);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setColorStatusBar() {
        SetColorStatusBar setColorStatusBar = new SetColorStatusBar(this);
        setColorStatusBar.getColorStatus();
    }

    private List<Item_User> addList() {
        List<Item_User> items = new ArrayList<>();
        items.add(new Item_User(R.drawable.ic_action_ruler, "Chiều cao"));
        items.add(new Item_User(R.drawable.ic_action_gym, "Cân nặng"));
        items.add(new Item_User(R.drawable.ic_action_wine, "Rượu bia"));
        items.add(new Item_User(R.drawable.ic_action_tsmoking, "Hút thuốc"));
        items.add(new Item_User(R.drawable.ic_action_ggdich, "Ngôn ngữ"));
        items.add(new Item_User(R.drawable.ic_action_home_1, "Nơi sống"));
        items.add(new Item_User(R.drawable.ic_action_loveback, "Hôn nhân"));
        items.add(new Item_User(R.drawable.ic_action_tongiao, "Tôn giáo"));

        return items;
    }
}
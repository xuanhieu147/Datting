package com.example.datting.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.datting.R;
import com.example.datting.class_khac.BottomSheetDialog;
import com.example.datting.class_khac.CustomItemDecorator;
import com.example.datting.adapter.GanDayAdapter;
import com.example.datting.model.UserGanDay;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;


public class ExploiFragment extends Fragment {
    private RecyclerView recyclerView;
    private GanDayAdapter ganDayAdapter;
    ArrayList<UserGanDay> users;

    public ExploiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exploi, container, false);

        recyclerView = view.findViewById(R.id.rvList);
        users = new ArrayList<UserGanDay>();

        taoUser();
        ganDayAdapter = new GanDayAdapter(getContext(), users, new GanDayAdapter.AdapterListener() {
            @Override
            public void OnClick(int position) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getFragmentManager(), "exampleBottomSheet");
            }
        });

        StaggeredGridLayoutManager gridLayout = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        gridLayout.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.addItemDecoration(new CustomItemDecorator(30.00, 200.00));
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setAdapter(ganDayAdapter);

        return view;

    }


    private void taoUser() {
        for (int i = 0; i <= 50; i++) {
            users.add(new UserGanDay("Name" + i));
        }
    }

}
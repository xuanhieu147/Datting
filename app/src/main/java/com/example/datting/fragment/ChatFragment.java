package com.example.datting.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.datting.R;
import com.example.datting.activity.ChatActivity;
import com.example.datting.adapter.ChatAdapter;
import com.example.datting.adapter.ChatAdapter_2;
import com.example.datting.model.UserGanDay;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    private RecyclerView recyclerView, recyclerView2;
    private ChatAdapter chatAdapter;
    private ChatAdapter_2 chatAdapter_2;
    ArrayList<UserGanDay> users;

    public ChatFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = view.findViewById(R.id.rvListChat);
        recyclerView2 = view.findViewById(R.id.rvListUser);
        users = new ArrayList<UserGanDay>();
        taoUser();
        setAdapter();

        return view;
    }

    private void setAdapter() {
        chatAdapter = new ChatAdapter(getContext(), users, new ChatAdapter.AdapterListener() {
            @Override
            public void OnClick(int position) {
                startActivity(new Intent(getContext(), ChatActivity.class));
            }
        });
        chatAdapter_2 = new ChatAdapter_2(getContext(), users);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setAdapter(chatAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(chatAdapter_2);
        recyclerView2.setLayoutManager(layoutManager);
    }

    private void taoUser() {
        for (int i = 1; i <= 50; i++) {
            users.add(new UserGanDay("Name" + i));
        }
    }
}
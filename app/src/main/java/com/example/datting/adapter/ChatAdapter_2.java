package com.example.datting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.R;
import com.example.datting.model.UserGanDay;

import java.util.ArrayList;

public class ChatAdapter_2 extends RecyclerView.Adapter<ChatAdapter_2.ViewHolder> {
    Context context;
    ArrayList<UserGanDay> user;

    public ChatAdapter_2(Context context, ArrayList<UserGanDay> user) {
        this.context = context;
        this.user = user;
    }

    @NonNull
    @Override
    public ChatAdapter_2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_chat_2, parent, false);

        return new ChatAdapter_2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter_2.ViewHolder holder, int position) {
        UserGanDay userGanDay = user.get(position);
        holder.tvName.setText(userGanDay.getName());
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvName, tvName2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar1);
            tvName = itemView.findViewById(R.id.tvName);

        }
    }
}

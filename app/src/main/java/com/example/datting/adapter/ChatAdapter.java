package com.example.datting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.R;
import com.example.datting.model.UserGanDay;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    Context context;
    ArrayList<UserGanDay> user;
    AdapterListener adapterListener;

    public ChatAdapter(Context context, ArrayList<UserGanDay> user, AdapterListener adapterListener) {
        this.context = context;
        this.user = user;
        this.adapterListener = adapterListener;
    }
    public interface AdapterListener{
        void OnClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_chat, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        UserGanDay userGanDay = user.get(position);
//        holder.tvName.setText(userGanDay.getName());
        holder.tvName2.setText(userGanDay.getName());
        holder.dsChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterListener.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvName, tvName2;
        LinearLayout dsChat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatarChat);
//            tvName = itemView.findViewById(R.id.tvName);
            tvName2 = itemView.findViewById(R.id.tvName2);
          dsChat = itemView.findViewById(R.id.dsChat);

        }
    }
}

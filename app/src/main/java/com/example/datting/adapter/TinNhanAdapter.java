package com.example.datting.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.R;
import com.example.datting.model.TinNhan;
import com.example.datting.model.UserGanDay;

import java.util.ArrayList;

public class TinNhanAdapter extends RecyclerView.Adapter<TinNhanAdapter.ViewHolder> {
    Context context;
    ArrayList<TinNhan> tinNhans;
    TinNhanAdapter adapterListener;
    String name = Build.DEVICE;

    public TinNhanAdapter(Context context, ArrayList<TinNhan> tinNhans) {
        this.context = context;
        this.tinNhans = tinNhans;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tinnhan, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TinNhan tinNhan = tinNhans.get(position);
        // holder.tvDen.setText(tinNhan.getTinNhanDen());
        if (tinNhan.getName().equals(name)) {
            holder.tvDi.setText(tinNhan.getTinNhanDi());
            holder.tvTime.setText(tinNhan.getTime());
        } else {
            holder.tvDi.setBackground(context.getResources().getDrawable(R.drawable.custom_tvchat2));
            holder.dsChat.setGravity(Gravity.LEFT);
            holder.tvDi.setTextColor(context.getResources().getColor(R.color.colorBlack));
            holder.tvDi.setText(tinNhan.getTinNhanDi());
            holder.tvTime.setText(tinNhan.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return tinNhans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvDi, tvTime;
        LinearLayout dsChat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDi = itemView.findViewById(R.id.tvTinNhanDi);
            tvTime = itemView.findViewById(R.id.tvTime);

            dsChat = itemView.findViewById(R.id.chat);
        }
    }
}

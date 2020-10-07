package com.example.datting.adapter;

import android.content.Context;
import android.view.Gravity;
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
import com.example.datting.fragment.ExploiFragment;
import com.example.datting.model.UserGanDay;

import java.util.ArrayList;
import java.util.List;

public class GanDayAdapter extends RecyclerView.Adapter<GanDayAdapter.ViewHolder> {
    Context context;
    ArrayList<UserGanDay> user;
    AdapterListener adapterListener;

    public GanDayAdapter(Context context, ArrayList<UserGanDay> user, AdapterListener adapterListener) {
        this.context = context;
        this.user = user;
        this.adapterListener = adapterListener;
    }

    public interface AdapterListener {
        void OnClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_ganday, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        UserGanDay userGanDay = (UserGanDay) user.get(position);
        holder.tvView.setText(userGanDay.getName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterListener.OnClick(position);
            }
        });
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );
//        if (position == 1) {
//            params.setMargins(0, 150, 0, 0);
//        } else if ((position * 2 + 1) % 3 == 0) {
//            params.setMargins(0, 50, 0, 0);
//        } else if (position == 0 || position == 2) {
//            params.setMargins(0, 0, 0, 0);
//        } else if (position % 3 == 0) {
//            params.setMargins(0, -90, 0, 0);
//
//        } else if ((position - 1) % 2 == 0) {
//            params.setMargins(0, -90, 0, 0);
//        } else if (position % 2 == 0){
//            params.setMargins(0, -90, 0, 0);
//        }
//
//            holder.linearLayout.setLayoutParams(params);


    }


    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvView;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgAvatar);
            tvView = itemView.findViewById(R.id.tvName);
            linearLayout = itemView.findViewById(R.id.item);
        }
    }
}

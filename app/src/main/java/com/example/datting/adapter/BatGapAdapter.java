package com.example.datting.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.R;
import com.example.datting.model.BatGap;
import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

import java.util.List;

public class BatGapAdapter extends RecyclerView.Adapter<BatGapAdapter.ViewHolder> {
    Context context;
    private List<BatGap> list;
    AdapterListener adapterListener;
    private CardStackLayoutManager manager;

    public BatGapAdapter(Context context, List<BatGap> list, CardStackLayoutManager manager, AdapterListener adapterListener) {
        this.context = context;
        this.list = list;
        this.adapterListener = adapterListener;
        this.manager = manager;
    }

    public interface AdapterListener {
        void OnClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_batgap, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.setData(list.get(position));
        holder.linearLayout.setVisibility(View.VISIBLE);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterListener.OnClick(position);
            }
        });
        final BatGap batGap = list.get(position);
        boolean isExpanded = list.get(position).isExpanded();
        holder.constraintLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.linearLayout.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
        if (holder.linearLayout.getVisibility() == View.GONE){
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,800);
            holder.image.setLayoutParams(params);
        }
        else {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            holder.image.setLayoutParams(params);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvName, tvDiaChi, tvTuoi;
        CardView cardView;
        LinearLayout linearLayout, layoutAnh;
        ConstraintLayout constraintLayout;
        RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            tvName = itemView.findViewById(R.id.item_name);
            tvDiaChi = itemView.findViewById(R.id.item_diachi);
            tvTuoi = itemView.findViewById(R.id.item_tuoi);
            cardView = itemView.findViewById(R.id.cardview);
            linearLayout = itemView.findViewById(R.id.item_bottom);
            layoutAnh = itemView.findViewById(R.id.layoutAnh);
            constraintLayout = itemView.findViewById(R.id.item_morong);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BatGap batGap = list.get(getAdapterPosition());
                    manager.setCanScrollVertical(batGap.isExpanded());
                    manager.setCanScrollHorizontal(batGap.isExpanded());
                    batGap.setExpanded(!batGap.isExpanded());
                    Log.d("Tag", String.valueOf(batGap.isExpanded()));
                    notifyItemChanged(getAdapterPosition());

                }
            });


        }

        public void setData(BatGap batGap) {
            Picasso.get()
                    .load(batGap.getImage())
                    .fit()
                    .centerCrop()
                    .into(image);
            tvName.setText(batGap.getTen());
            tvDiaChi.setText(batGap.getDiachi());
            tvTuoi.setText(batGap.getTuoi() + "");
        }
    }

    public List<BatGap> getList() {
        return list;
    }

    public void setList(List<BatGap> list) {
        this.list = list;
    }
}

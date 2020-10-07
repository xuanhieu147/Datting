package com.example.datting.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.R;
import com.example.datting.model.BatGap;
import com.example.datting.model.Item_User;
import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    Context context;
    private List<Item_User> list;
    AdapterListener adapterListener;


    public ItemAdapter(Context context, List<Item_User> list, AdapterListener adapterListener) {
        this.context = context;
        this.list = list;
        this.adapterListener = adapterListener;

    }

    public interface AdapterListener {
        void OnClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_ttuser, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.setData(list.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterListener.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image, imgNext;
        TextView tvName;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            tvName = itemView.findViewById(R.id.item_text);
            imgNext = itemView.findViewById(R.id.imgNext);
            linearLayout = itemView.findViewById(R.id.item_linear);


        }

        public void setData(Item_User item_user) {
//            Picasso.get()
//                    .load(item_user.getImage())
//                    .fit()
//                    .centerCrop()
//                    .into(image);
            image.setImageResource(item_user.getImage());
            tvName.setText(item_user.getText());

        }
    }

    public List<Item_User> getList() {
        return list;
    }

    public void setList(List<Item_User> list) {
        this.list = list;
    }
}

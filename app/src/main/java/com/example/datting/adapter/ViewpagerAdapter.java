package com.example.datting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.datting.R;
import com.example.datting.model.BatGap;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewpagerAdapter extends PagerAdapter {
    private Context context;
    private List<BatGap> listPhotos;
    private LayoutInflater inflater;

    public ViewpagerAdapter(Context context, List<BatGap> listPhotos) {
        this.context = context;
        this.listPhotos = listPhotos;
        this.inflater = LayoutInflater.from(context);
    }

    // đi sang 1 page khác sẽ destroy item ở page cũ
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    //trả về số lượng item sẽ đc show
    @Override
    public int getCount() {
        return listPhotos.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view1 = inflater.inflate(R.layout.bottom_sheet, container, false);
        BatGap batGap = listPhotos.get(position);
        final ImageView imageView = view1.findViewById(R.id.item_image1);
        imageView.setImageResource(batGap.getImage());
        TextView tvName = view1.findViewById(R.id.item_name1);
        TextView tvDiaChi = view1.findViewById(R.id.item_diachi1);
        TextView tvTuoi = view1.findViewById(R.id.item_tuoi1);
        tvName.setText(batGap.getTen());
        tvDiaChi.setText(batGap.getDiachi());
        tvTuoi.setText(batGap.getTuoi() + "");
        ViewPager viewPager = (ViewPager) container;
        viewPager.setPageMargin(context.getResources().getDimensionPixelSize(R.dimen._8sdp));

        container.addView(view1, 0);

        return view1;
    }

    //phương thức kiểm tra xem các đối tượng đc trả về bởi instantiateItem() đc liên kết với View được cung cấp
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
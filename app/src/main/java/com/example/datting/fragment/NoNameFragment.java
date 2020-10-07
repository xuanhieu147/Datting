package com.example.datting.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.datting.R;
import com.example.datting.activity.ChonLocActivity;
import com.example.datting.adapter.BatGapAdapter;
import com.example.datting.class_khac.CardStackCallback;
import com.example.datting.model.BatGap;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;


public class NoNameFragment extends Fragment {

    private CardStackLayoutManager manager;
    private BatGapAdapter adapter;
    private ImageButton close2, tim3;
    private ImageView imgChonLoc;

    public NoNameFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_name, container, false);
        CardStackView cardStackView = view.findViewById(R.id.card_stack_view);
        imgChonLoc = view.findViewById(R.id.imgchonloc);
        imgChonLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ChonLocActivity.class));
            }
        });
        manager = new CardStackLayoutManager(getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d("TAG", "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
                if (manager.getTopPosition() == adapter.getItemCount() - 5) {
                    paginate();
                }
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d("TAG", "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);
                if (direction == Direction.Right) {

                }
                if (direction == Direction.Top) {

                }
                if (direction == Direction.Left) {

                }
                if (direction == Direction.Bottom) {

                }

                // Paginating
                if (manager.getTopPosition() == adapter.getItemCount() - 5) {
                    paginate();
                }
            }

            @Override
            public void onCardRewound() {
                Log.d("TAG", "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d("TAG", "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {

            }

            @Override
            public void onCardDisappeared(View view, int position) {

            }
        });
        adapter = new BatGapAdapter(getContext(), addList(), manager, new BatGapAdapter.AdapterListener() {
            @Override
            public void OnClick(int position) {
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());

        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    private void paginate() {
        List<BatGap> old = adapter.getList();
        List<BatGap> baru = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(old, baru);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setList(baru);
        hasil.dispatchUpdatesTo(adapter);
    }

    private List<BatGap> addList() {
        List<BatGap> items = new ArrayList<>();
        items.add(new BatGap(R.drawable.gaixinh1, 20, "Umi Chan", "Pham Van Dong"));
        items.add(new BatGap(R.drawable.gaixinh2, 18, "Trần Y", "Cau Giay"));
        items.add(new BatGap(R.drawable.gaixinh3, 19, "Yến", "Dong Da"));
        items.add(new BatGap(R.drawable.gaixinh4, 22, "Quỳnh", "Hai Ba Trung"));
        return items;
    }

}
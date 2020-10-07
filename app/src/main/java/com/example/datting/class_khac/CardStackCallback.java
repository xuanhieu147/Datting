package com.example.datting.class_khac;

import androidx.recyclerview.widget.DiffUtil;

import com.example.datting.model.BatGap;

import java.util.List;

public class CardStackCallback extends DiffUtil.Callback {

    private List<BatGap> old, baru;

    public CardStackCallback(List<BatGap> old, List<BatGap> baru) {
        this.old = old;
        this.baru = baru;
    }

    @Override
    public int getOldListSize() {
        return old.size();
    }

    @Override
    public int getNewListSize() {
        return baru.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition).getImage() == baru.get(newItemPosition).getImage();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == baru.get(newItemPosition);
    }
}

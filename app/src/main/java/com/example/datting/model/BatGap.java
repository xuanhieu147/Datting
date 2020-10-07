package com.example.datting.model;

public class BatGap {
    private int image, tuoi;
    private String ten, diachi;
    private boolean expanded;


    public BatGap(int image, int tuoi, String ten, String diachi) {
        this.image = image;
        this.tuoi = tuoi;
        this.ten = ten;
        this.diachi = diachi;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}

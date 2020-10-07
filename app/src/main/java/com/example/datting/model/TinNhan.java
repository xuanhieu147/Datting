package com.example.datting.model;

public class TinNhan {
    private String tinNhanDi, Name, Time;


    public TinNhan(String tinNhanDi, String name, String time) {
        this.tinNhanDi = tinNhanDi;
        Name = name;
        Time = time;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTinNhanDi() {
        return tinNhanDi;
    }

    public void setTinNhanDi(String tinNhanDi) {
        this.tinNhanDi = tinNhanDi;
    }


}

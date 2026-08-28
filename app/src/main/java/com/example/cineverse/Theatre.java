package com.example.cineverse;

public class Theatre {

    private String name;
    private String info;
    private String time1;
    private String time2;
    private String time3;

    public Theatre(String name, String info, String time1, String time2, String time3) {
        this.name = name;
        this.info = info;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    public String getTime3() {
        return time3;
    }
}
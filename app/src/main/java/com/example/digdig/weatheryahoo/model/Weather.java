package com.example.digdig.weatheryahoo.model;

import java.util.ArrayList;

/**
 * Created by digdig on 17-06-21.
 */

public class Weather {
    private String city;
    private String info;
    private String temp;
    private String date;
    private String img;


    public Weather(String city, String info, String temp, String date, String img) {
        this.city = city;
        this.info = info;
        this.temp = temp;
        this.date = date;
        this.img = img;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", info='" + info + '\'' +
                ", temp='" + temp + '\'' +
                ", date='" + date + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}

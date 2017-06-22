package com.example.digdig.weatheryahoo.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by digdig on 17-06-21.
 */

public class JSONManagement {

    public static ArrayList<Weather> processJSONData(String data){
        ArrayList<Weather> checkWeather =  new ArrayList<>();

        try {
            JSONObject json = new JSONObject(data);
            JSONObject main = json.getJSONObject("query").getJSONObject("results").getJSONObject("channel");
            JSONObject location = main.getJSONObject("location");
            JSONObject items = main.getJSONObject("item");
            JSONObject details = items.getJSONObject("condition");

            String city = location.getString("city");
            String text = details.getString("text");
            String date = details.getString("date");
            String temp = details.getString("temp");
            String img = details.getString("code");

            /*ArrayList<String> weeks = new ArrayList<>();
            JSONArray powerArray = items.getJSONArray("forecast");
            for (int j=0; j<powerArray.length(); j++)
            {
                String power = powerArray.getString(j);
                weeks.add(power);
            }*/

            Weather weather = new Weather(city,text,temp,date,img);
            checkWeather.add(weather);
            Log.d("JSON",weather.toString());


        } catch (Exception e) {
            Log.d("JSON",e.getMessage());
        }
        return checkWeather;
    }
}

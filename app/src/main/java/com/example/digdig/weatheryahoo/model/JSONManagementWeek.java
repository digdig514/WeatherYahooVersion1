package com.example.digdig.weatheryahoo.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by digdig on 17-06-21.
 */

public class JSONManagementWeek {
    public static ArrayList<WeatherWeek> processJSONData(String data){
        ArrayList<WeatherWeek> checkWeather =  new ArrayList<>();

        try {
            JSONObject json = new JSONObject(data);
            JSONObject main = json.getJSONObject("query").getJSONObject("results").getJSONObject("channel");
            JSONObject location = main.getJSONObject("location");
            JSONObject items = main.getJSONObject("item");
            JSONArray listOfMembers = items.getJSONArray("forecast");
            //JSONObject details = items.getJSONObject("forecast");

            for (int i=0;i<listOfMembers.length();i++) {
                JSONObject details = listOfMembers.getJSONObject(i);
                String code = details.getString("code");
                String date = details.getString("date");
                String day = details.getString("day");
                String high = details.getString("high");
                String low = details.getString("low");
                String info = details.getString("text");
                WeatherWeek weatherWeek = new WeatherWeek(code,date,day,high,low,info);
                checkWeather.add(weatherWeek);
                Log.d("JSON",weatherWeek.toString());
            }
            /*JSONObject details = items.getJSONObject("condition");
            String code = details.getString("code");
            String date = details.getString("code");
            String day = details.getString("code");
            String high = details.getString("code");
            String low = details.getString("code");
            String info = details.getString("code");*/


          /*  ArrayList<String> weeks = new ArrayList<>();
            JSONArray powerArray = items.getJSONArray("forecast");
            for (int j=0; j<powerArray.length(); j++)
            {
                String power = powerArray.getString(j);
                weeks.add(power);
            }
*/



        } catch (Exception e) {
            Log.d("JSON",e.getMessage());
        }
        return checkWeather;
    }
}

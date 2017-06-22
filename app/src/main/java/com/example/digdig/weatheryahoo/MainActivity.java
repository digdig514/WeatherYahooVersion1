package com.example.digdig.weatheryahoo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.digdig.weatheryahoo.model.CustomWeekAdapter;
import com.example.digdig.weatheryahoo.model.DownLoadImageTask;
import com.example.digdig.weatheryahoo.model.HttpGetWebsiteData;
import com.example.digdig.weatheryahoo.model.JSONManagement;
import com.example.digdig.weatheryahoo.model.JSONManagementWeek;
import com.example.digdig.weatheryahoo.model.Weather;
import com.example.digdig.weatheryahoo.model.WeatherWeek;
import com.example.digdig.weatheryahoo.model.WebSiteService;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WebSiteService,AdapterView.OnItemClickListener {
TextView textViewCity,textViewInfo,textViewTemp,textViewDate;
ImageView imageView;
ArrayAdapter<WeatherWeek> arrayAdapter;
CustomWeekAdapter customWeekAdapter;


    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize() {
        textViewCity = (TextView) findViewById(R.id.textViewCity);
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        textViewTemp = (TextView) findViewById(R.id.textViewTemp);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        listView = (ListView) findViewById(R.id.listView);
        imageView = (ImageView) findViewById(R.id.imageView);
        String website="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22montreal%2C%20ca%22)%20and%20u%3D%22c%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        HttpGetWebsiteData httpGetWebsiteData =  new HttpGetWebsiteData(this,website,textViewDate);
        //rum doInBackGround(...)
        httpGetWebsiteData.execute();

    }


    @Override
    public void sucess(String dataInXML) {

        ArrayList<Weather> weather = JSONManagement.processJSONData(dataInXML);
        ArrayList<WeatherWeek> listWeek = JSONManagementWeek.processJSONData(dataInXML);
        for(int i=0; i<weather.size();i++)
        {

        textViewDate.setText(weather.get(i).getDate());
        textViewInfo.setText(weather.get(i).getInfo());
        textViewTemp.setText(weather.get(i).getTemp()+" °C");
        textViewCity.setText(weather.get(i).getCity());
        String imgURL  = "http://l.yimg.com/a/i/us/we/52/"+weather.get(i).getImg()+".gif";
        new DownLoadImageTask(imageView).execute(imgURL);


    }

        //arrayAdapter = new ArrayAdapter<WeatherWeek>(this,android.R.layout.simple_list_item_1,listWeek);
        //listView.setAdapter(arrayAdapter);
        customWeekAdapter = new CustomWeekAdapter(this,listWeek);
        listView.setAdapter(customWeekAdapter);
        listView.setOnItemClickListener(this);



        //imageIconLive.getDrawable().
        //textViewDate.setText(dataInXML);

    }

    @Override
    public void failure(Exception exception) {
        textViewDate.setText(exception.getMessage());

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


}

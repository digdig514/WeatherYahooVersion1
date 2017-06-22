package com.example.digdig.weatheryahoo.model;

import android.content.Context;
//import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.digdig.weatheryahoo.R;

import java.util.ArrayList;

/**
 * Created by digdig on 17-06-21.
 */

public class CustomWeekAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<WeatherWeek> listOfWeek;

    public CustomWeekAdapter(Context context, ArrayList<WeatherWeek> listOfWeek) {
        this.context = context;
        this.listOfWeek = listOfWeek;
    }

    @Override
    public int getCount() {
        return listOfWeek.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfWeek.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.one_element,null);
        TextView textViewDay = (TextView)convertView.findViewById(R.id.textViewAdpDay);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageViewAdp);

        TextView textViewHigh = (TextView)convertView.findViewById(R.id.textViewAdpHigh);
        TextView textViewLow = (TextView)convertView.findViewById(R.id.textViewAdpLow);
        TextView textViewInfo = (TextView)convertView.findViewById(R.id.textViewAdpInfo);

        WeatherWeek week = listOfWeek.get(position);

        String weekCode = week.getCode();
        String weekDay = week.getDay();
        String weekTempHigh = week.getHigh();
        String weekTempLow= week.getLow();
        String weekInfo= week.getInfo();
        textViewHigh.setText("High"+weekTempHigh+"°C ");
        textViewLow.setText("Low"+weekTempLow+"°C ");
        textViewInfo.setText(" "+weekInfo);
        textViewDay.setText(weekDay+" ");
        //imageView.setImageResource(R.drawable.barham);

       String imgURL  = "http://l.yimg.com/a/i/us/we/52/"+week.getCode()+".gif";
       new DownLoadImageTask(imageView).execute(imgURL);
        int width = 220;
        int height = 220;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
        imageView.setLayoutParams(parms);
        imageView.setImageDrawable(imageView.getDrawable());
        //imageView.setImageResource();
        return convertView;
        //int clientPhoto = client.getPictures();
    }


}

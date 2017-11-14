package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextView = (TextView)findViewById(R.id.tv_display_weather_per_day);
        // Completed (2) Display the weather forecast that was passed from MainActivity
        Intent receivedIntent = getIntent();
        if (receivedIntent.hasExtra("WEATHER.EXTRA")){
            mTextView.setText(receivedIntent.getStringExtra("WEATHER.EXTRA"));
        }

    }
}
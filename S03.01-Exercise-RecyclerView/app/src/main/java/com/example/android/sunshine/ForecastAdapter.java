package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/** Adapter for the Recycler view in Sunshine App
 * Created by Vlad on 11/13/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String[] mWeatherData;

    public ForecastAdapter(){}

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{
        public final TextView mWeatherTextView;
        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView)view.findViewById(R.id.tv_weather_data);
        }
        public void bind(String weatherData){
            mWeatherTextView.setText(weatherData);
        }
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachImmediately = false;

        View view = inflater.inflate(layoutForListItem, parent, shouldAttachImmediately);
        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.bind(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null) {
            return 0;
        }
        else {
            return mWeatherData.length;
        }
    }

    public void setWeatherData(String[] weatherData){
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}

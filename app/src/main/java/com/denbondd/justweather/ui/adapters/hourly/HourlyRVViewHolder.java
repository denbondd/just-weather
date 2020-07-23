package com.denbondd.justweather.ui.adapters.hourly;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.denbondd.justweather.R;
import com.denbondd.justweather.databinding.HourlyRvitemBinding;
import com.denbondd.justweather.models.onecallowm.Hourly;
import com.denbondd.justweather.ui.fragments.main.MainFragment;
import com.denbondd.justweather.util.OWMExtensions;

public class HourlyRVViewHolder extends RecyclerView.ViewHolder {
    private ImageView weatherIcon;
    private HourlyRvitemBinding binding;

    public HourlyRVViewHolder(@NonNull View itemView) {
        super(itemView);
        weatherIcon = itemView.findViewById(R.id.ivWeatherIcon);
        binding = HourlyRvitemBinding.bind(itemView);
    }

    public void onBind(Hourly hourly) {
        binding.setHourly(hourly);

        Glide.with(itemView)
                .load(OWMExtensions.getIconById(hourly.getWeather().get(0).getId()))
                .into(weatherIcon);
    }
}
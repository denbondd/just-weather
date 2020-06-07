package com.denbondd.justweather.dataflow;

import com.denbondd.justweather.AppApplication;
import com.denbondd.justweather.BuildConfig;
import com.denbondd.justweather.R;
import com.denbondd.justweather.models.CurrentWeatherModel;
import com.denbondd.justweather.services.OpenWeatherMapApi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    private Retrofit retrofitOWM = new Retrofit.Builder()
            .baseUrl(AppApplication.getContext().getString(R.string.BASE_URL_OPEN_WEATHER_MAP))
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Call<CurrentWeatherModel> getCurrentWeather(double lat, double lon) {
        OpenWeatherMapApi openWeatherMapApi = retrofitOWM.create(OpenWeatherMapApi.class);
        return openWeatherMapApi.getCurrentWeather(lat, lon, BuildConfig.OPEN_WEATHER_MAP_API_KEY);
    }
}

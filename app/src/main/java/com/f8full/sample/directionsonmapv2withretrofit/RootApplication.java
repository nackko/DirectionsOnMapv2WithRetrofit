package com.f8full.sample.directionsonmapv2withretrofit;

import android.app.Application;

import com.f8full.sample.directionsonmapv2withretrofit.api.GoogleMapsDirectionsApi;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by F8Full on 2015-09-15.
 */
public class RootApplication extends Application {

    static final String ENDPOINT = "https://maps.googleapis.com/maps/";

    GoogleMapsDirectionsApi googleMapsDirectionsApi;

    @Override
    public void onCreate() {
        super.onCreate();
        googleMapsDirectionsApi = buildGMapsDirectionsApi();
        //accessToken = PreferencesUtils.retrieveAccessToken(this);
    }

    GoogleMapsDirectionsApi buildGMapsDirectionsApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GoogleMapsDirectionsApi.class);
    }


    public GoogleMapsDirectionsApi getGoogleMapsDirectionsApi() {
        return googleMapsDirectionsApi;
    }
}

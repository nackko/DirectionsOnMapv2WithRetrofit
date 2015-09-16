package com.f8full.sample.directionsonmapv2withretrofit.api;

import com.f8full.sample.directionsonmapv2withretrofit.api.model.GuidanceAnswerRoot;

import java.util.Map;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by F8Full on 2015-09-15.
 */
public interface GoogleMapsDirectionsApi {
    @GET("api/directions/json")
    Call<GuidanceAnswerRoot> getDirections(@QueryMap Map<String, String> options);

}

//https://maps.googleapis.com/maps/api/directions/json?origin=45.5290807503689,-73.58135472983122&destination=45.5348227237613,-73.57860814779997&sensor=false&mode=bicycling
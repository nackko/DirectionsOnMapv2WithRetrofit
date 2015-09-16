package com.f8full.sample.directionsonmapv2withretrofit.api.model;

//import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by F8Full on 2015-09-11.
 */
public class Route {

    //@Key("legs")
    public List<Leg> legs;

    //@Key("overview_polyline")
    public OverviewPolyline overview_polyline;
}

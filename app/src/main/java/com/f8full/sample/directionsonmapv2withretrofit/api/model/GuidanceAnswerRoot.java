package com.f8full.sample.directionsonmapv2withretrofit.api.model;

//import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by F8Full on 2015-09-11.
 */

public class GuidanceAnswerRoot {
    //@Key("routes")
    public List<Route> routes;
}

//https://maps.googleapis.com/maps/api/directions/json?origin=45.5290807503689,-73.58135472983122&destination=45.5348227237613,-73.57860814779997&sensor=false&mode=bicycling

/*{
   "geocoded_waypoints" : [
      {
         "geocoder_status" : "OK",
         "place_id" : "EkE0NjQxLTQ2NTUgQXZlbnVlIENocmlzdG9waGUtQ29sb21iLCBNb250csOpYWwsIFFDIEgySiAzRzcsIENhbmFkYQ",
         "types" : [ "street_address" ]
      },
      {
         "geocoder_status" : "OK",
         "place_id" : "Ejg0ODM2LTQ4MzggQXZlbnVlIFBhcGluZWF1LCBNb250csOpYWwsIFFDIEgySCAxVjYsIENhbmFkYQ",
         "types" : [ "street_address" ]
      }
   ],
   "routes" : [
      {
         "bounds" : {
            "northeast" : {
               "lat" : 45.5348176,
               "lng" : -73.5776025
            },
            "southwest" : {
               "lat" : 45.5282018,
               "lng" : -73.58151479999999
            }
         },
         "copyrights" : "Map data ©2015 Google",
         "legs" : [
            {
               "distance" : {
                  "text" : "1.2 km",
                  "value" : 1245
               },
               "duration" : {
                  "text" : "4 mins",
                  "value" : 254
               },
               "end_address" : "4836-4838 Avenue Papineau, Montréal, QC H2H 1V6, Canada",
               "end_location" : {
                  "lat" : 45.5348176,
                  "lng" : -73.57861299999999
               },
               "start_address" : "4641-4655 Avenue Christophe-Colomb, Montréal, QC H2J 3G7, Canada",
               "start_location" : {
                  "lat" : 45.5290059,
                  "lng" : -73.5814242
               },
               "steps" : [
                  {
                     "distance" : {
                        "text" : "0.2 km",
                        "value" : 164
                     },
                     "duration" : {
                        "text" : "1 min",
                        "value" : 29
                     },
                     "end_location" : {
                        "lat" : 45.5282018,
                        "lng" : -73.57965799999999
                     },
                     "html_instructions" : "Head \u003cb\u003esoutheast\u003c/b\u003e on \u003cb\u003eAvenue Christophe-Colomb\u003c/b\u003e toward \u003cb\u003eRue Généreux\u003c/b\u003e",
                     "polyline" : {
                        "points" : "ik{tGzjb`M`D_J"
                     },
                     "start_location" : {
                        "lat" : 45.5290059,
                        "lng" : -73.5814242
                     },
                     "travel_mode" : "BICYCLING"
                  },
                  {
                     "distance" : {
                        "text" : "0.2 km",
                        "value" : 171
                     },
                     "duration" : {
                        "text" : "1 min",
                        "value" : 30
                     },
                     "end_location" : {
                        "lat" : 45.5294793,
                        "lng" : -73.57844299999999
                     },
                     "html_instructions" : "Turn \u003cb\u003eleft\u003c/b\u003e onto \u003cb\u003eRue Généreux\u003c/b\u003e",
                     "maneuver" : "turn-left",
                     "polyline" : {
                        "points" : "gf{tGz_b`MsAuA{@y@{@u@s@m@"
                     },
                     "start_location" : {
                        "lat" : 45.5282018,
                        "lng" : -73.57965799999999
                     },
                     "travel_mode" : "BICYCLING"
                  },
                  {
                     "distance" : {
                        "text" : "0.3 km",
                        "value" : 286
                     },
                     "duration" : {
                        "text" : "1 min",
                        "value" : 52
                     },
                     "end_location" : {
                        "lat" : 45.5308919,
                        "lng" : -73.58151479999999
                     },
                     "html_instructions" : "Turn \u003cb\u003eleft\u003c/b\u003e onto \u003cb\u003eRue de Brébeuf\u003c/b\u003e",
                     "maneuver" : "turn-left",
                     "polyline" : {
                        "points" : "gn{tGfxa`MyGdR"
                     },
                     "start_location" : {
                        "lat" : 45.5294793,
                        "lng" : -73.57844299999999
                     },
                     "travel_mode" : "BICYCLING"
                  },
                  {
                     "distance" : {
                        "text" : "72 m",
                        "value" : 72
                     },
                     "duration" : {
                        "text" : "1 min",
                        "value" : 13
                     },
                     "end_location" : {
                        "lat" : 45.5314365,
                        "lng" : -73.58100759999999
                     },
                     "html_instructions" : "Turn \u003cb\u003eright\u003c/b\u003e onto \u003cb\u003eRue Gilford\u003c/b\u003e",
                     "maneuver" : "turn-right",
                     "polyline" : {
                        "points" : "aw{tGlkb`MmBcB"
                     },
                     "start_location" : {
                        "lat" : 45.5308919,
                        "lng" : -73.58151479999999
                     },
                     "travel_mode" : "BICYCLING"
                  },
                  {
                     "distance" : {
                        "text" : "41 m",
                        "value" : 41
                     },
                     "duration" : {
                        "text" : "1 min",
                        "value" : 7
                     },
                     "end_location" : {
                        "lat" : 45.5312292,
                        "lng" : -73.58057599999999
                     },
                     "html_instructions" : "Turn \u003cb\u003eright\u003c/b\u003e onto \u003cb\u003eRue Chambord\u003c/b\u003e",
                     "maneuver" : "turn-right",
                     "polyline" : {
                        "points" : "oz{tGhhb`Mh@uA"
                     },
                     "start_location" : {
                        "lat" : 45.5314365,
                        "lng" : -73.58100759999999
                     },
                     "travel_mode" : "BICYCLING"
                  },
                  {
                     "distance" : {
                        "text" : "0.4 km",
                        "value" : 417
                     },
                     "duration" : {
                        "text" : "1 min",
                        "value" : 74
                     },
                     "end_location" : {
                        "lat" : 45.5343477,
                        "lng" : -73.5776025
                     },
                     "html_instructions" : "Turn \u003cb\u003eleft\u003c/b\u003e onto \u003cb\u003eRue la Mennais\u003c/b\u003e",
                     "maneuver" : "turn-left",
                     "polyline" : {
                        "points" : "ey{tGreb`Mi@i@o@o@{@w@{@y@}@{@cAaA}@y@cAcAyCkC"
                     },
                     "start_location" : {
                        "lat" : 45.5312292,
                        "lng" : -73.58057599999999
                     },
                     "travel_mode" : "BICYCLING"
                  },
                  {
                     "distance" : {
                        "text" : "94 m",
                        "value" : 94
                     },
                     "duration" : {
                        "text" : "1 min",
                        "value" : 49
                     },
                     "end_location" : {
                        "lat" : 45.5348176,
                        "lng" : -73.57861299999999
                     },
                     "html_instructions" : "Turn \u003cb\u003eleft\u003c/b\u003e onto \u003cb\u003eAvenue Papineau\u003c/b\u003e",
                     "maneuver" : "turn-left",
                     "polyline" : {
                        "points" : "ul|tG~ra`Mg@xAu@nB"
                     },
                     "start_location" : {
                        "lat" : 45.5343477,
                        "lng" : -73.5776025
                     },
                     "travel_mode" : "BICYCLING"
                  }
               ],
               "via_waypoint" : []
            }
         ],
         "overview_polyline" : {
            "points" : "ik{tGzjb`M`D_JsAuAwBoBs@m@yGdRmBcBh@uAyAyAwBqBcG{FyCkCg@xAu@nB"
         },
         "summary" : "Rue la Mennais",
         "warnings" : [
            "Bicycling directions are in beta. Use caution – This route may contain streets that aren't suited for bicycling."
         ],
         "waypoint_order" : []
      }
   ],
   "status" : "OK"
}*/

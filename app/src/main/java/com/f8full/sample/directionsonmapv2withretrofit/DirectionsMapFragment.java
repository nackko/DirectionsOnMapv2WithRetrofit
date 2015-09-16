package com.f8full.sample.directionsonmapv2withretrofit;

import android.app.Fragment;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.f8full.sample.directionsonmapv2withretrofit.api.GoogleMapsDirectionsApi;
import com.f8full.sample.directionsonmapv2withretrofit.api.model.GuidanceAnswerRoot;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;


/**
 * A placeholder fragment containing a simple view.
 */
public class DirectionsMapFragment extends Fragment implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        GoogleMap.OnMapLongClickListener,
        OnMapReadyCallback {

    private GoogleMap mMapInterface = null;
    private GoogleApiClient mGoogleApiClient;

    private LatLng mUserLatLng = null;

    // These settings are the same as the settings for the map. They will in fact give you updates
    // at the maximal rates currently possible.
    private static final LocationRequest mREQUEST = LocationRequest.create()
            .setInterval(5000)         // 5 seconds
            .setFastestInterval(16)    // 16ms = 60fps
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


    private Button mButtonGo;
    private TextView mTextDistance;
    private TextView mTextDuration;
    private ProgressBar mProgressBar;



    public DirectionsMapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.fragment_map, container, false);

        mButtonGo = (Button)inflatedView.findViewById(R.id.button);
        mButtonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMapInterface.clear();
                mTextDistance.setText("");
                mTextDuration.setText("");
                mButtonGo.setEnabled(false);
            }
        });
        mTextDistance = (TextView)inflatedView.findViewById(R.id.trip_distance);
        mTextDuration = (TextView)inflatedView.findViewById(R.id.trip_time);
        mProgressBar = (ProgressBar)inflatedView.findViewById(R.id.progressBar);
        mTextDistance.setTextColor(Color.LTGRAY);
        mTextDuration.setTextColor(Color.LTGRAY);

        if(mMapInterface == null)
            ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity().getApplicationContext())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();



        return inflatedView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    public void onPause() {
        super.onPause();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapInterface = googleMap;
        mMapInterface.setMyLocationEnabled(true);
    }

    @Override
    public void onConnected(Bundle bundle) {
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient,
                mREQUEST,
                this);  // LocationListener

    }

    @Override
    public void onConnectionSuspended(int i) {
        //Nothing
    }

    @Override
    public void onLocationChanged(Location location) {

        LatLng newUserLatLng = new LatLng(location.getLatitude(), location.getLongitude());

        if (mUserLatLng == null)
        {
            mMapInterface.setOnMapLongClickListener(this);
            mMapInterface.animateCamera(CameraUpdateFactory.newLatLngZoom(newUserLatLng, 15));

            Toast.makeText(getActivity().getApplicationContext(), "Long press to set destination", Toast.LENGTH_LONG).show();
        }



        mUserLatLng = newUserLatLng;



    }



    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onMapLongClick(final LatLng latLng) {

        if (mUserLatLng != null && mProgressBar.getVisibility() != View.VISIBLE) {

            mMapInterface.clear();
            mTextDistance.setText("");
            mTextDuration.setText("");
            mButtonGo.setEnabled(false);

            Map<String, String> UrlParams = new HashMap<>();
            UrlParams.put("origin", mUserLatLng.latitude + "," + mUserLatLng.longitude);
            UrlParams.put("destination", latLng.latitude + "," + latLng.longitude);
            UrlParams.put("sensor", "false");
            UrlParams.put("mode","bicycling");

            GoogleMapsDirectionsApi api = ((RootApplication) getActivity().getApplication()).getGoogleMapsDirectionsApi();

            final Call<GuidanceAnswerRoot> call = api.getDirections(UrlParams);
            mProgressBar.setVisibility(View.VISIBLE);
            call.enqueue(new Callback<GuidanceAnswerRoot>() {
                @Override
                public void onResponse(Response<GuidanceAnswerRoot> response) {
                    // Get result Repo from response.body()

                    mProgressBar.setVisibility(View.GONE);

                    GuidanceAnswerRoot answer = response.body();

                    if (!answer.routes.isEmpty()) {

                        String encodedPoints = answer.routes.get(0).overview_polyline.points;
                        List<LatLng> latLngs = PolyUtil.decode(encodedPoints);


                        //Log.d("MYTAG", "origin " + mUserLatLng.latitude + "," + mUserLatLng.longitude + " _ " + "destination " + latLng.latitude + "," + latLng.longitude );

//Add the polyline to map
                        mMapInterface.addPolyline(new PolylineOptions()
                                .addAll(latLngs)
                                .width(5)
                                .color(Color.rgb(255,64,129)));

//See BudgetTrackDetailsFragment

//display summaring Toast
                        if (answer.routes.get(0).legs.size() == 1)  //One leg trip, directly use data as string in UI
                        {
                            mTextDistance.setText(answer.routes.get(0).legs.get(0).distance.text);
                            mTextDuration.setText(answer.routes.get(0).legs.get(0).duration.text);
                            //Toast.makeText(getActivity().getApplicationContext(), answer.routes.get(0).legs.get(0).distance.text + "  " + answer.routes.get(0).legs.get(0).duration.text, Toast.LENGTH_LONG).show();
                            mButtonGo.setEnabled(true);
                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "No route!", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Throwable t) {

                    Toast.makeText(getActivity().getApplicationContext(), "Couldn't retrieve directions", Toast.LENGTH_SHORT).show();

                    mProgressBar.setVisibility(View.GONE);

                }
            });

        }
        //https://maps.googleapis.com/maps/api/directions/json?origin=Chicago,IL&destination=Los%20Angeles,CA&sensor=false
    }
}

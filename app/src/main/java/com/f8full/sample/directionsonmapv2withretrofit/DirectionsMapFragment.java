package com.f8full.sample.directionsonmapv2withretrofit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


/**
 * A placeholder fragment containing a simple view.
 */
public class DirectionsMapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMapInterface = null;



    public DirectionsMapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.fragment_map, container, false);

        if(mMapInterface == null)
            ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);



        return inflatedView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapInterface = googleMap;
    }
}

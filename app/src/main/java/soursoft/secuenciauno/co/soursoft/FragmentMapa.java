package soursoft.secuenciauno.co.soursoft;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//import com.google.android.gms.maps.GoogleMapOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMapa extends Fragment implements OnMapReadyCallback {

    View view;
    MapFragment fragmentMap;

    public FragmentMapa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_mapa, container, false);
//            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//            fragmentTransaction.add(R.id.linear_layout_mapa, fragmentMap);
//            fragmentTransaction.commit();
//            MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//            mapFragment.getMapAsync(this);
//            GoogleMapOptions options = new GoogleMapOptions().liteMode(true);
//
//            MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//            mapFragment.getMapAsync(this);
        }
        return view;
    }


    @Override
    public void onMapReady(GoogleMap map) {
//        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}

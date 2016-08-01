package com.example.byteme.salahfinder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PrayerPlaces extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_places);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng FredensMoske = new LatLng(56.165814, 10.133332);
        LatLng MadniMasjid = new LatLng(56.142216, 10.151753);
        LatLng MasjidTaqwa = new LatLng(56.141630, 10.151977);
        LatLng AishaMoskeen = new LatLng(56.164297, 10.124341);
        LatLng EckerbergsgadeMoskeen = new LatLng(56.151341, 10.195684);
        LatLng SultanAyyubMoskeen = new LatLng(56.160400, 10.205739);

        mMap.addMarker(new MarkerOptions().position(FredensMoske).title("FredensMoske"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(FredensMoske));

        mMap.addMarker(new MarkerOptions().position(MasjidTaqwa).title("MasjidTaqwa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MasjidTaqwa));

        mMap.addMarker(new MarkerOptions().position(AishaMoskeen).title("AishaMoskeen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AishaMoskeen));

        mMap.addMarker(new MarkerOptions().position(EckerbergsgadeMoskeen).title("EckerbergsgadeMoskeen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(EckerbergsgadeMoskeen));

        mMap.addMarker(new MarkerOptions().position(SultanAyyubMoskeen).title("SultanAyyubMoskeen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SultanAyyubMoskeen));

        mMap.addMarker(new MarkerOptions().position(MadniMasjid).title("MadniMasjid"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MadniMasjid));

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("titel"));
            }
        });
    }
    public class MyActivity extends Activity {
        protected void onCreate(Bundle icicle) {
            super.onCreate(icicle);

            setContentView(R.layout.activity_prayer_places);

            final Button button = (Button) findViewById(R.id.hej);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                }
            });
        }
    }
    public class MarkerDemoActivity extends AppCompatActivity implements
            GoogleMap.OnInfoWindowClickListener,
            OnMapReadyCallback {

        private GoogleMap mMap;

        @Override
        public void onMapReady(GoogleMap map) {
            mMap = map;
            Log.e("map", "onMapReady");

            // Add markers to the map and do other map setup.

             //mMap.addMarker(new MarkerOptions().position(new LatLng()).title("ghgthg");


            // Set a listener for info window events.
            mMap.setOnInfoWindowClickListener(this);
        }

        @Override
        public void onInfoWindowClick(Marker marker) {
            Toast.makeText(this, "Info window clicked",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

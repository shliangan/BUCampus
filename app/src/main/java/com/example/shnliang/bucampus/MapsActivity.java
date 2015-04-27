package com.example.shnliang.bucampus;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;

import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AccessControlContext;
import android.text.format.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import static com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import static java.security.AccessController.getContext;


public class MapsActivity extends FragmentActivity {


    ArrayList<Marker> markers = new ArrayList<Marker>();
    protected GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
       final Button buttonRemove=(Button)findViewById(R.id.buttonRemove);
         Button buttonPlay= (Button)findViewById(R.id.BUButton);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

       // addMarkerToDay(new LatLng(10,10),"day",6);

        //listening activity.. Includes clear all and add on touch clear one
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);

        // Getting a reference to the map
        mMap = supportMapFragment.getMap();

        //Clear all on long click
        mMap.setOnMapLongClickListener(new OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                markers.clear();
                mMap.clear();
            }
        });


//        //Add new on long click.
//        mMap.setOnMapLongClickListener(new OnMapLongClickListener() {
//
//            @Override
//            public void onMapLongClick(LatLng latLng) {
//                String y = String.valueOf(markers.size());
//
//                // Creating a marker
//                Marker markerOptions = mMap.addMarker(new MarkerOptions()
//                        .position(latLng)
//                        .title(y));
//                markers.add(markerOptions);
//            }
//        });
        addMarker(mMap,new LatLng(10,10),"work");

        int hold;
        //marker click
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {


            @Override
            public boolean onMarkerClick( final Marker marker) {


                buttonRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int s = 0; s < markers.size(); s++) {
                            Marker markerhold = markers.get(s);
                            if (markerhold.equals(marker)) {
                                //delete
                                markers.remove(s);
                                marker.remove();
                                break;
                            }

                        }


                        //remove from map

                        //move camera to orig position
                        // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(42.3496, -71.0997), 13.5f));
                       // buttonRemove.setOnClickListener(null);

                    }

                });



                return false;
            }
        });




    }


    @Override
    protected void onPause(){
        super.onPause();
        //check date
        Time now = new Time();
        now.setToNow();
        int day = now.weekDay;
        //save markers on app quit
        if(day == 1){
            try {
                FileOutputStream fos = openFileOutput("Monday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 2){
            try {
                FileOutputStream fos = openFileOutput("Tuesday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 3){
            try {
                FileOutputStream fos = openFileOutput("Wednesday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 4){
            try {
                FileOutputStream fos = openFileOutput("Thursday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 5){
            try {
                FileOutputStream fos = openFileOutput("Friday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 6){
            try {
                FileOutputStream fos = openFileOutput("Saturday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 0){
            try {
                FileOutputStream fos = openFileOutput("Sunday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    //saves all markers that are on the map
    //fixed dates
    @Override
    protected void onStop() {
        super.onStop();
        //check date
        Time now = new Time();
        now.setToNow();
        int day = now.weekDay;
        //save markers on app quit
        if(day == 1){
            try {
                FileOutputStream fos = openFileOutput("Monday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 2){
            try {
                FileOutputStream fos = openFileOutput("Tuesday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 3){
            try {
                FileOutputStream fos = openFileOutput("Wednesday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 4){
            try {
                FileOutputStream fos = openFileOutput("Thursday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 5){
            try {
                FileOutputStream fos = openFileOutput("Friday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 6){
            try {
                FileOutputStream fos = openFileOutput("Saturday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 0){
            try {
                FileOutputStream fos = openFileOutput("Sunday", Context.MODE_PRIVATE);
                for(int i =0; i<markers.size(); i++) {
                    LatLng latLng = markers.get(i).getPosition();
                    double lat = latLng.latitude, lon= latLng.longitude;
                    String newline= String.valueOf('\n'),
                            latt = Double.toString(lat), lonn = Double.toString(lon);

                    fos.write(markers.get(i).getTitle().getBytes());
                    fos.write(newline.getBytes());
                    fos.write(latt.getBytes());
                    fos.write(newline.getBytes());
                    fos.write(lonn.getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    @Override
    protected void onStart(){
        super.onStart();

    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    //sets up map. Loads the saved day if it is that day//fixed dates
    private void setUpMap() {

        //zoom to current location
        mMap.setMyLocationEnabled(true);

        //set camera and height

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(42.3496,-71.0997),13.5f));
        //check Day of week
        Time now = new Time();
        now.setToNow();
        int day = now.weekDay;
        int i =0;

        //load saved markers Based on day of week
        if(day == 1){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Monday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    inlat = input.readLine();
                    inlon = input.readLine();
                    double lat = Double.parseDouble(inlat), lon = Double.parseDouble(inlon);
                    LatLng latLng = new LatLng(lat,lon);

                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(intitle));
                    markers.add(i,marker);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 2){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Tuesday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    inlat = input.readLine();
                    inlon = input.readLine();
                    double lat = Double.parseDouble(inlat), lon = Double.parseDouble(inlon);
                    LatLng latLng = new LatLng(lat,lon);

                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(intitle));
                    markers.add(i,marker);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 3){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Wednesday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    inlat = input.readLine();
                    inlon = input.readLine();
                    double lat = Double.parseDouble(inlat), lon = Double.parseDouble(inlon);
                    LatLng latLng = new LatLng(lat,lon);

                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(intitle));
                    markers.add(i,marker);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 4){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Thursday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    inlat = input.readLine();
                    inlon = input.readLine();
                    double lat = Double.parseDouble(inlat), lon = Double.parseDouble(inlon);
                    LatLng latLng = new LatLng(lat,lon);

                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(intitle));
                    markers.add(i,marker);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 5){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Friday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    inlat = input.readLine();
                    inlon = input.readLine();
                    double lat = Double.parseDouble(inlat), lon = Double.parseDouble(inlon);
                    LatLng latLng = new LatLng(lat,lon);

                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(intitle));
                    markers.add(i,marker);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 6){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Saturday")));
                String intitle, inlat, inlon;

                while ((intitle= input.readLine() )!= null){
                    inlat = input.readLine();
                    inlon = input.readLine();
                    double lat = Double.parseDouble(inlat), lon = Double.parseDouble(inlon);
                    LatLng latLng = new LatLng(lat,lon);

                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(intitle));
                    markers.add(i,marker);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 0){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Sunday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    inlat = input.readLine();
                    inlon = input.readLine();
                    double lat = Double.parseDouble(inlat), lon = Double.parseDouble(inlon);
                    LatLng latLng = new LatLng(lat,lon);

                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(intitle));
                    markers.add(i,marker);
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // function to add marker
    //takes map to put it on, position, name of marker
    public void addMarker(GoogleMap mMap, LatLng latlng, String title) {
        // here call database, drag out coordinates, create marker
        Marker ne = mMap.addMarker(new MarkerOptions()
                        .position(latlng)
                        .title(title)
        );
        markers.add(ne);

    }
    //add marker to a specific day
    //fixed dates
    public void addMarkerToDay(LatLng pos, String title, int day){
        if(day == 1){
            try {
                FileOutputStream fos = openFileOutput("Monday", Context.MODE_APPEND);

                LatLng latLng = pos;
                double lat = latLng.latitude, lon= latLng.longitude;
                String newline= String.valueOf('\n'),
                        latt = Double.toString(lat), lonn = Double.toString(lon);

                fos.write(title.getBytes());
                fos.write(newline.getBytes());
                fos.write(latt.getBytes());
                fos.write(newline.getBytes());
                fos.write(lonn.getBytes());
                fos.write(newline.getBytes());

                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 2){
            try {
                FileOutputStream fos = openFileOutput("Tuesday", Context.MODE_APPEND);

                LatLng latLng = pos;
                double lat = latLng.latitude, lon= latLng.longitude;
                String newline= String.valueOf('\n'),
                        latt = Double.toString(lat), lonn = Double.toString(lon);

                fos.write(title.getBytes());
                fos.write(newline.getBytes());
                fos.write(latt.getBytes());
                fos.write(newline.getBytes());
                fos.write(lonn.getBytes());
                fos.write(newline.getBytes());

                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 3){
            try {
                FileOutputStream fos = openFileOutput("Wednesday", Context.MODE_APPEND);

                LatLng latLng = pos;
                double lat = latLng.latitude, lon= latLng.longitude;
                String newline= String.valueOf('\n'),
                        latt = Double.toString(lat), lonn = Double.toString(lon);

                fos.write(title.getBytes());
                fos.write(newline.getBytes());
                fos.write(latt.getBytes());
                fos.write(newline.getBytes());
                fos.write(lonn.getBytes());
                fos.write(newline.getBytes());

                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 4){
            try {
                FileOutputStream fos = openFileOutput("Thursday", Context.MODE_APPEND);

                LatLng latLng = pos;
                double lat = latLng.latitude, lon= latLng.longitude;
                String newline= String.valueOf('\n'),
                        latt = Double.toString(lat), lonn = Double.toString(lon);

                fos.write(title.getBytes());
                fos.write(newline.getBytes());
                fos.write(latt.getBytes());
                fos.write(newline.getBytes());
                fos.write(lonn.getBytes());
                fos.write(newline.getBytes());

                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 5){
            try {
                FileOutputStream fos = openFileOutput("Friday", Context.MODE_APPEND);

                LatLng latLng = pos;
                double lat = latLng.latitude, lon= latLng.longitude;
                String newline= String.valueOf('\n'),
                        latt = Double.toString(lat), lonn = Double.toString(lon);

                fos.write(title.getBytes());
                fos.write(newline.getBytes());
                fos.write(latt.getBytes());
                fos.write(newline.getBytes());
                fos.write(lonn.getBytes());
                fos.write(newline.getBytes());

                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 6){
            try {
                FileOutputStream fos = openFileOutput("Saturday", Context.MODE_APPEND);

                LatLng latLng = pos;
                double lat = latLng.latitude, lon= latLng.longitude;
                String newline= String.valueOf('\n'),
                        latt = Double.toString(lat), lonn = Double.toString(lon);

                fos.write(title.getBytes());
                fos.write(newline.getBytes());
                fos.write(latt.getBytes());
                fos.write(newline.getBytes());
                fos.write(lonn.getBytes());
                fos.write(newline.getBytes());

                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(day == 0){
            try {
                FileOutputStream fos = openFileOutput("Sunday", Context.MODE_APPEND);

                LatLng latLng = pos;
                double lat = latLng.latitude, lon= latLng.longitude;
                String newline= String.valueOf('\n'),
                        latt = Double.toString(lat), lonn = Double.toString(lon);

                fos.write(title.getBytes());
                fos.write(newline.getBytes());
                fos.write(latt.getBytes());
                fos.write(newline.getBytes());
                fos.write(lonn.getBytes());
                fos.write(newline.getBytes());

                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    //works takes in string gives back address... can be expanded to give back bunch of addresses
    public Marker ConvertAdd(String locname, int day, String title) throws IOException {

        Time now = new Time();
        now.setToNow();
        int currentday = now.weekDay;

        Geocoder loc = new Geocoder(this, Locale.ENGLISH);
        List<Address> address;
        double lat, lon;
        address = loc.getFromLocationName(locname, 1);
        lat= address.get(0).getLatitude();
        lon = address.get(0).getLongitude();
        Marker newmark = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lon))
                        .title(title)
        );
        //saves it where user wants
        addMarkerToDay(new LatLng(lat, lon),locname,day);
        //if not today, do not display!

        if(day != currentday){
            newmark.remove();
        }
        else{
            markers.add(newmark);
        }

        return newmark;

    }


    public Marker ConvertAdd(String locname, String title) throws IOException {


        Geocoder loc = new Geocoder(this, Locale.ENGLISH);
        List<Address> address;
        double lat, lon;
        address = loc.getFromLocationName(locname, 1);
        lat= address.get(0).getLatitude();
        lon = address.get(0).getLongitude();
        Marker newmark = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lon))
                        .title(title)
        );
        markers.add(newmark);

        return newmark;

    }
    public Marker ConvertAdddel(String locname, String title) throws IOException {



        Geocoder loc = new Geocoder(this, Locale.ENGLISH);
        List<Address> address;
        double lat, lon;
        address = loc.getFromLocationName(locname, 1);
        lat= address.get(0).getLatitude();
        lon = address.get(0).getLongitude();
        Marker newmark = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lon))
                        .title(title)
        );

        //if not today, do not display!

            newmark.remove();


        return newmark;

    }

    //fixed dates will return the string titles of a given days events in a list
    public ArrayList<String> ReturnSchedule(int day){
        ArrayList<String> schedule = new ArrayList<String>();
        if(day == 1){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Monday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    //need to stick with memory pattern
                    inlat = input.readLine();
                    inlon = input.readLine();
                    schedule.add(intitle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 2){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Tuesday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    //need to stick with memory pattern
                    inlat = input.readLine();
                    inlon = input.readLine();
                    schedule.add(intitle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 3){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Wednesday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    //need to stick with memory pattern
                    inlat = input.readLine();
                    inlon = input.readLine();
                    schedule.add(intitle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 4){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Thursday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    //need to stick with memory pattern
                    inlat = input.readLine();
                    inlon = input.readLine();
                    schedule.add(intitle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 5){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Friday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    //need to stick with memory pattern
                    inlat = input.readLine();
                    inlon = input.readLine();
                    schedule.add(intitle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 6){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Saturday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    //need to stick with memory pattern
                    inlat = input.readLine();
                    inlon = input.readLine();
                    schedule.add(intitle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 0){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Sunday")));
                String intitle, inlat, inlon;
                while ((intitle= input.readLine() )!= null){
                    //need to stick with memory pattern
                    inlat = input.readLine();
                    inlon = input.readLine();
                    schedule.add(intitle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return schedule;
    }
    public void DeleteFromDay(int day,Marker marker /*,String titledel*/){
        if(day == 1){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Monday")));
                ArrayList<String>  inlat = new ArrayList<String>(), inlon= new ArrayList<String>(), intitle = new ArrayList<String>();
                String tit,lat,lon,sDLat,sDLon;
                LatLng toDelete = marker.getPosition();
                double dLat = toDelete.latitude, dlon= toDelete.longitude;
                sDLat = String.valueOf(dLat);
                sDLon = String.valueOf(dlon);
                //find the marker and do not add to arrays
                while ((tit = input.readLine()) != null){
                    lat = input.readLine();
                    lon = input.readLine();
                    if(!lat.equals(sDLat) && !lon.equals(sDLon)) {
                        intitle.add(tit);
                        inlat.add(lat);
                        inlon.add(lon);
                    }

                }
                //now re-save the memory based on arrays
                FileOutputStream fos = openFileOutput("Monday", Context.MODE_PRIVATE);
                for(int i =0; i<intitle.size(); i++) {
                    String newline= String.valueOf('\n');


                    fos.write(intitle.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlat.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlon.get(i).getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 2){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Tuesday")));
                ArrayList<String>  inlat = new ArrayList<String>(), inlon= new ArrayList<String>(), intitle = new ArrayList<String>();
                String tit,lat,lon,sDLat,sDLon;
                LatLng toDelete = marker.getPosition();
                double dLat = toDelete.latitude, dlon= toDelete.longitude;
                sDLat = String.valueOf(dLat);
                sDLon = String.valueOf(dlon);
                //find the marker and do not add to arrays
                while ((tit = input.readLine()) != null){
                    lat = input.readLine();
                    lon = input.readLine();
                    if(!lat.equals(sDLat) && !lon.equals(sDLon)) {
                        intitle.add(tit);
                        inlat.add(lat);
                        inlon.add(lon);
                    }

                }
                //now re-save the memory based on arrays
                FileOutputStream fos = openFileOutput("Tuesday", Context.MODE_PRIVATE);
                for(int i =0; i<intitle.size(); i++) {
                    String newline= String.valueOf('\n');


                    fos.write(intitle.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlat.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlon.get(i).getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 3){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Wednesday")));
                ArrayList<String>  inlat = new ArrayList<String>(), inlon= new ArrayList<String>(), intitle = new ArrayList<String>();
                String tit,lat,lon,sDLat,sDLon;
                LatLng toDelete = marker.getPosition();
                double dLat = toDelete.latitude, dlon= toDelete.longitude;
                sDLat = String.valueOf(dLat);
                sDLon = String.valueOf(dlon);
                //find the marker and do not add to arrays
                while ((tit = input.readLine()) != null){
                    lat = input.readLine();
                    lon = input.readLine();
                    if(!lat.equals(sDLat) && !lon.equals(sDLon)) {
                        intitle.add(tit);
                        inlat.add(lat);
                        inlon.add(lon);
                    }

                }
                //now re-save the memory based on arrays
                FileOutputStream fos = openFileOutput("Wednesday", Context.MODE_PRIVATE);
                for(int i =0; i<intitle.size(); i++) {
                    String newline= String.valueOf('\n');


                    fos.write(intitle.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlat.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlon.get(i).getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 4){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Thursday")));
                ArrayList<String>  inlat = new ArrayList<String>(), inlon= new ArrayList<String>(), intitle = new ArrayList<String>();
                String tit,lat,lon,sDLat,sDLon;
                LatLng toDelete = marker.getPosition();
                double dLat = toDelete.latitude, dlon= toDelete.longitude;
                sDLat = String.valueOf(dLat);
                sDLon = String.valueOf(dlon);
                //find the marker and do not add to arrays
                while ((tit = input.readLine()) != null){
                    lat = input.readLine();
                    lon = input.readLine();
                    if(!lat.equals(sDLat) && !lon.equals(sDLon)) {
                        intitle.add(tit);
                        inlat.add(lat);
                        inlon.add(lon);
                    }

                }
                //now re-save the memory based on arrays
                FileOutputStream fos = openFileOutput("Thursday", Context.MODE_PRIVATE);
                for(int i =0; i<intitle.size(); i++) {
                    String newline= String.valueOf('\n');


                    fos.write(intitle.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlat.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlon.get(i).getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 5){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Friday")));
                ArrayList<String>  inlat = new ArrayList<String>(), inlon= new ArrayList<String>(), intitle = new ArrayList<String>();
                String tit,lat,lon,sDLat,sDLon;
                LatLng toDelete = marker.getPosition();
                double dLat = toDelete.latitude, dlon= toDelete.longitude;
                sDLat = String.valueOf(dLat);
                sDLon = String.valueOf(dlon);
                //find the marker and do not add to arrays
                while ((tit = input.readLine()) != null){
                    lat = input.readLine();
                    lon = input.readLine();
                    if(!lat.equals(sDLat) && !lon.equals(sDLon)) {
                        intitle.add(tit);
                        inlat.add(lat);
                        inlon.add(lon);
                    }

                }
                //now re-save the memory based on arrays
                FileOutputStream fos = openFileOutput("Friday", Context.MODE_PRIVATE);
                for(int i =0; i<intitle.size(); i++) {
                    String newline= String.valueOf('\n');


                    fos.write(intitle.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlat.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlon.get(i).getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 6){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Saturday")));
                ArrayList<String>  inlat = new ArrayList<String>(), inlon= new ArrayList<String>(), intitle = new ArrayList<String>();
                String tit,lat,lon,sDLat,sDLon;
                LatLng toDelete = marker.getPosition();
                double dLat = toDelete.latitude, dlon= toDelete.longitude;
                sDLat = String.valueOf(dLat);
                sDLon = String.valueOf(dlon);
                //find the marker and do not add to arrays
                while ((tit = input.readLine()) != null){
                    lat = input.readLine();
                    lon = input.readLine();
                    if(!lat.equals(sDLat) && !lon.equals(sDLon)) {
                        intitle.add(tit);
                        inlat.add(lat);
                        inlon.add(lon);
                    }

                }
                //now re-save the memory based on arrays
                FileOutputStream fos = openFileOutput("Saturday", Context.MODE_PRIVATE);
                for(int i =0; i<intitle.size(); i++) {
                    String newline= String.valueOf('\n');


                    fos.write(intitle.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlat.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlon.get(i).getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(day == 0){
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("Sunday")));
                ArrayList<String>  inlat = new ArrayList<String>(), inlon= new ArrayList<String>(), intitle = new ArrayList<String>();
                String tit,lat,lon,sDLat,sDLon;
                LatLng toDelete = marker.getPosition();
                double dLat = toDelete.latitude, dlon= toDelete.longitude;
                sDLat = String.valueOf(dLat);
                sDLon = String.valueOf(dlon);
                //find the marker and do not add to arrays
                while ((tit = input.readLine()) != null){
                    lat = input.readLine();
                    lon = input.readLine();
                    if(!lat.equals(sDLat) && !lon.equals(sDLon)) {
                        intitle.add(tit);
                        inlat.add(lat);
                        inlon.add(lon);
                    }

                }
                //now re-save the memory based on arrays
                FileOutputStream fos = openFileOutput("Sunday", Context.MODE_PRIVATE);
                for(int i =0; i<intitle.size(); i++) {
                    String newline= String.valueOf('\n');


                    fos.write(intitle.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlat.get(i).getBytes());
                    fos.write(newline.getBytes());
                    fos.write(inlon.get(i).getBytes());
                    fos.write(newline.getBytes());
                }
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Time now = new Time();
        now.setToNow();
        int currentday = now.weekDay;
        if(day == currentday){
            marker.remove();

        }

    }


}


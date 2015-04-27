package com.example.shnliang.bucampus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;


public class Description  extends MapsActivity  {
        ArrayList<Integer> day = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        TextView descript = (TextView) findViewById(R.id.text_description);
        TextView build = (TextView) findViewById(R.id.text_building);
        TextView addr = (TextView) findViewById(R.id.text_address);
        descript.setText(MainActivity.description);
        build.setText(MainActivity.building);
        addr.setText(MainActivity.address);

        Button buttonReset=(Button)findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
               boolean x=false;
               x= deleteAll();
                if(x==true){
                    Toast.makeText(v.getContext(), "Week Reset Complete", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(v.getContext(), "Nothing to Reset", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Description.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button buttonMaps=(Button) findViewById(R.id.button_maps);
        buttonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Description.this, MapsActivity.class);
                startActivity(intent);
            }
        });

//        Button removeMarker=(Button)findViewById(R.id.buttonRemoveMarker);
//        removeMarker.setOnClickListener(new View.OnClickListener() {
//            Marker marker;
//            public void onClick(View v) {
//                try {
//                    marker =ConvertAdddel(MainActivity.address,MainActivity.description);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//               if(day.size()>0){
//                   for(int i =0; i<day.size(); i++){
//                       DeleteFromDay(day.get(i), marker);
//                   }
//               }
//                else{
//                   for(int i=0; i<day.size();i++){
//                       day.add(i);
//                   }
//                   for(int i =0; i<day.size(); i++){
//                       DeleteFromDay(day.get(i), marker);
//                   }
//               }
//
//                Intent intent = new Intent(Description.this, MapsActivity.class);
//                startActivity(intent);
//
//
//            }
//
//
//        });



        Button addMarker=(Button) findViewById(R.id.button_marker);
        addMarker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(day.size()>0){
                for(int i = 0 ; i < day.size(); i++) {
                    try {
                       ConvertAdd(MainActivity.address,day.get(i), MainActivity.building,MainActivity.description,MainActivity.address );

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }}
                else{
                    try {
                         ConvertAdd(MainActivity.address, MainActivity.building,MainActivity.description,MainActivity.address );

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                Intent intent = new Intent(Description.this, MapsActivity.class);
                startActivity(intent);


            }
        });

        ToggleButton Monday = (ToggleButton) findViewById(R.id.MButton);
        Monday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    day.add(1);


                } else {
                    // The toggle is disabled
                    for(int i =0; i< day.size();i++){
                        if(day.get(i)==1){
                            day.remove(i);
                        }
                    }
                }
            }
        });

        ToggleButton Tuesday = (ToggleButton) findViewById(R.id.TuButton);
        Tuesday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    day.add(2);


                } else {
                    // The toggle is disabled
                    for(int i =0; i< day.size();i++){
                        if(day.get(i)==2){
                            day.remove(i);
                        }
                    }
                }
            }
        });

        ToggleButton Wednesday = (ToggleButton) findViewById(R.id.WButton);
        Wednesday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    day.add(3);


                } else {
                    // The toggle is disabled
                    for(int i =0; i< day.size();i++){
                        if(day.get(i)==3){
                            day.remove(i);
                        }
                    }
                }
            }
        });

        ToggleButton Thursday = (ToggleButton) findViewById(R.id.ThButton);
        Thursday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    day.add(4);


                } else {
                    // The toggle is disabled
                    for(int i =0; i< day.size();i++){
                        if(day.get(i)==4){
                            day.remove(i);
                        }
                    }
                }
            }
        });

        ToggleButton Friday = (ToggleButton) findViewById(R.id.FButton);
        Friday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    day.add(5);


                } else {
                    // The toggle is disabled
                    for(int i =0; i< day.size();i++){
                        if(day.get(i)==5){
                            day.remove(i);
                        }
                    }
                }
            }
        });

        ToggleButton Saturday = (ToggleButton) findViewById(R.id.SatButton);
        Saturday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    day.add(6);


                } else {
                    // The toggle is disabled
                    for(int i =0; i< day.size();i++){
                        if(day.get(i)==6){
                            day.remove(i);
                        }
                    }
                }
            }
        });

        ToggleButton Sunday = (ToggleButton) findViewById(R.id.SunButton);
        Sunday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    day.add(0);


                } else {
                    // The toggle is disabled
                    for(int i =0; i< day.size();i++){
                        if(day.get(i)==0){
                            day.remove(i);
                        }
                    }
                }
            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_description, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

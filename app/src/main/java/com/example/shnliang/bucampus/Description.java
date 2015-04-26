package com.example.shnliang.bucampus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;


public class Description  extends MapsActivity  {

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


        Button addMarker=(Button) findViewById(R.id.button_marker);
        addMarker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Marker marker = ConvertAdd(MainActivity.address, MainActivity.description);
                    markers.add(marker);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Description.this, MapsActivity.class);
                startActivity(intent);

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

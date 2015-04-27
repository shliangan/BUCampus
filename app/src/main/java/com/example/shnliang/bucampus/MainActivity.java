package com.example.shnliang.bucampus;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.logging.Filter;

/*
 * Very basic Activity, the only things it does
 * are get the ListView reference from our layout.
 * Create an Adapter, set the Adapter to the ListView
 * and handle the onItemClick events for when the user
 * clicks on a row.
 */


public class MainActivity extends Activity {

    public static String address;
    public static String building;
    public static String description;


    CSVAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Button buttonMaps=(Button) findViewById(R.id.buttonMaps);
        buttonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });


        //Lookup our ListView
        ListView mList = (ListView)findViewById(R.id.listBuildings);

        //Create Adapter. The second parameter is required by ArrayAdapter
        //which our Adapter extends. In this example though it is unused,
        //so we'll pass it a "dummy" value of -1.
        mAdapter = new CSVAdapter(this, -1);

        //attach our Adapter to the ListView. This will populate all of the rows.
        mList.setAdapter(mAdapter);


		/*
		 * This listener will get a callback whenever the user clicks on a row.
		 * The pos parameter will tell us which row got clicked.
		 *
		 * For now we'll just show a Toast with the state capital for the state that was clicked.
		 */
        mList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos,long id) {
                //Toast.makeText(v.getContext(), mAdapter.getItem(pos).getAddress(), Toast.LENGTH_SHORT).show();
               building=mAdapter.getItem(pos).getBuilding();
                address=mAdapter.getItem(pos).getAddress();
                description=mAdapter.getItem(pos).getDescription();
                Intent intent = new Intent(MainActivity.this, Description.class);
                startActivity(intent);
            }
        });

        EditText searchText = (EditText) findViewById(R.id.inputSearch);
        searchText.addTextChangedListener(new TextWatcher(){

            @Override
            public void afterTextChanged(Editable arg0) {
                // Do nothing
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdapter.getFilter().filter(s);
            }

        });
    }
}

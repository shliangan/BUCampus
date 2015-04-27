package com.example.shnliang.bucampus;

/**
 * Created by shnliang on 4/23/15.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


/*
 * Custom Adapter that takes state name, description and address out of a csv
 * file from the assets and uses those values to build a List of State objects.
 * Overrides the default getView() method to return a TextView with the state name.
 *
 * ArrayAdapter - a type of Adapter that works a lot like ArrayList.
 */
public class CSVAdapter extends ArrayAdapter<BUBuildings> {
    Context ctx;
    //We must accept the textViewResourceId parameter, but it will be unused
    //for the purposes of this example.

    public CSVAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);

        //Store a reference to the Context so we can use it to load a file from Assets.
        this.ctx = context;

        //Load the data.
        loadArrayFromFile();
    }

    private ArrayList<BUBuildings> buildingsArray = new ArrayList<BUBuildings>();

    public ArrayList<BUBuildings> getBuildingsArray() {
        return buildingsArray;
    }

    /*
     * getView() is the method responsible for building a View out of a some data that represents
     * one row within the ListView. For this example our row will be a single TextView that
     * gets populated with the state name.
     * (non-Javadoc)
     * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {
		/*
		 * Using convertView is important. The system will pass back Views that have been
		 * created but scrolled off of the top (or bottom) of the screen, and thus are no
		 * longer being shown on the screen. Since they are unused, we can "recycle" them
		 * instead of creating a new View object for every row, which would be wasteful,
		 * and lead to poor performance.
		 *  with larger more complex projects it will make a significant
		 * improvement by recycling Views rather than creating new ones for each row.
		 */

        View mView = convertView;
        //If convertView was null then we have to create a new TextView.
        //If it was not null then we'll re-use it by setting the appropriate
        //text String to it


        if (null == mView) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(R.layout.layout, null);

        }

        //Set the state name as the text.
        //  mView.setText(getItem(pos).getBuilding());
        TextView building = (TextView) mView.findViewById(R.id.item_building);
        TextView description = (TextView) mView.findViewById(R.id.item_description);
        TextView address = (TextView) mView.findViewById(R.id.item_address);
        if (building != null) {

            building.setText(getItem(pos).getBuilding());
        }
        if (building != null) {
            description.setText(getItem(pos).getDescription());
        }
        if (building != null) {
            address.setText(getItem(pos).getAddress());
        }
        //We could handle the row clicks from here. But instead
        //we'll use the ListView.OnItemClickListener from inside
        //of MainActivity, which provides some benefits over doing it here.

		/*mView.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(parent.getContext(), getItem(pos).getCapital(), Toast.LENGTH_SHORT).show();
			}
		});*/

        return mView;
    }

    /*
     * Helper method that loads the data from the states.csv and builds
     * each csv row into a State object which then gets added to the Adapter.
     */
    private void loadArrayFromFile() {
        try {
            // Get input stream and Buffered Reader for our data file.
            InputStream is = ctx.getAssets().open("BU_Database.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            //Read each line
            while ((line = reader.readLine()) != null) {

                //Split to separate the name from the capital
                String[] RowData = line.split(",");

                //Create a State object for this row's data.
                BUBuildings cur;
                cur = new BUBuildings(RowData[0], RowData[1], RowData[2]);

                //Add the State object to the ArrayList (in this case we are the ArrayList).
                this.add(cur);
                buildingsArray.add(cur);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class BuildingFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults retval = new FilterResults();
            retval.values = buildingsArray;
            retval.count = buildingsArray.size();
            if (constraint.toString().length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList filt = new ArrayList();
                ArrayList tmpItems = new ArrayList();
                tmpItems.addAll(buildingsArray);
                for (int i = 0; i < tmpItems.size(); i++) {
                    BUBuildings bu = (BUBuildings) tmpItems.get(i);
                    if (bu.getBuilding().toUpperCase().contains(constraint) || bu.getDescription().toUpperCase().contains(constraint)||bu.getAddress().toUpperCase().contains(constraint)) {
                        filt.add(bu);
                    }
                }
                retval.count = filt.size();
                retval.values = filt;
            }
            return retval;
        }

        ArrayList<BUBuildings> filteredItems = new ArrayList<BUBuildings>();

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredItems = (ArrayList) results.values;
            notifyDataSetChanged();
            clear();
            Log.d("Filter", "Starting to publish the results with " + filteredItems.size() + " items");
            for (int i = 0; i < filteredItems.size(); i++) {
                add(filteredItems.get(i));
            }
            Log.d("Filter", "Finished publishing results");
            notifyDataSetInvalidated();
        }



    }

    BuildingFilter filter;
    @Override
    public Filter getFilter() {
        if (filter == null){
            filter = new BuildingFilter();
        }
        return filter;
    }

}

package com.example.varun.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] forecastArray = {
                    "Today - Sunny 23/19",
                    "Tomorrow - Cloudy 22/11",
                    "Tuesday - Rainy 22/11",
                    "Wednesday - Haily 22/11",
                    "Thursday - Stormy 22/11",
                    "Friday - Chilly 22/11",
                    "Saturday - Muddy 22/11",
                    "Next Sunday - Cloudy 22/11",
                    "Next Monday - Cloudy 22/11",
                    "Next Tuesday - Rainy 22/11",
                    "Next Wednesday - Haily 22/11",
                    "Next Thursday - Stormy 22/11",
                    "Next Friday - Chilly 22/11",
                    "Next Saturday - Muddy 22/11",

            };
            List<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray)
            );

            ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weekForecast
            );

            ListView listView = (ListView) rootView.findViewById(
                    R.id.listview_forecast
            );
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}

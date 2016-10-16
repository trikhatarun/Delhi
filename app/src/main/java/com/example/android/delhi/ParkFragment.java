package com.example.android.delhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by trikh on 16-10-2016.
 */

public class ParkFragment extends Fragment {
    public ParkFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> parks = new ArrayList<>();
        parks.add(new Location(R.string.buddhaJayantiPark, R.drawable.buddha_jayanti_park, R.string.buddhaDescription, R.string.locBuddha));
        parks.add(new Location(R.string.deerPark, R.drawable.deer_park, R.string.deerParkDescription, R.string.locDeerPark));
        parks.add(new Location(R.string.gardenOf5Senses, R.drawable.garden_of_five_senses, R.string.gardenDescription, R.string.locGardenof5Senses));
        parks.add(new Location(R.string.indraprasthaPark, R.drawable.indraprasthapark_stupa, R.string.indraprasthaDecription, R.string.locIndraprastha));
        parks.add(new Location(R.string.nehruPark, R.drawable.nehru_park, R.string.nehruParkDescription, R.string.locNehruPark));


        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), parks);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(locationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location current_location = parks.get(position);
                Intent detail_screen = new Intent(getActivity(), DetailActivity.class);
                detail_screen.putExtra("location", current_location);
                startActivity(detail_screen);
            }
        });
        return rootView;
    }
}

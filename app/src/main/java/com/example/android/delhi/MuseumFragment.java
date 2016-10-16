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
 * Created by trikh on 14-10-2016.
 */

public class MuseumFragment extends Fragment {
    public MuseumFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        final ArrayList<Location> museums = new ArrayList<>();
        museums.add(new Location(R.string.national_police_museum, R.drawable.national_police_museum, R.string.policeDescription, R.string.locPolice));
        museums.add(new Location(R.string.rail_museum, R.drawable.nationalrailwaymuseum, R.string.railDescription, R.string.locRail));
        museums.add(new Location(R.string.science_center, R.drawable.science_museum, R.string.science_centerDescription, R.string.locScience));
        museums.add(new Location(R.string.nehru_museum, R.drawable.nehru, R.string.nehru_museumDescription, R.string.locNehru));
        museums.add(new Location(R.string.air_force_museum, R.drawable.airforce_museum, R.string.air_forceDescription, R.string.locAirForce));
        museums.add(new Location(R.string.archeologic_museum, R.drawable.archeological_museum, R.string.archeologyDescription, R.string.locArchaeological));
        museums.add(new Location(R.string.crafts_museum, R.drawable.crafts_museum, R.string.craftsDescription, R.string.locCrafts));
        LocationAdapter museum_adapter = new LocationAdapter(getActivity(), museums);
        listView.setAdapter(museum_adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location current_location = museums.get(position);
                Intent detail_screen = new Intent(getActivity(), DetailActivity.class);
                detail_screen.putExtra("location", current_location);
                startActivity(detail_screen);
            }
        });
        return rootView;
    }
}

package com.example.android.delhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by trikh on 11-10-2016.
 */

public class MonumentFragment extends Fragment {
    public MonumentFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> monuments = new ArrayList<>();
        monuments.add(new Location(R.string.coronation, R.drawable.coronation, R.string.coronationDescription, R.string.locCoronation));
        monuments.add(new Location(R.string.humayuntomb, R.drawable.humayuntomb, R.string.humayuntombDescription, R.string.locHumayunTomb));
        monuments.add(new Location(R.string.indiagate, R.drawable.delhi1, R.string.indiagateDescription, R.string.locIndiaGate));
        monuments.add(new Location(R.string.jamamasjid, R.drawable.jamamasjid, R.string.jamamasjidDescrition, R.string.locJamaMasjid));
        monuments.add(new Location(R.string.jantarmantar, R.drawable.jantarmantar, R.string.jantarmantarDescrition, R.string.locJantarMantar));
        monuments.add(new Location(R.string.lodhigarden, R.drawable.lodhigarden, R.string.lodhigardenDescription, R.string.locLodhiGarden));
        monuments.add(new Location(R.string.oldfort, R.drawable.purana_qila, R.string.oldfortDescription, R.string.locOldFort));
        monuments.add(new Location(R.string.parliament, R.drawable.parliament, R.string.parliamenthouseDescription, R.string.locParliament));
        monuments.add(new Location(R.string.qutubminar, R.drawable.qutubminar, R.string.qutubminarDescription, R.string.locQutubMinar));
        monuments.add(new Location(R.string.rajghat, R.drawable.rajghat, R.string.rajghatDescrition, R.string.locRajGhat));
        monuments.add(new Location(R.string.redfort, R.drawable.redfort, R.string.redfortDescription, R.string.locRedFort));
        monuments.add(new Location(R.string.safdarjung, R.drawable.safdurjung, R.string.safdarjungDescription, R.string.locSafdarjung));
        monuments.add(new Location(R.string.shantivan, R.drawable.shantivan_delhi, R.string.shantivanDescription, R.string.locShantivan));
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), monuments);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(locationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location current_location = monuments.get(position);
                Intent detail_screen = new Intent(getActivity(), DetailActivity.class);
                detail_screen.putExtra("location", current_location);
                startActivity(detail_screen);
            }
        });
        return rootView;
    }
}

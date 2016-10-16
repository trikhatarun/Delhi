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

public class LibraryFragment extends Fragment {
    public LibraryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        final ArrayList<Location> libraries = new ArrayList<>();
        libraries.add(new Location(R.string.delhi_public_library, R.drawable.delhi_public_library, R.string.delhi_libraryDescription, R.string.locDelLibrary));
        libraries.add(new Location(R.string.american_library, R.drawable.american_centre_library, R.string.americanDescription, R.string.locAmericanLibrary));
        libraries.add(new Location(R.string.british_library, R.drawable.british_council_library_delhi_, R.string.britishDescription, R.string.locBritishLibrary));
        libraries.add(new Location(R.string.habitat_library, R.drawable.habitat_library, R.string.habitatDescription, R.string.locHabitatLibrary));
        libraries.add(new Location(R.string.japan_library, R.drawable.japan_library, R.string.japanDescription, R.string.locJapanLibrary));
        libraries.add(new Location(R.string.nehru_library, R.drawable.nehru_library, R.string.nehru_museumDescription, R.string.locNehruLibrary));
        libraries.add(new Location(R.string.sahitya_library, R.drawable.sahitya, R.string.sahityaDescription, R.string.locSahityaLibrary));
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), libraries);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(locationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location current_location = libraries.get(position);
                Intent detail_screen = new Intent(getActivity(), DetailActivity.class);
                detail_screen.putExtra("location", current_location);
                startActivity(detail_screen);
            }
        });
        return rootView;
    }
}

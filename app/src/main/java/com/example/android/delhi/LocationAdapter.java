package com.example.android.delhi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by trikh on 11-10-2016.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_item, parent, false);
        }
        Location currentLocation = getItem(position);
        ImageView logo = (ImageView) listItemView.findViewById(R.id.logo);
        logo.setImageResource(currentLocation.getmImageId());
        TextView name = (TextView) listItemView.findViewById(R.id.title);
        name.setText(currentLocation.getmTitleId());
        return listItemView;
    }
}

package com.montini.teamsports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsAdapter extends ArrayAdapter<PlayEvent> {

    public EventsAdapter(Context context, ArrayList<PlayEvent> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        PlayEvent pe = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.events_list_row, parent, false);
        }

        // Lookup view for data population
        TextView tvDate = (TextView) convertView.findViewById(R.id.eventDate);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.eventLocation);

        // Populate the data into the template view using the data object
        tvDate.setText(pe.date.toString());
        tvLocation.setText(pe.location.name);

        // Return the completed view to render on screen
        return convertView;
    }
}

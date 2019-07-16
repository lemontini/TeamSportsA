package com.montini.teamsports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventsAdapter extends ArrayAdapter<PlayEvent> {

    private List<PlayEvent> data = new ArrayList<>();
    private Context mContext;

    public EventsAdapter(Context context, ArrayList<PlayEvent> events) {
        super(context, 0, events);
        mContext = context;
        data = events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;

        // Check if an existing view is being reused, otherwise inflate the view
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.events_list_row, parent, false);
        }

        // Get the data item for this position
        // PlayEvent pe = getItem(position);
        PlayEvent pe = data.get(position);

        // Lookup view for data population
        TextView tvDate = convertView.findViewById(R.id.eventDate);
        TextView tvLocation = convertView.findViewById(R.id.eventLocation);

        // Populate the data into the template view using the data object
        tvDate.setText(pe.date.toString());
        tvLocation.setText(pe.location.name);

        // Return the completed view to render on screen
        return listItem;
    }
}

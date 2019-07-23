package com.montini.teamsports;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private List<PlayEvent> data = new ArrayList<>();
    private Context mContext;

    public EventsAdapter(List<PlayEvent> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
        System.out.println(data.get(0).location.name);
    }

    // public EventsAdapter(Context context, ArrayList<PlayEvent> events) {
    //     super(context, 0, events);
    //     mContext = context;
    //     data = events;
    // }
    //
    // @Override
    // public View getView(int position, View convertView, ViewGroup parent) {
    //     View listItem = convertView;
    //
    //     // Check if an existing view is being reused, otherwise inflate the view
    //     if (listItem == null) {
    //         listItem = LayoutInflater.from(mContext).inflate(R.layout.events_list_row, parent, false);
    //     }
    //
    //     // Get the data item for this position
    //     // PlayEvent pe = getItem(position);
    //     PlayEvent pe = data.get(position);
    //
    //     // Lookup view for data population
    //     TextView tvDate = listItem.findViewById(R.id.eventDate);
    //     TextView tvLocation = listItem.findViewById(R.id.eventLocation);
    //
    //     // Populate the data into the template view using the data object
    //     tvDate.setText(pe.date.toString());
    //     tvLocation.setText(pe.location.name);
    //     System.out.println(tvDate.getText() + " / " + tvLocation.getText());
    //
    //     // Return the completed view to render on screen
    //     return listItem;
    // }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.events_list_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PlayEvent listItem = data.get(position);

        viewHolder.eDate.setText(listItem.date.toString());
        viewHolder.eLocation.setText(listItem.location.name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView eDate;
        public TextView eLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eDate = itemView.findViewById(R.id.eventDate);
            eLocation = itemView.findViewById(R.id.eventLocation);
        }
    }
}

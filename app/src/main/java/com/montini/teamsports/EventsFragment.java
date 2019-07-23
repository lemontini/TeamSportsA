package com.montini.teamsports;

import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.sql.Date;
import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private RecyclerView eventsListView;
    private RecyclerView.Adapter adapter;
    // ListView eventsListView;
    // EventsAdapter adapter;

    public EventsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events, container, false);

        eventsListView = (RecyclerView) v.findViewById(R.id.eventsList);
        eventsListView.setHasFixedSize(true);
        eventsListView.setLayoutManager(new LinearLayoutManager(v.getContext())); // v.getActivity()

        ArrayList<PlayEvent> pe = new ArrayList<>();
        pe.add(new PlayEvent(
                Date.valueOf("2019-07-13"),
                new Location("SEB arena", "Ąžuolyno g. 7, Vilnius", 2),
                MainActivity.DOUBLES));

        adapter = new EventsAdapter(pe, v.getContext());
        // Log.e("WTF", v.getContext().toString());

        eventsListView.setAdapter(adapter);

        return v;
    }

}

package com.montini.teamsports;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Date;
import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private MyRecyclerView eventsListView;
    private RecyclerView.Adapter adapter;
    private ArrayList<PlayEvent> playEvents;
    // ListView eventsListView;
    // EventsAdapter adapter;

    public EventsFragment() {
        playEvents = new ArrayList<>();
        playEvents.add(new PlayEvent(
                Date.valueOf("2019-07-13"),
                new Location("SEB arena", "Ąžuolyno g. 7, Vilnius", 4),
                MainActivity.DOUBLES));
        playEvents.add(new PlayEvent(
                Date.valueOf("2019-07-27"),
                new Location("Delfi arena", "Ozo g. 14c, Vilnius", 8),
                MainActivity.DOUBLES));
        playEvents.get(0).addPlayer(new Player("Mantas"));
        playEvents.get(0).addPlayer(new Player("Rokas"));
        playEvents.get(0).addPlayer(new Player("Šaras"));
        playEvents.get(0).addPlayer(new Player("Rasa"));

        playEvents.get(0).addPlayer(new Player("Sekmas"));
        playEvents.get(0).addPlayer(new Player("Tadas"));
        playEvents.get(0).addPlayer(new Player("Rolis"));
        playEvents.get(0).addPlayer(new Player("Giedrė"));
        playEvents.get(0).addPlayer(new Player("Aleksandra"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events, container, false);

        eventsListView = (MyRecyclerView) v.findViewById(R.id.eventsList);
        eventsListView.setHasFixedSize(true);
        eventsListView.setLayoutManager(new LinearLayoutManager(v.getContext())); // v.getActivity()

        View emptyView = v.findViewById(R.id.events_list_empty_view);
        eventsListView.setEmptyView(emptyView);

        adapter = new EventsAdapter(playEvents, v.getContext());
        // Log.e("WTF", v.getContext().toString());

        eventsListView.setAdapter(adapter);

        return v;
    }

}

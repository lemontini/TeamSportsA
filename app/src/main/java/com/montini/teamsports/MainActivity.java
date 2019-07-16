package com.montini.teamsports;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Date;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // ActionBar toolbar;
    BottomNavigationView navMain;
    ViewPager viewPager;
    static ListView eventsListView;

    static int numPlayers = 0;
    static int numFreeAgents = 0;
    static final boolean SINGLES = true;
    static final boolean DOUBLES = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_event:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_location:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_player:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navMain = findViewById(R.id.navigationView); // init Navigation Bar
        navMain.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener); // set listener for Navigation Items

        viewPager = findViewById(R.id.container); // init Viewpager
        SetupFragmentManager(getSupportFragmentManager(), viewPager); // setup Fragment

        viewPager.setCurrentItem(0); // set current item when activity start
        viewPager.addOnPageChangeListener(new PageChange()); // listeners for Viewpager when page changed TODO: Ask Yohan how will this Listener react in case of Pause/Resume (maybe removeOnPageChangeListener() should be used?)

        MainStuff();
    }

    public static void SetupFragmentManager(FragmentManager fragmentManager, ViewPager viewPager) {
        FragmentAdapter Adapter = new FragmentAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new EventsFragment(), "Page One");
        Adapter.add(new LocationsFragment(), "Page Two");
        Adapter.add(new PlayersFragment(), "Page Three");
        viewPager.setAdapter(Adapter);
    }

    public class PageChange implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    navMain.setSelectedItemId(R.id.navigation_event);
                    break;
                case 1:
                    navMain.setSelectedItemId(R.id.navigation_location);
                    break;
                case 2:
                    navMain.setSelectedItemId(R.id.navigation_player);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    private void MainStuff() {
        // Construct the data source
        ArrayList<PlayEvent> playEvents = new ArrayList<>();

        // add one event
        playEvents.add(new PlayEvent(
                Date.valueOf("2019-07-13"),
                new Location("SEB arena", "Ąžuolyno g. 7, Vilnius", 2),
                DOUBLES));

        // PlayEvent pe1 = new PlayEvent(
        //         Date.valueOf("2019-07-13"),
        //         new Location("SEB arena", "Ąžuolyno g. 7, Vilnius", 2),
        //         DOUBLES);

        playEvents.get(0).addPlayer(new Player("Mantas"));
        playEvents.get(0).addPlayer(new Player("Rokas"));
        playEvents.get(0).addPlayer(new Player("Šaras"));
        playEvents.get(0).addPlayer(new Player("Rasa"));

        playEvents.get(0).addPlayer(new Player("Sekmas"));
        playEvents.get(0).addPlayer(new Player("Tadas"));
        playEvents.get(0).addPlayer(new Player("Rolis"));
        playEvents.get(0).addPlayer(new Player("Giedrė"));
        playEvents.get(0).addPlayer(new Player("Aleksandra"));

        System.out.println(numFreeAgents);

        // Create the adapter to convert the array to views
        EventsAdapter adapter = new EventsAdapter(this, playEvents);
        // Attach the adapter to a ListView
        eventsListView = findViewById(R.id.eventsList);
        eventsListView.setAdapter(adapter);

    }


}
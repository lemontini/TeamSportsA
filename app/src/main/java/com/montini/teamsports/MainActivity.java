package com.montini.teamsports;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    // ActionBar toolbar;

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
                    return true;
                case R.id.navigation_location:
                    return true;
                case R.id.navigation_player:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navMain = findViewById(R.id.navigationView);
        navMain.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        PlayEvent pe1 = new PlayEvent(
                Date.valueOf("2019-07-13"),
                new Location("SEB arena", "Ąžuolyno g. 7, Vilnius", 2),
                DOUBLES);

        pe1.addPlayer(new Player("Mantas"));
        pe1.addPlayer(new Player("Rokas"));
        pe1.addPlayer(new Player("Šaras"));
        pe1.addPlayer(new Player("Rasa"));

        pe1.addPlayer(new Player("Sekmas"));
        pe1.addPlayer(new Player("Tadas"));
        pe1.addPlayer(new Player("Rolis"));
        pe1.addPlayer(new Player("Giedrė"));
        pe1.addPlayer(new Player("Aleksandra"));

        System.out.println(numFreeAgents);
    }
}
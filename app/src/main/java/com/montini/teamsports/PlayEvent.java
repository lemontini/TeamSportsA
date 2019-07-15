package com.montini.teamsports;

import java.util.ArrayList;
import java.util.Date;

public class PlayEvent {
    Date date;
    Location location;
    int numCourts;
    Boolean playSingles = false;
    ArrayList<Court> courts;

    public PlayEvent(Date date, Location location, Boolean playSingles) {
        this.date = date;
        this.courts = new ArrayList<Court>();
        this.location = location;
        System.out.println("A " + (playSingles ? "singles" : "doubles") + " play event on " + date + " at " + location.name + " was created.");
        this.courts.add(new Court(playSingles ? 2 : 4));
        numCourts++;
    }

    public void addPlayer(Player player) {

        if (this.courts.get(numCourts - 1).size == this.courts.get(numCourts - 1).maxPlayers) { // jeigu žaidėjų skaičius lygus leistinam tame korte
            if (this.numCourts < this.location.maxCourts) { // jeigu kortų skaičius ne didesnis negu maksimalus leistinas toje vietoje
                this.courts.add(new Court(playSingles ? 2 : 4)); // pridedame papildomą kortą
                numCourts++; // padidiname kortų skaičių
                this.courts.get(numCourts - 1).addPlayer(player); // pridedame naują žaidėją naujame korte
            } // else System.out.println("Pilnas!");
        } else this.courts.get(numCourts - 1).addPlayer(player); // pridedame naują žaidėją esamame korte

    }

}

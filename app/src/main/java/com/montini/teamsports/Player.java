package com.montini.teamsports;

public class Player {
    int id;
    private String name;
    Boolean inATeam = false;

    public Player(String name) {
        this.name = name;
        id = MainActivity.numPlayers;
        MainActivity.numPlayers++;
        MainActivity.numFreeAgents++;
        System.out.print("Player " + getPlayerData() + " has appeared.");
        if (MainActivity.numPlayers % 4 == 0) System.out.println(" You can form a court of 4!");
        else if (MainActivity.numPlayers % 2 == 0) System.out.println(" You can form a court of 2!");
        else System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerData() {
        return "[" + id + ". " + name + "]";
    }

    public void showPlayerData() {
        System.out.println(getPlayerData());
    }
}

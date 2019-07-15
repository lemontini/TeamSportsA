package com.montini.teamsports;

import java.util.ArrayList;

public class Court {
    int id;
    int maxPlayers;
    int size;
    ArrayList<Player> court;

    public Court(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.court = new ArrayList<Player>();

        // id = Main.numCourts; // id = UUID.randomUUID().toString();
        id++;
        System.out.println("Court " + id + " was created.");
    }

    public Court(int maxPlayers, Player... players) {
        this.maxPlayers = maxPlayers;
        this.court = new ArrayList<Player>();

        if (size + players.length <= maxPlayers) {
            for (int i = 0; i < players.length; i++) {
                court.add(players[i]);
                court.get(court.size() - 1).inATeam = true;
                MainActivity.numFreeAgents--;
                size++;
            }
        }

        // id = Main.numCourts; // id = UUID.randomUUID().toString();
        id++;
        System.out.print("Court " + id + " was created with players " + getPlayers() + "\n");
    }

    public void addPlayer(Player player) {
        if (court != null) {
            if (size < maxPlayers) {
                court.add(player);
                court.get(court.size() - 1).inATeam = true;
                MainActivity.numFreeAgents--;
                System.out.print("Player " + player.getPlayerData() + " was assigned to the Court " + id + ". ");
                size++;
                // Main.numPlayers++;
                showPlayers();
                if (size == maxPlayers) System.out.println("You can book a court!");
            } else {
                System.out.println("Player " + player.getPlayerData() + "is over the maximum allowed players number (" + maxPlayers + "). Player will not be saved.");
            }
        }
    }

    // TODO: remove player from the Court and make him a free agent
    // public void removePlayer(Player player) {
    //     if (size > 0) {
    //         if (court.contains(player)) System.out.println("Rastas " + player.getName());
    //     }
    // }

    public String getPlayers() {
        String players = "";
        for (Player i : court) {
            players += "[" + i.id + ". " + i.getName() + "] ";
        }
        return players;
    }

    public void showPlayers() {
        System.out.print("Court " + id + " players: ");
        System.out.print(getPlayers());
        System.out.println();
    }

}

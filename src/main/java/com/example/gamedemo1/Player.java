package com.example.gamedemo1;

import java.util.ArrayList;

public class Player {
    String name;
    double score;
    public ArrayList<String> playerInventory = new ArrayList<>();

    Player(String name, double score) {
        this.name = name;
        this.score = score;
    }
}

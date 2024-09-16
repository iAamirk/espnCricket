package com.espn.cricket.dto;

import lombok.Data;

@Data
public class PlayerRequest {

    private String name;
    private String team;
    private int matchesPlayed;
    private int runsScored;
    private int wicketsTaken;
}

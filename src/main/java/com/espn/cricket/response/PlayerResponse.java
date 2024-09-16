package com.espn.cricket.response;

import lombok.Data;

@Data
public class PlayerResponse {

    private Long id;
    private String name;
    private String team;
    private int matchesPlayed;
    private int runsScored;
    private int wicketsTaken;
}

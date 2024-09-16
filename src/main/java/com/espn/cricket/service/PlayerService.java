package com.espn.cricket.service;

import com.espn.cricket.dto.PlayerRequest;
import com.espn.cricket.model.Player;
import com.espn.cricket.response.PlayerResponse;

import java.util.List;

public interface PlayerService {

    List<PlayerResponse> getAllPlayers();

    PlayerResponse getPlayerById(Long id);

    PlayerResponse createPlayer(PlayerRequest playerRequest);

    PlayerResponse updatePlayer(Long id, PlayerRequest playerRequest);

    void deletePlayer(Long id);
}

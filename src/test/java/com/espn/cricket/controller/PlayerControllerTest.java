package com.espn.cricket.controller;

import com.espn.cricket.dto.PlayerRequest;
import com.espn.cricket.model.Player;
import com.espn.cricket.response.PlayerResponse;
import com.espn.cricket.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlayerControllerTest {

    @Mock
    PlayerService playerService;

    @InjectMocks
    PlayerController playerController;

    @Test
    void createPlayer() {
        PlayerRequest playerRequest = createPlayerRequest();
        PlayerResponse playerResponse = createPlayerResponse();
        when(playerService.createPlayer(any(PlayerRequest.class))).thenReturn(playerResponse);
        PlayerResponse actualResponse = playerController.createPlayer(playerRequest);
        assertEquals(playerResponse.getName(), actualResponse.getName());
    }

    //We can always create request and expected response files and read it via files

    private PlayerResponse createPlayerResponse() {
        Player playerResponse = new Player();
        playerResponse.setId(1L);
        playerResponse.setName("V Kohli");
        playerResponse.setTeam("India");
        playerResponse.setMatchesPlayed(100);
        playerResponse.setRunsScored(1000);
        playerResponse.setWicketsTaken(10);
        return convertToResponse(playerResponse);
    }

    private PlayerResponse convertToResponse(Player player) {
        PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setTeam(player.getTeam());
        response.setMatchesPlayed(player.getMatchesPlayed());
        response.setRunsScored(player.getRunsScored());
        response.setWicketsTaken(player.getWicketsTaken());
        return response;
    }

    PlayerRequest createPlayerRequest() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setName("V Kohli");
        playerRequest.setTeam("India");
        playerRequest.setMatchesPlayed(100);
        playerRequest.setRunsScored(1000);
        playerRequest.setWicketsTaken(10);
        return playerRequest;
    }
}

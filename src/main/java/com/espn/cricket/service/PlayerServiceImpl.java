package com.espn.cricket.service;

import com.espn.cricket.dto.PlayerRequest;
import com.espn.cricket.exception.PlayerNotFoundException;
import com.espn.cricket.model.Player;
import com.espn.cricket.repository.PlayerRepository;
import com.espn.cricket.response.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerResponse> getAllPlayers() {
        return playerRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    public PlayerResponse getPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        return convertToResponse(player);
    }

    public PlayerResponse createPlayer(PlayerRequest playerRequest) {
        Player player = new Player();
        player.setName(playerRequest.getName());
        player.setTeam(playerRequest.getTeam());
        player.setMatchesPlayed(playerRequest.getMatchesPlayed());
        player.setRunsScored(playerRequest.getRunsScored());
        player.setWicketsTaken(playerRequest.getWicketsTaken());
        Player savedPlayer = playerRepository.save(player);
        return convertToResponse(savedPlayer);
    }

    public PlayerResponse updatePlayer(Long id, PlayerRequest playerRequest) {

        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        player.setName(playerRequest.getName());
        player.setTeam(playerRequest.getTeam());
        player.setMatchesPlayed(playerRequest.getMatchesPlayed());
        player.setRunsScored(playerRequest.getRunsScored());
        player.setWicketsTaken(playerRequest.getWicketsTaken());
        Player updatedPlayer = playerRepository.save(player);
        return convertToResponse(updatedPlayer);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
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
}

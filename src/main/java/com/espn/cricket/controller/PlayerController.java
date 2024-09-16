package com.espn.cricket.controller;

import com.espn.cricket.dto.PlayerRequest;
import com.espn.cricket.response.PlayerResponse;
import com.espn.cricket.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@Validated
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerResponse> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public PlayerResponse createPlayer(@RequestBody @Valid PlayerRequest playerRequest) {
        return playerService.createPlayer(playerRequest);
    }

    @PutMapping("/{id}")
    public PlayerResponse updatePlayer(@PathVariable Long id, @RequestBody PlayerRequest playerRequest) {
        return playerService.updatePlayer(id, playerRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}

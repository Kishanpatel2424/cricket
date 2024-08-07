package com.patel.sports.cricket.service.impl;

import com.patel.sports.cricket.entity.Player;
import com.patel.sports.cricket.repo.PlayerRepository;
import com.patel.sports.cricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlayerService")
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> save(List<Player> players) {
        return playerRepository.saveAll(players);
    }
}

package com.patel.sports.cricket.service;

import com.patel.sports.cricket.entity.Player;

import java.util.List;

public interface PlayerService {
    Player getPlayerById(Long playerId);
    Player save(Player player);
    List<Player> save(List<Player> p);


}

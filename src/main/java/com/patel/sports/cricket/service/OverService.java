package com.patel.sports.cricket.service;

import com.patel.sports.cricket.entity.Ball;
import com.patel.sports.cricket.entity.Over;
import com.patel.sports.cricket.entity.Player;

import java.util.List;

public interface OverService {
    Over createOver(Player bowler, Long matchId);
    Over addBallToOver(Long overId, Ball ball);
    List<Over> getOversByPlayer(Long playerId);
}

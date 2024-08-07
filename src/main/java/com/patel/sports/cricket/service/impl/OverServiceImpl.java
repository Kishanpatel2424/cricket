package com.patel.sports.cricket.service.impl;

import com.patel.sports.cricket.entity.Ball;
import com.patel.sports.cricket.entity.Match;
import com.patel.sports.cricket.entity.Over;
import com.patel.sports.cricket.entity.Player;
import com.patel.sports.cricket.repo.BallRepository;
import com.patel.sports.cricket.repo.MatchRepository;
import com.patel.sports.cricket.repo.OverRepository;
import com.patel.sports.cricket.repo.PlayerRepository;
import com.patel.sports.cricket.service.OverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverServiceImpl implements OverService {
    @Autowired
    private OverRepository overRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BallRepository ballRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Over createOver(Player bowler, Long matchId) {
        Match match = matchRepository.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found"));

        // Check the number of overs bowled by the player in this match
        long bowlerOvers = match.getOversList().stream()
                .filter(over -> over.getBowler().getId().equals(bowler.getId()))
                .count();

        // Determine max overs per player based on match overs
        int maxOversPerPlayer = (match.getOvers() == 8) ? 2 : 4;

        if (bowlerOvers >= maxOversPerPlayer) {
            throw new RuntimeException("Bowler has already bowled the maximum allowed overs");
        }

        Over over = new Over(bowler, match);
        return overRepository.save(over);
    }

    @Override
    public Over addBallToOver(Long overId, Ball ball) {
        Over over = overRepository.findById(overId).orElseThrow(() -> new RuntimeException("Over not found"));
        over.addBall(ball);
        ballRepository.save(ball);
        return overRepository.save(over);
    }

    @Override
    public List<Over> getOversByPlayer(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
        return player.getOvers();
    }
}

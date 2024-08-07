package com.patel.sports.cricket.service.impl;

import com.patel.sports.cricket.entity.Match;
import com.patel.sports.cricket.entity.Player;
import com.patel.sports.cricket.entity.Team;
import com.patel.sports.cricket.repo.MatchRepository;
import com.patel.sports.cricket.service.MatchService;
import com.patel.sports.cricket.service.PlayerService;
import com.patel.sports.cricket.service.TeamService;
import com.patel.sports.cricket.utils.PlayerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MatchService")
public class MatchServiceImpl implements MatchService {

    private static final Logger logger = LoggerFactory.getLogger(MatchServiceImpl.class);

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Override
    public Match createMatch(Match match) {
        match.setTeam1(prepareTeam(match.getTeam1()));
        match.setTeam2(prepareTeam(match.getTeam2()));
        return matchRepository.save(match);
    }

    private Team prepareTeam(Team team) {
        if (team.getId() == null) {
            List<Player> players = team.getPlayers();
            if (players == null || players.isEmpty()) {
                players = PlayerUtil.generateRandomNames(team.getPlayersCount());
                players = playerService.save(players);
                team.setPlayers(players);
            }
            return teamService.save(team);
        }
        return team;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.getMatchByIsActive(Boolean.TRUE);
    }

    @Override
    public Optional<Match> getMatch(int id) {
        return matchRepository.findById(Long.valueOf(id));
    }
}

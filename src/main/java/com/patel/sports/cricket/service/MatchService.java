package com.patel.sports.cricket.service;

import com.patel.sports.cricket.entity.Match;

import java.util.List;
import java.util.Optional;

public interface MatchService {
    Match createMatch(Match match);
    List<Match> getAllMatches();

    Optional<Match> getMatch(int id);
}

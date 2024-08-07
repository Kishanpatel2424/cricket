package com.patel.sports.cricket.controller;

import com.patel.sports.cricket.entity.Match;
import com.patel.sports.cricket.service.MatchService;
import com.patel.sports.cricket.service.impl.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable Long id) {
        return matchService.getMatch(Math.toIntExact(id));
    }
}

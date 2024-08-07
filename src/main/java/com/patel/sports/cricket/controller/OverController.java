package com.patel.sports.cricket.controller;

import com.patel.sports.cricket.entity.Ball;
import com.patel.sports.cricket.entity.Over;
import com.patel.sports.cricket.entity.Player;
import com.patel.sports.cricket.service.OverService;
import com.patel.sports.cricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/overs")
public class OverController {
    @Autowired
    private OverService overService;

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player/{playerId}")
    public Over createOver(@PathVariable Long playerId) {
        Player bowler = playerService.getPlayerById(playerId);
        return overService.createOver(bowler, 1L);
    }

    @PostMapping("/{overId}/ball")
    public Over addBallToOver(@PathVariable Long overId, @RequestBody Ball ball) {
        return overService.addBallToOver(overId, ball);
    }

    @GetMapping("/player/{playerId}")
    public List<Over> getOversByPlayer(@PathVariable Long playerId) {
        return overService.getOversByPlayer(playerId);
    }
}

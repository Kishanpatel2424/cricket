package com.patel.sports.cricket.entity;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Over {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player bowler;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @OneToMany(mappedBy = "over", cascade = CascadeType.ALL)
    private List<Ball> balls = new ArrayList<>();

    private int validBallCount;

    // Default constructor
    public Over() {}

    public Over(Player bowler, Match match) {
        this.bowler = bowler;
        this.match = match;
    }

    public void addBall(Ball ball) {
        ball.setOver(this);
        balls.add(ball);
        if (ball.isValid()) {
            validBallCount++;
        }
    }

    public boolean isComplete() {
        return validBallCount == 6;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public int getValidBallCount() {
        return validBallCount;
    }

    public void setValidBallCount(int validBallCount) {
        this.validBallCount = validBallCount;
    }
}

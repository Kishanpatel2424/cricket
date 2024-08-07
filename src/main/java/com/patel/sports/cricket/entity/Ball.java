package com.patel.sports.cricket.entity;

import jakarta.persistence.*;


@Entity
public class Ball {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isValid;

    @ManyToOne
    @JoinColumn(name = "over_id")
    private Over over;

    // Default constructor
    public Ball() {}

    // Constructor
    public Ball(boolean isValid) {
        this.isValid = isValid;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Over getOver() {
        return over;
    }

    public void setOver(Over over) {
        this.over = over;
    }
}

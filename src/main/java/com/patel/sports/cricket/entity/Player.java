package com.patel.sports.cricket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ColumnDefault("0")
    private int runs;
    @ColumnDefault("0")
    private int ballsFaced;
    @ColumnDefault("0")
    private int wicketsTaken;
    @OneToMany(mappedBy = "bowler", cascade = CascadeType.ALL)
    private List<Over> overs;

    public Player(String name) {
        this.name = name;
    }
}

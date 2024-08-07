package com.patel.sports.cricket.repo;

import com.patel.sports.cricket.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> getMatchByIsActive(Boolean isActive);

}

package com.patel.sports.cricket.repo;

import com.patel.sports.cricket.entity.Ball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallRepository extends JpaRepository<Ball, Long> {
}

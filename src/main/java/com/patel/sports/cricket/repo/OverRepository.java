package com.patel.sports.cricket.repo;

import com.patel.sports.cricket.entity.Over;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverRepository extends JpaRepository<Over, Long> {
}

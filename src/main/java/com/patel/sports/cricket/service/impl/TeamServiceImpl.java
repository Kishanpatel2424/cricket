package com.patel.sports.cricket.service.impl;

import com.patel.sports.cricket.entity.Team;
import com.patel.sports.cricket.repo.TeamRepository;
import com.patel.sports.cricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TeamService")
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }
}

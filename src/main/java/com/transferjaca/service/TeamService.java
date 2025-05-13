package com.transferjaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transferjaca.model.Team;
import com.transferjaca.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
    private TeamRepository teamRepository;


    public List<Team> findAll() {
        return teamRepository.findAll();
    }


    public Team findById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }


    public Team save(Team player) {
        return teamRepository.save(player);
    }


    public void deleteById(Long id) {
    	teamRepository.deleteById(id);
    }

}

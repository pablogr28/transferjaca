package com.transferjaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transferjaca.model.Match;
import com.transferjaca.model.Player;
import com.transferjaca.repository.MatchRepository;
import com.transferjaca.repository.PlayerRepository;



@Service
public class MatchService {
	
	 @Autowired
	    private MatchRepository matchRepository;


	    public List<Match> findAll() {
	        return matchRepository.findAll();
	    }


	    public Match findById(Long id) {
	        return matchRepository.findById(id).orElse(null);
	    }


	    public Match save(Match match) {
	        return matchRepository.save(match);
	    }


	    public void deleteById(Long id) {
	    	matchRepository.deleteById(id);
	    }

}

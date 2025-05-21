package com.transferjaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transferjaca.model.Tournament;
import com.transferjaca.repository.TournamentRepository;

@Service
public class TournamentService {
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
	public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }


    public Tournament findById(Long id) {
        return tournamentRepository.findById(id).orElse(null);
    }


    public Tournament save(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }


    public void deleteById(Long id) {
    	tournamentRepository.deleteById(id);
    }
    
    public List<Tournament> findByYear(Integer year){
    	return tournamentRepository.findByYear(year);
    }

}

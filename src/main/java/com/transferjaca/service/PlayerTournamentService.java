package com.transferjaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transferjaca.model.PlayerTournament;
import com.transferjaca.model.Tournament;
import com.transferjaca.repository.PlayerTournamentRepository;

@Service
public class PlayerTournamentService {
    @Autowired
    private PlayerTournamentRepository playerTournamentRepository;

    public List<PlayerTournament> findByTournamentId(Tournament id) {
        return playerTournamentRepository.findByTournament(id);
    }
}

package com.transferjaca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transferjaca.model.PlayerTournament;
import com.transferjaca.model.PlayerTournamentId;
import com.transferjaca.model.Tournament;

public interface PlayerTournamentRepository extends JpaRepository<PlayerTournament, PlayerTournamentId> {
    List<PlayerTournament> findByTournament(Tournament tournamentId);
}

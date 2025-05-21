package com.transferjaca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transferjaca.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
	
	List<Tournament> findByYear(Integer year);

}

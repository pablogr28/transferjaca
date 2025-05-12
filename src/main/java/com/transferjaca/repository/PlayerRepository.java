package com.transferjaca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transferjaca.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	
}

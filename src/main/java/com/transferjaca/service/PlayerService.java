package com.transferjaca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transferjaca.model.Player;
import com.transferjaca.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public List<Player> findAll() {
        return playerRepository.findAll();
    }


    public Player findById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }


    public Player save(Player player) {
        return playerRepository.save(player);
    }


    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}


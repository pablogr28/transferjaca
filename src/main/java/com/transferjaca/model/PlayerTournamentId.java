package com.transferjaca.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class PlayerTournamentId implements Serializable{
	
	@Column(name="jugador_id")
	private Long player;
	
	@Column(name="torneo_id")
    private Long tournament;

    public PlayerTournamentId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerTournamentId)) return false;
        PlayerTournamentId that = (PlayerTournamentId) o;
        return Objects.equals(player, that.player) &&
               Objects.equals(tournament, that.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournament, tournament);
    }

}

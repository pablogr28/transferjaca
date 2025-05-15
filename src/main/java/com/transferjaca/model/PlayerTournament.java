package com.transferjaca.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores_torneos")
@IdClass(PlayerTournamentId.class)
public class PlayerTournament {

	@Id
    @ManyToOne
    @JoinColumn(name = "jugador_id")
    @MapsId("player")
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "torneo_id")
    @MapsId("tournament")
    private Tournament tournament;


    @Column(name="goles")
    private Integer goals;
    
    @Column(name="asistencias")
    private Integer asistences;
    
    @Column(name="partidos_jugados")
    private Integer matchPlayed;

    public PlayerTournament() {}

	public PlayerTournament(Player player, Tournament tournament, Integer goals, Integer asistences,
			Integer matchPlayed) {
		super();
		this.player = player;
		this.tournament = tournament;
		this.goals = goals;
		this.asistences = asistences;
		this.matchPlayed = matchPlayed;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	public Integer getAsistences() {
		return asistences;
	}

	public void setAsistences(Integer asistences) {
		this.asistences = asistences;
	}

	public Integer getMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed(Integer matchPlayed) {
		this.matchPlayed = matchPlayed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asistences, goals, matchPlayed, player, tournament);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerTournament other = (PlayerTournament) obj;
		return Objects.equals(asistences, other.asistences) && Objects.equals(goals, other.goals)
				&& Objects.equals(matchPlayed, other.matchPlayed) && Objects.equals(player, other.player)
				&& Objects.equals(tournament, other.tournament);
	}

    
}

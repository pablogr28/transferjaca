package com.transferjaca.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Team {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="pais")
	private String country;
	
	@Column(name="anio_fundacion")
	private String yearFundation;
	
	@OneToMany(mappedBy="team")
	private List<Player> players;

	public Team(Long id, String name, String country, String yearFundation) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.yearFundation = yearFundation;
	}

	public Team() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getYearFundation() {
		return yearFundation;
	}

	public void setYearFundation(String yearFundation) {
		this.yearFundation = yearFundation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, id, name, yearFundation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(country, other.country) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(yearFundation, other.yearFundation);
	}
	
	
	
	

}

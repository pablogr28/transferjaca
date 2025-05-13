package com.transferjaca.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "jugadores")
public class Player {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[^\\d]+$", message = "El nombre no debe contener números")
    @Column(name = "nombre_completo")
    private String name;

    @NotBlank(message = "La posición es obligatoria")
    @Pattern(
        regexp = "^(Defensa|Centrocampista|Delantero|Portero)$",
        message = "La posición debe ser Defensa, Centrocampista, Delantero o Portero"
    )
    @Column(name = "posicion")
    private String position;

    @Column(name = "activo")
    private boolean active;

    @Min(value = 15, message = "La edad mínima es de 15 años")
    @NotNull(message = "La edad es obligatoria")
    @Column(name = "edad")
    private Integer age;

    @DecimalMin(value = "0.0", inclusive = false, message = "La estatura debe ser mayor a 0")
    @NotNull(message = "La estatura es obligatoria")
    @Column(name = "estatura")
    private Double stature;

    @Positive(message = "El valor de mercado debe ser positivo")
    @NotNull(message = "El valor de mercado es obligatorio")
    @Column(name = "valor_mercado")
    private Double marketValue;

    @NotBlank(message = "La pierna fuerte es obligatoria")
    @Column(name = "pierna_fuerte")
    private String footFavourite;
    
    @ManyToOne
    @JoinColumn(name="equipo_id")
    private Team team;

	public Player(Long id, String name, String position, boolean active, int age, double stature, double marketValue,
			String footFavourite) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.active = active;
		this.age = age;
		this.stature = stature;
		this.marketValue = marketValue;
		this.footFavourite = footFavourite;
	}

	public Player() {
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getStature() {
		return stature;
	}

	public void setStature(Double stature) {
		this.stature = stature;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}

	public String getFootFavourite() {
		return footFavourite;
	}

	public void setFootFavourite(String footFavourite) {
		this.footFavourite = footFavourite;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, age, footFavourite, id, marketValue, name, position, stature);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return active == other.active && age == other.age && Objects.equals(footFavourite, other.footFavourite)
				&& Objects.equals(id, other.id)
				&& Double.doubleToLongBits(marketValue) == Double.doubleToLongBits(other.marketValue)
				&& Objects.equals(name, other.name) && Objects.equals(position, other.position)
				&& Double.doubleToLongBits(stature) == Double.doubleToLongBits(other.stature);
	}
    
    
	
    
    

}

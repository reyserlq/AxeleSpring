package pe.axele.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Entrenador")
public class Coach implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCoach;
	
	@Column(name="nombreEntrenador", length=60, nullable=false)	
	private String nameCoach;
	
	@Column(name="edadJugador", nullable=false)	
	private Integer ageCoach;
	
	@Column(name="valoracionJugador", nullable=false)	
	private Integer assessmentPlayer;
	
	@Column(name="paisJugador", length=60, nullable=false)	
	private String countryPlayer;
	
	@Column(name="habilidadJugador", nullable=false)	
	private Integer abilityPlayer;
	
	
	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Coach(int idPlayer, String namePlayer, Integer agePlayer, Integer assessmentPlayer, String countryPlayer,
			Integer abilityPlayer) {
		super();
		this.idPlayer = idPlayer;
		this.namePlayer = namePlayer;
		this.agePlayer = agePlayer;
		this.assessmentPlayer = assessmentPlayer;
		this.countryPlayer = countryPlayer;
		this.abilityPlayer = abilityPlayer;
	}


	public int getIdPlayer() {
		return idPlayer;
	}


	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}


	public String getNamePlayer() {
		return namePlayer;
	}


	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}


	public Integer getAgePlayer() {
		return agePlayer;
	}


	public void setAgePlayer(Integer agePlayer) {
		this.agePlayer = agePlayer;
	}


	public Integer getAssessmentPlayer() {
		return assessmentPlayer;
	}


	public void setAssessmentPlayer(Integer assessmentPlayer) {
		this.assessmentPlayer = assessmentPlayer;
	}


	public String getCountryPlayer() {
		return countryPlayer;
	}


	public void setCountryPlayer(String countryPlayer) {
		this.countryPlayer = countryPlayer;
	}


	public Integer getAbilityPlayer() {
		return abilityPlayer;
	}


	public void setAbilityPlayer(Integer abilityPlayer) {
		this.abilityPlayer = abilityPlayer;
	}
	
	
	
}
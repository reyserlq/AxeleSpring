package pe.axele.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Jugador")
public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlayer;
	
	@Column(name="nombreJugador", length=60, nullable=false)	
	private String namePlayer;
	
	@Column(name="edadJugador", nullable=false)	
	private Integer agePlayer;
	
	@Column(name="valoracionJugador", nullable=false)	
	private Integer assessmentPlayer;
	
	@Column(name="paisJugador", length=60, nullable=false)	
	private String countryPlayer;
	
	@Column(name="habilidadJugador", nullable=false)	
	private Integer abilityPlayer;
	
	@ManyToOne
	@JoinColumn (name="idPosition", nullable =false)
	private Position position;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int idPlayer, String namePlayer, Integer agePlayer, Integer assessmentPlayer, String countryPlayer,
			Integer abilityPlayer, Position position) {
		super();
		this.idPlayer = idPlayer;
		this.namePlayer = namePlayer;
		this.agePlayer = agePlayer;
		this.assessmentPlayer = assessmentPlayer;
		this.countryPlayer = countryPlayer;
		this.abilityPlayer = abilityPlayer;
		this.position = position;
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	
}
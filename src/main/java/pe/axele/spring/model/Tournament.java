package pe.axele.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Torneo")
public class Tournament implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTournament;
	
	@Column(name="nombreTorneo", length=60, nullable=false)	
	private String nameTournament;
	
	@Column(name="jugadoresTorneo", nullable=false)	
	private Integer playersTournament;
	
	@Column(name="valoracionTorneo", nullable=false)	
	private Integer assessmentTournament;
	
	@Temporal (TemporalType.DATE)
	@Column(name="fechaInicioTorneo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDateTournament;
	
	@Column(name="descripcionTorneo", length=60, nullable=false)	
	private String descriptionTournament;

	@ManyToOne
	@JoinColumn (name="idDueno", nullable =false)
	private Team team;

	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournament(int idTournament, String nameTournament, Integer playersTournament, Integer assessmentTournament,
			Date startDateTournament, String descriptionTournament, Team team) {
		super();
		this.idTournament = idTournament;
		this.nameTournament = nameTournament;
		this.playersTournament = playersTournament;
		this.assessmentTournament = assessmentTournament;
		this.startDateTournament = startDateTournament;
		this.descriptionTournament = descriptionTournament;
		this.team = team;
	}

	public int getIdTournament() {
		return idTournament;
	}

	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}

	public String getNameTournament() {
		return nameTournament;
	}

	public void setNameTournament(String nameTournament) {
		this.nameTournament = nameTournament;
	}

	public Integer getPlayersTournament() {
		return playersTournament;
	}

	public void setPlayersTournament(Integer playersTournament) {
		this.playersTournament = playersTournament;
	}

	public Integer getAssessmentTournament() {
		return assessmentTournament;
	}

	public void setAssessmentTournament(Integer assessmentTournament) {
		this.assessmentTournament = assessmentTournament;
	}

	public Date getStartDateTournament() {
		return startDateTournament;
	}

	public void setStartDateTournament(Date startDateTournament) {
		this.startDateTournament = startDateTournament;
	}

	public String getDescriptionTournament() {
		return descriptionTournament;
	}

	public void setDescriptionTournament(String descriptionTournament) {
		this.descriptionTournament = descriptionTournament;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	

}
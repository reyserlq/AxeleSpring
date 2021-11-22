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
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
	
	@Size(min=1, max = 30)
	@NotEmpty(message = "Debe ingresar un nombre*")
	@Column(name="nombreTorneo", length=30, nullable=false)	
	private String nameTournament;
	
	@Min(value=5, message="el valor minimo de participantes es 5")  
    @Max(value=30, message="el valor maximo de participantes es 30")  
	@NotEmpty(message = "Debe ingresar la cantidad de participantes*")
	@Column(name="participantesTorneo", nullable=false)	
	private Integer participantsTournament;
	
	@Min(value=20, message="el valor minimo de la valoracion es 40")  
    @Max(value=100, message="el valor maximo de la valoracion es 100")  
	@NotEmpty(message = "Debe ingresar la valoracion*")
	@Column(name="valoracionTorneo", nullable=false)	
	private Integer assessmentTournament;
	
	@NotNull(message = "Debe ingresar una fecha")
	@Future(message = "La fecha debe estar en el futuro")
	@Temporal (TemporalType.DATE)
	@Column(name="fechaInicioTorneo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDateTournament;
	
	@Size(min=1, max = 60)
	@NotEmpty(message = "Debe ingresar una descripcion*")
	@Column(name="descripcionTorneo", length=60, nullable=false)	
	private String descriptionTournament;

	@ManyToOne
	@JoinColumn (name="idTeam", nullable =false)
	private Team team;

	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournament(int idTournament,
			@Size(min = 1, max = 30) @NotEmpty(message = "Debe ingresar un nombre*") String nameTournament,
			@Min(value = 5, message = "el valor minimo de participantes es 5") @Max(value = 30, message = "el valor maximo de participantes es 30") @NotEmpty(message = "Debe ingresar la cantidad de participantes*") Integer participantsTournament,
			@Min(value = 20, message = "el valor minimo de la valoracion es 40") @Max(value = 100, message = "el valor maximo de la valoracion es 100") @NotEmpty(message = "Debe ingresar la valoracion*") Integer assessmentTournament,
			@NotNull(message = "Debe ingresar una fecha") @Future(message = "La fecha debe estar en el futuro") Date startDateTournament,
			@Size(min = 1, max = 60) @NotEmpty(message = "Debe ingresar una descripcion*") String descriptionTournament,
			Team team) {
		super();
		this.idTournament = idTournament;
		this.nameTournament = nameTournament;
		this.participantsTournament = participantsTournament;
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

	public Integer getParticipantsTournament() {
		return participantsTournament;
	}

	public void setParticipantsTournament(Integer participantsTournament) {
		this.participantsTournament = participantsTournament;
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
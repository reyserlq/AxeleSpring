package pe.axele.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Equipo")
public class Team implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTeam;
	
	@Size(min=1, max = 30)
	@NotEmpty(message = "Debe ingresar un nombre*")
	@Column(name="nombreEquipo", length=30, nullable=false)	
	private String nameTeam;
	
	@Size(min=1, max = 30)
	@NotEmpty(message = "Debe ingresar una alineacion*")
	@Column(name="alineacionEquipo",length=30, nullable=false)	
	private String alignmentTeam;

	@ManyToOne
	@JoinColumn (name="idCoach", nullable =false)
	private Coach coach;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int idTeam, @Size(min = 1, max = 30) @NotEmpty(message = "Debe ingresar un nombre*") String nameTeam,
			@Size(min = 1, max = 30) @NotEmpty(message = "Debe ingresar una alineacion*") String alignmentTeam,
			Coach coach) {
		super();
		this.idTeam = idTeam;
		this.nameTeam = nameTeam;
		this.alignmentTeam = alignmentTeam;
		this.coach = coach;
	}

	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	public String getAlignmentTeam() {
		return alignmentTeam;
	}

	public void setAlignmentTeam(String alignmentTeam) {
		this.alignmentTeam = alignmentTeam;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}
}
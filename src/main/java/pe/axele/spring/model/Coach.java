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
	
	@Column(name="edadEntrenador", nullable=false)	
	private Integer ageCoach;
	
	@Column(name="paisEntrenador", length=60, nullable=false)	
	private String countryCoach;

	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coach(int idCoach, String nameCoach, Integer ageCoach, String countryCoach) {
		super();
		this.idCoach = idCoach;
		this.nameCoach = nameCoach;
		this.ageCoach = ageCoach;
		this.countryCoach = countryCoach;
	}

	public int getIdCoach() {
		return idCoach;
	}

	public void setIdCoach(int idCoach) {
		this.idCoach = idCoach;
	}

	public String getNameCoach() {
		return nameCoach;
	}

	public void setNameCoach(String nameCoach) {
		this.nameCoach = nameCoach;
	}

	public Integer getAgeCoach() {
		return ageCoach;
	}

	public void setAgeCoach(Integer ageCoach) {
		this.ageCoach = ageCoach;
	}

	public String getCountryCoach() {
		return countryCoach;
	}

	public void setCountryCoach(String countryCoach) {
		this.countryCoach = countryCoach;
	}
}
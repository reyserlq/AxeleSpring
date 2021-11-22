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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Entrenador")
public class Coach implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCoach;
	
	@Size(min=1, max = 30)
	@NotEmpty(message = "Debe ingresar el nombre*")
	@Column(name="nombreEntrenador", length=30, nullable=false)	
	private String nameCoach;
	
	@NotNull(message = "Debe ingresar una fecha")
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal (TemporalType.DATE)
	@Column(name="fechaNacimientoCoach")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthCoach;
	
	@Size(min=1, max = 30)
	@NotEmpty(message = "Debe ingresar el pais de origen*")
	@Column(name="paisEntrenador", length=30, nullable=false)	
	private String countryCoach;

	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coach(int idCoach, @Size(min = 1, max = 30) @NotEmpty(message = "Debe ingresar el nombre*") String nameCoach,
			@NotNull(message = "Debe ingresar una fecha") @Past(message = "La fecha debe estar en el pasado") Date birthCoach,
			@Size(min = 1, max = 30) @NotEmpty(message = "Debe ingresar el pais de origen*") String countryCoach) {
		super();
		this.idCoach = idCoach;
		this.nameCoach = nameCoach;
		this.birthCoach = birthCoach;
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

	public Date getBirthCoach() {
		return birthCoach;
	}

	public void setBirthCoach(Date birthCoach) {
		this.birthCoach = birthCoach;
	}

	public String getCountryCoach() {
		return countryCoach;
	}

	public void setCountryCoach(String countryCoach) {
		this.countryCoach = countryCoach;
	}
}
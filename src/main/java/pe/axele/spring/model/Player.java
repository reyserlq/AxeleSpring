package pe.axele.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Jugador")
public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlayer;
	
	@Size(min = 1, max = 60)
	@NotEmpty(message = "Debe ingresar el nombre*")
	@Column(name="nombreJugador", length=60, nullable=false)	
	private String namePlayer;
	
	@NotNull(message = "Debe ingresar una fecha")
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal (TemporalType.DATE)
	@Column(name="fechaNacimientoJugador")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthPlayer;
	
	@Min(value=20, message="el valor minimo de la valoracion es 20")  
    @Max(value=100, message="el valor maximo de la valoracion es 100")  
	@NotNull(message = "Debe ingresar la valoracion")
	@Column(name="valoracionJugador", nullable=false)	
	private Integer assessmentPlayer;
	
	@Size(min = 1, max = 30)
	@NotEmpty(message = "Debe ingresar el pais de origen*")
	@Column(name="paisJugador", length=30,nullable=false)	
	private String countryPlayer;
	
	@Min(value=20, message="el valor minimo de la habilidad es 20")  
    @Max(value=100, message="el valor maximo de la habilidad es 100")  
	@NotNull(message = "Debe ingresar la habilidad")
	@Column(name="habilidadJugador", nullable=false)	
	private Integer abilityPlayer;
	
	@ManyToOne
	@JoinColumn (name="idPosition", nullable =false)
	private Position position;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int idPlayer,
			@Size(min = 1, max = 60) @NotEmpty(message = "Debe ingresar el nombre*") String namePlayer,
			@NotNull(message = "Debe ingresar una fecha") @Past(message = "La fecha debe estar en el pasado") Date birthPlayer,
			@Min(value = 20, message = "el valor minimo de la valoracion es 20") @Max(value = 100, message = "el valor maximo de la valoracion es 100") @NotNull(message = "Debe ingresar la valoracion") Integer assessmentPlayer,
			@Size(min = 1, max = 30) @NotEmpty(message = "Debe ingresar el pais de origen*") String countryPlayer,
			@Min(value = 20, message = "el valor minimo de la habilidad es 20") @Max(value = 100, message = "el valor maximo de la habilidad es 100") @NotNull(message = "Debe ingresar la habilidad") Integer abilityPlayer,
			Position position) {
		super();
		this.idPlayer = idPlayer;
		this.namePlayer = namePlayer;
		this.birthPlayer = birthPlayer;
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

	public Date getBirthPlayer() {
		return birthPlayer;
	}

	public void setBirthPlayer(Date birthPlayer) {
		this.birthPlayer = birthPlayer;
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
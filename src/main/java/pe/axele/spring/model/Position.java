package pe.axele.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Posicion")
public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPosition;
	
	@Column(name="nombrePosicion", length=60, nullable=false)	
	private String namePosition;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(int idPosition, String namePosition) {
		super();
		this.idPosition = idPosition;
		this.namePosition = namePosition;
	}

	public int getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	public String getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}
}
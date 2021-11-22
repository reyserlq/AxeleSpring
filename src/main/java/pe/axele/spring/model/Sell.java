package pe.axele.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Venta")
public class Sell implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSell;
	
	@Min(value=1, message="el precio debe ser mayor de cero")  
	@NotEmpty(message = "Debe ingresar un precio de venta*")
	@Column(name="precioVenta", nullable=false)	
	private Integer priceSell;
	
	@Size(min=1, max = 30)
	@NotEmpty(message = "Debe ingresar un estado de venta*")
	@Column(name="estadoVenta", length=30, nullable=false)	
	private String stateSell;
	
	@ManyToOne
	@JoinColumn (name="idPlayer", nullable =false)
	private Player player;

	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sell(int idSell,
			@Min(value = 1, message = "el precio debe ser mayor de cero") @NotEmpty(message = "Debe ingresar un precio de venta*") Integer priceSell,
			@Size(min = 1, max = 30) @NotEmpty(message = "Debe ingresar un estado de venta*") String stateSell,
			Player player) {
		super();
		this.idSell = idSell;
		this.priceSell = priceSell;
		this.stateSell = stateSell;
		this.player = player;
	}

	public int getIdSell() {
		return idSell;
	}

	public void setIdSell(int idSell) {
		this.idSell = idSell;
	}

	public Integer getPriceSell() {
		return priceSell;
	}

	public void setPriceSell(Integer priceSell) {
		this.priceSell = priceSell;
	}

	public String getStateSell() {
		return stateSell;
	}

	public void setStateSell(String stateSell) {
		this.stateSell = stateSell;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
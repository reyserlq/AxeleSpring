package pe.axele.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Venta")
public class Sell implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSell;
		
	@Column(name="precioVenta", nullable=false)	
	private Integer priceSell;
	
	@Column(name="estadoVenta", length=60, nullable=false)	
	private String stateSell;

	@ManyToOne
	@JoinColumn (name="idPlayer", nullable =false)
	private Player player;

	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sell(int idSell, Integer priceSell, String stateSell, Player player) {
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
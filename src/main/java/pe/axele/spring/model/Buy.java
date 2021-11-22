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
@Table(name="Compra")
public class Buy implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBuy;
	
	@Column(name="precioCompra", nullable=false)	
	private Integer priceBuy;

	@ManyToOne
	@JoinColumn (name="idPlayer", nullable =false)
	private Player player;

	public Buy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buy(int idBuy, Integer priceBuy, Player player) {
		super();
		this.idBuy = idBuy;
		this.priceBuy = priceBuy;
		this.player = player;
	}

	public int getIdBuy() {
		return idBuy;
	}

	public void setIdBuy(int idBuy) {
		this.idBuy = idBuy;
	}

	public Integer getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(Integer priceBuy) {
		this.priceBuy = priceBuy;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
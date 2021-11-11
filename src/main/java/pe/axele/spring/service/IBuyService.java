package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.Buy;

public interface IBuyService {
	public boolean grabar(Buy buy);
	public void eliminar(int idBuy);
	public Optional<Buy> listarId(int idBuy);
	public List<Buy> listar();
	public List<Buy> buscarJugador(String namePlayer);	
}

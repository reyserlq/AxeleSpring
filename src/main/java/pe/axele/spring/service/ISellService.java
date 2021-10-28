package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.Sell;

public interface ISellService {
	public boolean grabar(Sell sell);
	public void eliminar(int idSell);
	public Optional<Sell> listarId(int idSell);
	public List<Sell> listar();
	public List<Sell> buscarEstado(String stateSell);	
}

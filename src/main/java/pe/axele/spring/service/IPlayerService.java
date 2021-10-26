package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.Player;

public interface IPlayerService {
	public boolean grabar(Player player);
	public void eliminar(int idPlayer);
	public Optional<Player> listarId(int idPlayer);
	public List<Player> listar();
	public List<Player> buscarNombre(String namePlayer);	
}

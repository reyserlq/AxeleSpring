package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.Player;
import pe.axele.spring.model.Tournament;

public interface ITournamentService {
	public boolean grabar(Tournament tournament);
	public void eliminar(int idTournament);
	public Optional<Tournament> listarId(int idTournament);
	public List<Tournament> listar();
	public List<Tournament> buscarNombre(String nameTournament);
}

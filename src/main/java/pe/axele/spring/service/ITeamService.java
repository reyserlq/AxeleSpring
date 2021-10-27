package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.Team;

public interface ITeamService {
	public boolean grabar(Team team);
	public void eliminar(int idTeam);
	public Optional<Team> listarId(int idTeam);
	public List<Team> listar();
	public List<Team> buscarNombre(String nameTeam);	
}

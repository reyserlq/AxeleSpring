package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.Coach;

public interface ICoachService {
	public boolean grabar(Coach coach);
	public void eliminar(int idCoach);
	public Optional<Coach> listarId(int idCoach);
	public List<Coach> listar();
	public List<Coach> buscarNombre(String nameCoach);	
}

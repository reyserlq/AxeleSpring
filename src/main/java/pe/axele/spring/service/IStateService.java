package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.State;

public interface IStateService {
	public boolean grabar(State state);
	public void eliminar(int idState);
	public Optional<State> listarId(int idState);
	public List<State> listar();
}

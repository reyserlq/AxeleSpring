package pe.axele.spring.service;

import java.util.List;
import java.util.Optional;

import pe.axele.spring.model.Position;

public interface IPositionService {
	public boolean grabar(Position position);
	public void eliminar(int idPosition);
	public Optional<Position> listarId(int idPosition);
	public List<Position> listar();
}

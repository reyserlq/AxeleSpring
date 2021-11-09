package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.axele.spring.model.Position;
import pe.axele.spring.repository.IPositionRepository;
import pe.axele.spring.service.IPositionService;

@Service
public class PositionServiceImpl implements IPositionService {

	@Autowired
	private IPositionRepository dPosition;
	
	@Override
	@Transactional
	public boolean grabar(Position position) {
		Position objPosition = dPosition.save(position);
		if (objPosition == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idPosition) {
		dPosition.deleteById(idPosition);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Position> listarId(int idPosition) {
		return dPosition.findById(idPosition);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Position> listar() {
		return dPosition.findAll();
	}

}

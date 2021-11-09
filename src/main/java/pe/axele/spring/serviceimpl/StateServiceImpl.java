package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.axele.spring.model.State;
import pe.axele.spring.repository.IStateRepository;
import pe.axele.spring.service.IStateService;

@Service
public class StateServiceImpl implements IStateService {

	@Autowired
	private IStateRepository dState;
	
	@Override
	@Transactional
	public boolean grabar(State state) {
		State objState = dState.save(state);
		if (objState == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idState) {
		dState.deleteById(idState);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<State> listarId(int idState) {
		return dState.findById(idState);
	}

	@Override
	@Transactional(readOnly = true)
	public List<State> listar() {
		return dState.findAll();
	}

}

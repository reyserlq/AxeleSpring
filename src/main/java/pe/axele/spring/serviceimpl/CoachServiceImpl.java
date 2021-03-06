package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.axele.spring.model.Coach;
import pe.axele.spring.repository.ICoachRepository;
import pe.axele.spring.service.ICoachService;

@Service
public class CoachServiceImpl implements ICoachService {

	@Autowired
	private ICoachRepository dCoach;
	
	@Override
	@Transactional
	public Integer grabar(Coach coach) {
		int rpta = dCoach.buscarNombreCoach(coach.getNameCoach());
		if (rpta == 0) {
			dCoach.save(coach);
		}
		return rpta;
	}
	
	@Override
	@Transactional
	public void eliminar(int idCoach) {
		dCoach.deleteById(idCoach);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Coach> listarId(int idCoach) {
		return dCoach.findById(idCoach);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Coach> listar() {
		return dCoach.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Coach> buscarNombre(String nameCoach) {
		return dCoach.buscarNombre(nameCoach);
	}

}

package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.axele.spring.model.Team;
import pe.axele.spring.repository.ITeamRepository;
import pe.axele.spring.service.ITeamService;


@Service
public class TeamServiceImpl implements ITeamService {

	@Autowired
	private ITeamRepository dTeam;
	
	@Override
	@Transactional
	public boolean grabar(Team team) {
		Team objTeam = dTeam.save(team);
		if (objTeam == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idTeam) {
		dTeam.deleteById(idTeam);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Team> listarId(int idTeam) {
		return dTeam.findById(idTeam);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Team> listar() {
		return dTeam.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Team> buscarNombre(String nameTeam) {
		return dTeam.buscarNombre(nameTeam);
	}

}

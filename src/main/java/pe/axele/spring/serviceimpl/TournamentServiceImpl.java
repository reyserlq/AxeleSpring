package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.axele.spring.model.Tournament;
import pe.axele.spring.repository.ITournamentRepository;
import pe.axele.spring.service.ITournamentService;

@Service
public class TournamentServiceImpl implements ITournamentService {

	@Autowired
	private ITournamentRepository dTournament;
	
	@Override
	@Transactional
	public boolean grabar(Tournament tournament) {
		Tournament objTournament = dTournament.save(tournament);
		if (objTournament == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idTournament) {
		dTournament.deleteById(idTournament);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tournament> listarId(int idTournament) {
		return dTournament.findById(idTournament);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tournament> listar() {
		return dTournament.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tournament> buscarNombre(String nameTournament) {
		return dTournament.buscarNombre(nameTournament);
	}

}

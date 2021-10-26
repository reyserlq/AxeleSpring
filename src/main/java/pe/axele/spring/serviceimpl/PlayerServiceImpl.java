package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.axele.spring.model.Player;
import pe.axele.spring.repository.IPlayerRepository;
import pe.axele.spring.service.IPlayerService;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	private IPlayerRepository dPlayer;
	
	@Override
	@Transactional
	public boolean grabar(Player player) {
		Player objPlayer = dPlayer.save(player);
		if (objPlayer == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idPlayer) {
		dPlayer.deleteById(idPlayer);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Player> listarId(int idPlayer) {
		return dPlayer.findById(idPlayer);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Player> listar() {
		return dPlayer.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Player> buscarNombre(String namePlayer) {
		return dPlayer.buscarNombre(namePlayer);
	}

}

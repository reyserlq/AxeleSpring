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
	public Integer grabar(Player player) {
		int rpta = dPlayer.buscarNombrePlayer(player.getNamePlayer());
		if (rpta == 0) {
			dPlayer.save(player);
		}
		return rpta;
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

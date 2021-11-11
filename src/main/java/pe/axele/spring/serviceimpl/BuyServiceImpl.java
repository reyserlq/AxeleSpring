package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.axele.spring.model.Buy;
import pe.axele.spring.repository.IBuyRepository;
import pe.axele.spring.service.IBuyService;

@Service
public class BuyServiceImpl implements IBuyService {

	@Autowired
	private IBuyRepository dBuy;
	
	@Override
	@Transactional
	public boolean grabar(Buy buy) {
		Buy objBuy = dBuy.save(buy);
		if (objBuy == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idBuy) {
		dBuy.deleteById(idBuy);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Buy> listarId(int idBuy) {
		return dBuy.findById(idBuy);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Buy> listar() {
		return dBuy.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Buy> buscarJugador(String namePlayer) {
		return dBuy.buscarJugador(namePlayer);
	}

}

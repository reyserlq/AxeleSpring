package pe.axele.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.axele.spring.model.Sell;
import pe.axele.spring.repository.ISellRepository;
import pe.axele.spring.service.ISellService;

@Service
public class SellServiceImpl implements ISellService {

	@Autowired
	private ISellRepository dSell;
	
	@Override
	@Transactional
	public boolean grabar(Sell sell) {
		Sell objSell = dSell.save(sell);
		if (objSell == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idSell) {
		dSell.deleteById(idSell);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Sell> listarId(int idSell) {
		return dSell.findById(idSell);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sell> listar() {
		return dSell.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sell> buscarEstado(String stateSell) {
		return dSell.buscarNombre(stateSell);
	}

}

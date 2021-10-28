package pe.axele.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.axele.spring.model.Sell;
import pe.axele.spring.service.ISellService;

@Controller
@RequestMapping("/sell")
public class SellController {
	@Autowired
	private ISellService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/market")
	public String irPaginaMarket() {
		return "market";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoVentas(Map<String, Object> model) {
		model.put("listaVentas", pService.listar());
		return "listSell"; 
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("sell", new Sell());
		return "sell"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Sell objSell, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "sell";
		else {
			boolean flag = pService.grabar(objSell);
			if (flag)
				return "redirect:/sell/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/sell/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Sell> objSell = pService.listarId(id);
		if (objSell == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/sell/listar";
		}
		else {
			model.addAttribute("sell",objSell);
			return "sell";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaVentas", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaVentas", pService.listar());
		}
		return "listSell";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaVentas", pService.listar());
		return "listSell";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Sell sell ) 
	throws ParseException
	{
		pService.listarId(sell.getIdSell());
		return "listSell";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("sell", new Sell());
		return "buscarSell";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Sell sell ) 
	throws ParseException
	{
		List<Sell> listaVentas;
		sell.setStateSell(sell.getStateSell());
		listaVentas=pService.buscarEstado(sell.getStateSell());
		
		if(listaVentas.isEmpty())
		{
			model.put("mensaje", "no existen coincidencias");
		}
		model.put("listaVentas", listaVentas);
		return "buscarSell";
	}
	
}

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

import pe.axele.spring.model.Position;
import pe.axele.spring.model.Player;
import pe.axele.spring.service.IPlayerService;
import pe.axele.spring.service.IPositionService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private IPlayerService pService;
	
	@Autowired
	private IPositionService poService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoJugadores(Map<String, Object> model) {
		model.put("listaJugadores", pService.listar());
		return "listPlayer"; 
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaPosiciones", poService.listar());
		
		model.addAttribute("position", new Position());
		model.addAttribute("player", new Player());
		return "player"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Player objPlayer, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
		{
			model.addAttribute("listaPosiciones", poService.listar());
			return "player";
			
		}
		else {
			boolean flag = pService.grabar(objPlayer);
			if (flag)
				return "redirect:/player/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/player/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Player> objPlayer = pService.listarId(id);
		if (objPlayer == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/player/listar";
		}
		else {
			model.addAttribute("listaPosiciones", poService.listar());
			
			if(objPlayer.isPresent())
				objPlayer.ifPresent(o ->model.addAttribute("player", o));
			return "player";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaJugadores", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaJugadores", pService.listar());
		}
		return "listPlayer";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaJugadores", pService.listar());
		return "listPlayer";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Player player ) 
	throws ParseException
	{
		pService.listarId(player.getIdPlayer());
		return "listPlayer";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("player", new Player());
		return "buscarJugador";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Player player ) 
	throws ParseException
	{
		List<Player> listaJugadores;
		player.setNamePlayer(player.getNamePlayer());
		listaJugadores=pService.buscarNombre(player.getNamePlayer());
		
		if(listaJugadores.isEmpty())
		{
			model.put("mensaje", "no existen coincidencias");
		}
		model.put("listaJugadores", listaJugadores);
		return "buscarJugador";
	}
	
}

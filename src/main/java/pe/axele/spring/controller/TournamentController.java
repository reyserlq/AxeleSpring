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

import pe.axele.spring.model.Tournament;
import pe.axele.spring.service.ITournamentService;
import pe.axele.spring.model.Team;
import pe.axele.spring.service.ITeamService;

@Controller
@RequestMapping("/tournament")
public class TournamentController {
	
	@Autowired
	private ITournamentService pService;
	
	@Autowired
	private ITeamService tService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoTorneos(Map<String, Object> model) {
		model.put("listaTorneos", pService.listar());
		return "listTournament"; 
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaEquipos", tService.listar());
		
		model.addAttribute("team", new Team());
		model.addAttribute("tournament", new Tournament());
		return "tournament"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Tournament objTournament, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
		{
			model.addAttribute("listaEquipos", tService.listar());
			return "tournament";
		}
		else {
			boolean flag = pService.grabar(objTournament);
			if (flag)
				return "redirect:/tournament/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/tournament/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Tournament> objTournament = pService.listarId(id);
		if (objTournament == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/tournament/listar";
		}
		else {
			model.addAttribute("listaEquipos", tService.listar());
			
			if(objTournament.isPresent())
				objTournament.ifPresent(o ->model.addAttribute("tournament", o));
			return "team";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaTorneos", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTorneos", pService.listar());
		}
		return "listTournament";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaTorneos", pService.listar());
		return "listTournament";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Tournament tournament ) 
	throws ParseException
	{
		pService.listarId(tournament.getIdTournament());
		return "listTournament";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("tournament", new Tournament());
		return "buscarTorneo";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Tournament tournament ) 
	throws ParseException
	{
		List<Tournament> listaTorneos;
		tournament.setNameTournament(tournament.getNameTournament());
		listaTorneos=pService.buscarNombre(tournament.getNameTournament());
		
		if(listaTorneos.isEmpty())
		{
			model.put("mensaje", "no existen coincidencias");
		}
		model.put("listaTorneos", listaTorneos);
		return "buscarTorneo";
	}
	
	
}

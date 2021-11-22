package pe.axele.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.axele.spring.model.Team;
import pe.axele.spring.service.ITeamService;
import pe.axele.spring.model.Coach;
import pe.axele.spring.service.ICoachService;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private ITeamService pService;
	
	@Autowired
	private ICoachService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/nuevo")
	public String irPaginaTeam21() {
		return "nuevo";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEquipos(Map<String, Object> model) {
		model.put("listaEquipos", pService.listar());
		return "listTeam"; 
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaEntrenadores", cService.listar());
		
		model.addAttribute("coach", new Coach());
		model.addAttribute("team", new Team());
		
		return "team"; 
	}
	
	
	@PostMapping("/registrar")
	public String saveCategory(@Valid Team objTeam, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "team";
		} else {
			int rpta = pService.grabar(objTeam);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe equipo");
				return "team";
			} else { 
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listEquipos", pService.listar());

		return "team";
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Team> objTeam = pService.listarId(id);
		if (objTeam == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/team/listar";
		}
		else {
			
			model.addAttribute("listaEntrenadores", cService.listar());
				
			if(objTeam.isPresent())
				objTeam.ifPresent(o ->model.addAttribute("team", o));
			return "team";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaEquipos", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaEquipos", pService.listar());
		}
		return "listTeam";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaEquipos", pService.listar());
		return "listTeam";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Team team ) 
	throws ParseException
	{
		pService.listarId(team.getIdTeam());
		return "listTeam";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("team", new Team());
		return "buscarTeam";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Team team ) 
	throws ParseException
	{
		List<Team> listaEquipos;
		team.setNameTeam(team.getNameTeam());
		listaEquipos=pService.buscarNombre(team.getNameTeam());
		
		if(listaEquipos.isEmpty())
		{
			model.put("mensaje", "no existen coincidencias");
		}
		model.put("listaEquipos", listaEquipos);
		return "buscarTeam";
	}
	
}
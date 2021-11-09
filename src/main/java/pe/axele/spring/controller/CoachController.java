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

import pe.axele.spring.model.Coach;
import pe.axele.spring.service.ICoachService;

@Controller
@RequestMapping("/coach")
public class CoachController {
	@Autowired
	private ICoachService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEntrenadores(Map<String, Object> model) {
		model.put("listaEntrenadores", pService.listar());
		return "listCoach"; 
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("coach", new Coach());
		return "coach"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Coach objCoach, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "coach";
		else {
			boolean flag = pService.grabar(objCoach);
			if (flag)
				return "redirect:/coach/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/coach/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Coach> objCoach = pService.listarId(id);
		if (objCoach == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/coach/listar";
		}
		else {
			model.addAttribute("coach",objCoach);
			return "coach";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaEntrenadores", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaEntrenadores", pService.listar());
		}
		return "listCoach";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaEntrenadores", pService.listar());
		return "listCoach";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Coach coach ) 
	throws ParseException
	{
		pService.listarId(coach.getIdCoach());
		return "listCoach";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("coach", new Coach());
		return "buscarCoach";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Coach coach ) 
	throws ParseException
	{
		List<Coach> listaEntrenadores;
		coach.setNameCoach(coach.getNameCoach());
		listaEntrenadores=pService.buscarNombre(coach.getNameCoach());
		
		if(listaEntrenadores.isEmpty())
		{
			model.put("mensaje", "no existen coincidencias");
		}
		model.put("listaEntrenadores", listaEntrenadores);
		return "buscarCoach";
	}
}

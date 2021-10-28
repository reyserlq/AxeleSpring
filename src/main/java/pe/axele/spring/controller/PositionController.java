package pe.axele.spring.controller;

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
import pe.axele.spring.service.IPositionService;

@Controller
@RequestMapping("/position")
public class PositionController {
	@Autowired
	private IPositionService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoJugadores(Map<String, Object> model) {
		model.put("listaPosiciones", pService.listar());
		return "listPosition"; 
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("position", new Position());
		return "position"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Position objPosition, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "position";
		else {
			boolean flag = pService.grabar(objPosition);
			if (flag)
				return "redirect:/position/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/position/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Position> objPosition = pService.listarId(id);
		if (objPosition == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/position/listar";
		}
		else {
			model.addAttribute("position",objPosition);
			return "position";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaPosiciones", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPosiciones", pService.listar());
		}
		return "listPosition";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaPosiciones", pService.listar());
		return "listPosition";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Position position ) 
	throws ParseException
	{
		pService.listarId(position.getIdPosition());
		return "listPosition";
	}
		
}

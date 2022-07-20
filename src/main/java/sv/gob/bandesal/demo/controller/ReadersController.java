package sv.gob.bandesal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sv.gob.bandesal.demo.model.Readers;
import sv.gob.bandesal.demo.service.ReadersService;

@Controller
public class ReadersController {
	
	@Autowired
	private ReadersService service;
	
	@GetMapping({"/app/readers"})
	public String lstReader(Model modelo) {
		modelo.addAttribute("readers", service.findAll());
		return "readers";
	}
	
	@GetMapping("/app/readers/nuevo")
	public String showNewReader(Model modelo) {
		Readers reader = new Readers();
		modelo.addAttribute("reader", reader);
		return "new_reader";
	}
	
	@GetMapping("/app/readers/editar/{id}")
	public String showEditReader(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("reader", service.findById(id));
		return "edit_reader";
	}
	
	@PostMapping("/app/readers")
	public String saveReader(@ModelAttribute("reader") Readers reader) {
		service.saveReader(reader);
		return "redirect:/app/readers";
	}
	
	@PostMapping("/app/readers/{id}")
	public String updateReader(@PathVariable Integer id, @ModelAttribute("reader") Readers reader, Model modelo) {
		Readers readerOld = service.findById(id);
		readerOld.setName(reader.getName());
		
		service.saveReader(readerOld);
		return "redirect:/app/readers";
	}
	
	@GetMapping("/app/readers/{id}")
	public String deleteReader(@PathVariable(value = "id") Integer id) {
		service.deleteReader(id);
		return "redirect:/app/readers";
	}

}

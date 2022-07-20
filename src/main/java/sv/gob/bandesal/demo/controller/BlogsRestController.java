package sv.gob.bandesal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.gob.bandesal.demo.model.Blogs;
import sv.gob.bandesal.demo.service.BlogsService;

@RestController
@RequestMapping("/api")
public class BlogsRestController {
	@Autowired
	private BlogsService service;
	
	@GetMapping("/blogs")
	public List<Blogs> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/blogs/porTitulo/{title}")
	public List<Blogs> findByTitle(@PathVariable(name = "title") String title){
		return service.findLikeTitle(title);
	}
	
	@GetMapping("/blogs/{id}")
	public Blogs findById(@PathVariable(name = "id") Integer id){
		return service.findById(id);
	}

}

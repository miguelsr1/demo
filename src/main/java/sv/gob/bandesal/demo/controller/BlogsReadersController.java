package sv.gob.bandesal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sv.gob.bandesal.demo.model.Blogs;
import sv.gob.bandesal.demo.model.Readers;
import sv.gob.bandesal.demo.model.dto.BlogReaderDto;
import sv.gob.bandesal.demo.service.BlogsReadersService;
import sv.gob.bandesal.demo.service.BlogsService;
import sv.gob.bandesal.demo.service.ReadersService;

@Controller
public class BlogsReadersController {

	@Autowired
	private BlogsReadersService service;

	@Autowired
	private BlogsService bService;
	
	@Autowired
	private ReadersService rService;
	
	@GetMapping("/app/blogsReaders")
	public String lstReadersBlogs(Model modelo) {
		modelo.addAttribute("lst", service.findReadersBlogs());
		return "blogs_readers";
	}


	@GetMapping("/app/blogsReaders/nuevo")
	public String showNewBlog(Model modelo) {
		BlogReaderDto blog = new BlogReaderDto();
		modelo.addAttribute("brDto", blog);
		return "new_blogs_readers";
	}
	
	@GetMapping("/")
	public String getBlogsList(Model model) {
		List<Blogs> options = bService.findAll();
		model.addAttribute("blogsList", options);
		
		return "/app/blogs_readers.html";
	}

	@ModelAttribute("allBlogs")
	public List<Blogs> populateBlogs() {
		List<Blogs> options = bService.findAll();
		return options;
	}
	
	@ModelAttribute("allReaders")
	public List<Readers> populateReaders() {
		List<Readers> options = rService.findAll();
		return options;
	}
	
	@PostMapping("/app/blogsReaders")
	public String saveBlogReader(@ModelAttribute("brDto") BlogReaderDto blogReader) {
		service.save(blogReader);
		return "redirect:/app/blogsReaders";
	}
	
	@GetMapping("/app/blogsReaders/{rId}/{bId}")
	public String deleteReaderBlog(@PathVariable(value = "rId") Integer rId, @PathVariable(value = "bId") Integer bId) {
		service.deleteReaderBlog(rId, bId);
		return "redirect:/app/blogs";
	}
}

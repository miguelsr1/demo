package sv.gob.bandesal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sv.gob.bandesal.demo.model.Blogs;
import sv.gob.bandesal.demo.service.BlogsService;

@Controller
public class BlogsController {

	@Autowired
	private BlogsService service;
	
	@GetMapping({"/app/blogs"})
	public String lstBlogs(Model modelo) {
		modelo.addAttribute("blogs", service.findAll());
		return "blogs";
	}
	
	@GetMapping("/app/blogs/nuevo")
	public String showNewBlog(Model modelo) {
		Blogs blog = new Blogs();
		modelo.addAttribute("blog", blog);
		return "new_blog";
	}
	
	@GetMapping("/app/blogs/editar/{id}")
	public String showEditBlog(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("blog", service.findById(id));
		return "edit_blog";
	}
	
	@PostMapping("/app/blogs")
	public String saveBlog(@ModelAttribute("blog") Blogs blog) {
		service.saveBlog(blog);
		return "redirect:/app/blogs";
	}
	
	@PostMapping("/app/blogs/{id}")
	public String updateBlog(@PathVariable Integer id, @ModelAttribute("blog") Blogs blog, Model modelo) {
		Blogs blogOld = service.findById(id);
		blogOld.setTitle(blog.getTitle());
		blogOld.setDescription(blog.getDescription());
		
		service.saveBlog(blogOld);
		return "redirect:/app/blogs";
	}
	
	@GetMapping("/app/blogs/{id}")
	public String deleteBlog(@PathVariable(value = "id") Integer id) {
		service.deleteBlog(id);
		return "redirect:/app/blogs";
	}
}

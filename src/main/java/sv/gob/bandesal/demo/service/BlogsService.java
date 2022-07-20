package sv.gob.bandesal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.bandesal.demo.model.Blogs;
import sv.gob.bandesal.demo.repository.BlogsJpaRepository;

@Service
public class BlogsService {

	@Autowired
	private BlogsJpaRepository jpaRepository;
	
	public List<Blogs> findAll(){
		return jpaRepository.findAll();
	}
	
	public Blogs saveBlog(Blogs blog) {
		return jpaRepository.save(blog);
	}
	
	public Blogs findById(Integer id) {
		return jpaRepository.findById(id).get();
	}
	
	public void deleteBlog(Integer id) {
		jpaRepository.deleteById(id);
	}
	
	public List<Blogs> findLikeTitle(String title) {
		return jpaRepository.findLikeTitle(title);
	}
}

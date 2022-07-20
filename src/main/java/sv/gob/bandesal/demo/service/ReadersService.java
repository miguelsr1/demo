package sv.gob.bandesal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.bandesal.demo.model.Readers;
import sv.gob.bandesal.demo.repository.ReadersJpaRepository;

@Service
public class ReadersService {
	@Autowired
	private ReadersJpaRepository jpaRepository;
	
	public List<Readers> findAll(){
		return jpaRepository.findAll();
	}
	
	public Readers saveReader(Readers blog) {
		return jpaRepository.save(blog);
	}
	
	public Readers findById(Integer id) {
		return jpaRepository.findById(id).get();
	}
	
	public void deleteReader(Integer id) {
		jpaRepository.deleteById(id);
	}

}

package sv.gob.bandesal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.gob.bandesal.demo.model.BlogsReaders;
import sv.gob.bandesal.demo.model.dto.BlogReaderDto;
import sv.gob.bandesal.demo.model.dto.OnlyReaderBlog;
import sv.gob.bandesal.demo.repository.BlogsReadersJpaRepository;

@Service
public class BlogsReadersService {

	@Autowired
	private BlogsReadersJpaRepository jpaRepository;
	
	public BlogsReaders save(BlogReaderDto blogsReaders) {
		BlogsReaders br = new BlogsReaders();
		br.setbId(blogsReaders.getBlogId());
		br.setrId(blogsReaders.getReaderId());
		
		try {
			br = jpaRepository.save(br);
		}catch(Exception ex) {
			ex.fillInStackTrace();
		}
		
		return br;
	}

	public List<BlogsReaders> findAll(){
		return jpaRepository.findAll();
	}
	
	public List<OnlyReaderBlog> findReadersBlogs(){
		return jpaRepository.findFullReadersBlogs();
	}
	
	public void deleteReaderBlog(Integer rId, Integer bId) {
		BlogsReaders br = new BlogsReaders();
		br.setbId(bId);
		br.setrId(rId);
		jpaRepository.delete(br);
	}
}

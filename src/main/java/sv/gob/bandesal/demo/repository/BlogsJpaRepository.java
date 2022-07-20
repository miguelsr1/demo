package sv.gob.bandesal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sv.gob.bandesal.demo.model.Blogs;

public interface BlogsJpaRepository  extends JpaRepository<Blogs, Integer>{

	@Query("SELECT b FROM Blogs b WHERE b.title like %:title%")
	public List<Blogs> findLikeTitle(@Param("title") String title);
}

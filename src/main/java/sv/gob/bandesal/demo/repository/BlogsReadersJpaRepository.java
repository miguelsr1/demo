package sv.gob.bandesal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sv.gob.bandesal.demo.model.BlogsReaders;
import sv.gob.bandesal.demo.model.BlogsReadersId;
import sv.gob.bandesal.demo.model.dto.OnlyReaderBlog;

public interface BlogsReadersJpaRepository extends JpaRepository<BlogsReaders, BlogsReadersId> {

	@Query(value = "select r.name, b.title, r.id as reader, b.id as blog  from blogs_readers br inner join blogs b on br.b_id = b.id inner join readers r on br.r_id = r.id", nativeQuery = true)
	public List<OnlyReaderBlog> findFullReadersBlogs();

}

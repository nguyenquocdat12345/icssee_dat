package demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demo.domain.News;;

public interface NewsRepository extends CrudRepository<News, Integer>{

	List<News> findBynguoitaoContaining(String q);
}

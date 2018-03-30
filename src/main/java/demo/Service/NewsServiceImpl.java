package demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.News;
import demo.Repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public Iterable<News> findAll(){
		return newsRepository.findAll();
	}
	
	@Override
	public List<News> search(String q){
		return newsRepository.findBynguoitaoContaining(q);
	}
	
	@Override
	public News findOne (int id) {
		return newsRepository.findOne(id);
	}
	
	@Override
	public void save(News news) {
		newsRepository.save(news);
	}
	
	@Override
	public void delete(int id) {
		newsRepository.delete(id);
	}
}

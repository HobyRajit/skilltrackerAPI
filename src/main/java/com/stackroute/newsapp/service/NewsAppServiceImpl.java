package com.stackroute.newsapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newsapp.domain.News;
import com.stackroute.newsapp.exception.NewsAlreadyExistException;
import com.stackroute.newsapp.exception.NewsNotFoundException;
import com.stackroute.newsapp.repository.NewsRepository;

@Service
public class NewsAppServiceImpl implements NewsAppService{
	
	private NewsRepository newsRepository;
	
	@Autowired
	NewsAppServiceImpl(NewsRepository newsRepository){
		super();
		this.newsRepository = newsRepository;
	}
	

	
	public NewsRepository getNewsRepository() {
		return newsRepository;
	}
	public void setNewsRepository(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}
	
	@Override
	public boolean saveNews(News news) throws NewsAlreadyExistException{
		Optional<News> savedNews = newsRepository.findById(news.getId());
		if(savedNews.isPresent()) {
			throw new NewsAlreadyExistException("News is Already present in database");
		}
		newsRepository.save(news);
		
		return true;
	}
	
	@Override
	public News updateNews(News news) throws NewsNotFoundException{
		Optional<News> object = newsRepository.findById(news.getId());
		News updateNews = object.get();
		if(updateNews == null) {
			throw new NewsNotFoundException("News is not present in database");
		}
		updateNews.setContent(news.getContent());
		return newsRepository.save(updateNews);
	}
	
	
	@Override
	public boolean deleteNewsById(int  newsId) throws NewsNotFoundException{
		Optional<News> object = newsRepository.findById(newsId);
		News updateNews = object.get();
		if(updateNews == null) {
			throw new NewsNotFoundException("News is not present in database");
		}
		
		 newsRepository.delete(updateNews);
		 return true;
	}
	
	@Override
	public News getNewsById(int id) throws NewsNotFoundException{
		Optional<News> object = newsRepository.findById(id);
		News updateNews = object.get();
		if(updateNews == null) {
			throw new NewsNotFoundException("News is not present in database");
		}
		
		 
		 return updateNews;
	}
	
	
	@Override
	public List<News> getMyNews(String userId){
		List<News> news = newsRepository.findByUserId(userId);
		 return news;
	}
	
	
	
	/*News updateNews(News news)throws NewsNotFoundException;
	boolean deleteNews(News news)throws NewsNotFoundException;
	News getNewsById(int id) throws NewsNotFoundException;
	List<News> getAllNews() throws NewsNotFoundException*/;
}

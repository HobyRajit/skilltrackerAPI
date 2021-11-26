package com.stackroute.newsapp.service;

import java.util.List;

import com.stackroute.newsapp.domain.News;
import com.stackroute.newsapp.exception.NewsAlreadyExistException;
import com.stackroute.newsapp.exception.NewsNotFoundException;

public interface NewsAppService {
	boolean saveNews(News news) throws NewsAlreadyExistException;
	News updateNews(News news)throws NewsNotFoundException;
	boolean deleteNewsById(int id)throws NewsNotFoundException;
	News getNewsById(int id) throws NewsNotFoundException;
	List<News> getMyNews(String userId);

}

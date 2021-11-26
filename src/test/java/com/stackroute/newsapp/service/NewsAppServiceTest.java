package com.stackroute.newsapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.newsapp.domain.News;
import com.stackroute.newsapp.exception.NewsAlreadyExistException;
import com.stackroute.newsapp.exception.NewsNotFoundException;
import com.stackroute.newsapp.repository.NewsRepository;

public class NewsAppServiceTest {
	@Mock
	private transient NewsRepository newsRepository;
	private transient News news;
	@InjectMocks
	private transient NewsAppServiceImpl newsService;
	
	private Optional<News> options ;
	
	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
		news = new News(1,"sreeja","Ladies stepped into Sabarimala on January 2",
				"Hindu","Hoby","Ladies stepped into sabarimala","2019-01-01");
		options = Optional.of(news) ;
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull("The JPA repository created is null,Please create the jpaRepository",newsRepository);
	}
	
	@Test
	public void testSaveNewsSuccess() throws NewsAlreadyExistException {
		when(newsRepository.save(news)).thenReturn(news);
		final boolean flag = newsService.saveNews(news);
		assertTrue("The news is not saved properly,Please check that method",flag);
		verify(newsRepository,times(1)).save(news);
		verify(newsRepository,times(1)).findById(news.getId());
		
	}
	
	
	@Test(expected=NewsAlreadyExistException.class)
	public void testSaveNewsFailure() throws NewsAlreadyExistException {
		when(newsRepository.findById(1)).thenReturn(options);
		when(newsRepository.save(news)).thenReturn(news);
		final boolean flag = newsService.saveNews(news);
		assertFalse("Saving News didnot fail",flag);
		verify(newsRepository,times(1)).findById(news.getId());
		
	}
	
	@Test
	public void testUpdateNews() throws NewsNotFoundException{
		when(newsRepository.findById(1)).thenReturn(options);
		when(newsRepository.save(news)).thenReturn(news);
		news.setTitle("Sabarimala closed for purification");
		News updatedNews = newsService.updateNews(news);
		assertEquals(updatedNews.getTitle(),"Sabarimala closed for purification");
		verify(newsRepository,times(1)).findById(news.getId());
		verify(newsRepository,times(1)).save(news);
		
	}
	
	@Test
	public void testDeleteNews() throws NewsNotFoundException{
		when(newsRepository.findById(1)).thenReturn(options);
		doNothing().when(newsRepository).delete(news);
		boolean flag = newsService.deleteNewsById(news.getId());
		assertTrue("News delete failed",flag);
		verify(newsRepository,times(1)).findById(news.getId());
		verify(newsRepository,times(1)).delete(news);
		
	}
	
	@Test
	public void testGetNewsById() throws NewsNotFoundException{
		when(newsRepository.findById(1)).thenReturn(options);
		News fetchNews = newsService.getNewsById(news.getId());
		assertEquals("The fetched movie is not equal",fetchNews,news);
		verify(newsRepository,times(1)).findById(news.getId());
	}
	
	@Test
	public void testGetAllNews() throws NewsNotFoundException {
		final List<News> newsList = new ArrayList<>(1);
		newsList.add(news);
		when (newsRepository.findByUserId(news.getUserId())).thenReturn(newsList);
		List<News> fetchNewsList = newsService.getMyNews(news.getUserId());
		assertEquals("The fetched news List are not same",newsList,fetchNewsList);
		verify(newsRepository,times(1)).findByUserId(news.getUserId());
	}
	

}

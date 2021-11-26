package com.stackroute.newsapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.newsapp.domain.News;
import com.stackroute.newsapp.exception.NewsAlreadyExistException;
import com.stackroute.newsapp.exception.NewsNotFoundException;
import com.stackroute.newsapp.service.NewsAppService;

import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController

@RequestMapping (path="/api/v1/news")
public class NewsAppController  {
	
 NewsAppService newsAppService;

NewsAppController(NewsAppService newsAppService){
	this.newsAppService=newsAppService;
}

public NewsAppService getNewsAppService() {
	return newsAppService;
}

public void setNewsAppService(NewsAppService newsAppService) {
	this.newsAppService = newsAppService;
}

	
@PostMapping
ResponseEntity<?> saveNews(@RequestBody final News news,HttpServletRequest request,HttpServletResponse response){
	ResponseEntity<?> responseEntity;
	
System.out.println("Inside spring boot saveNews");
	try {
		 String authHeader = request.getHeader("authorization");
		 String token = authHeader.substring(7);
		 final String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		 System.out.println("Userid :: "+userId);
		news.setUserId(userId);
		 newsAppService.saveNews(news);
	}
	catch(NewsAlreadyExistException exception) {
		responseEntity = new ResponseEntity<String>( "{\"message :\""+"\""+exception.getMessage()+"\"}",HttpStatus.CONFLICT);
		return responseEntity;
	}
	
	responseEntity = new ResponseEntity<News>(news,HttpStatus.OK);
	
	return responseEntity;
}


@PutMapping(path= "/{id}")
ResponseEntity<?> updateNews(@PathVariable("id") final Integer id,@RequestBody final News news){
	ResponseEntity<?> responseEntity = null;
	News updateNews = null;
	try {
		updateNews = newsAppService.updateNews(news);
	}
	catch(NewsNotFoundException exception ) {
		responseEntity = new ResponseEntity<String>("{\"message:\"" +"\"" +exception.getMessage()+ "\"}",HttpStatus.CONFLICT);
		return responseEntity;
	}
	responseEntity = new ResponseEntity<News>(updateNews,HttpStatus.OK);
	return responseEntity;
}

@DeleteMapping(path="/{id}")
ResponseEntity<?> deleteNews(@PathVariable("id") final Integer id){
	
	ResponseEntity<String> responseEntity = null;
	System.out.println("Inside dele te of service "+id);
	try {
		newsAppService.deleteNewsById(id);	
	}
	catch(NewsNotFoundException exception) {
		responseEntity = new ResponseEntity<String >("{\"message:\"\""+exception.getMessage()+"\"}",HttpStatus.CONFLICT);
		return responseEntity;
	}
	responseEntity = new ResponseEntity<String>("The News with id "+id+" is deleted successfully",HttpStatus.OK);
	return responseEntity;
}

@GetMapping(path="/{id}")
ResponseEntity<?> getNewsById(@PathVariable final Integer id,@RequestBody final News news,HttpServletRequest request, HttpServletResponse response){

	ResponseEntity<?> responseEntity = null;
	News newsById = null;
	try {
		newsById = newsAppService.getNewsById(id);
	}
	catch(NewsNotFoundException exception) {
		
		responseEntity = new ResponseEntity<String >("{\"message:\"\""+exception.getMessage()+"\"}",HttpStatus.CONFLICT);
		return responseEntity;
	}
	responseEntity = new ResponseEntity<News>(newsById,HttpStatus.OK);
	return responseEntity;
}


@GetMapping
public  ResponseEntity<List<News>>getAllMovies(HttpServletRequest request,HttpServletResponse response){
	 String authHeader = request.getHeader("authorization");
	 String token = authHeader.substring(7);
	 final String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
	 System.out.println("Userid inside getMyNews :: "+userId);
	
		return new ResponseEntity<List<News>>(newsAppService.getMyNews(userId),HttpStatus.OK);
	
}


}



	

	


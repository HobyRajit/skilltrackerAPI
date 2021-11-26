package com.stackroute.newsapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlImage) {
		this.urlToImage = urlImage;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Column(name="content")
	private String content;
	
	@Column(name="news_source_id")
	private String sourceId;
	
	@Column(name="news_source_name")
	private String sourceName;
	
	@Column(name="news_author")
	private String author;
	
	@Column(name="news_title")
	private String title;
	
	@Column(name="news_description")
	private String description;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="news_url")
	private String url;
	
	@Column(name="news_url_image")
	private String urlToImage;
	
	@Column(name="news_publication_date")
	private String publicationDate;
	
	public News(String content,String newSourceName,String newsAuthor,String newsTitle,String newsPublicationDate) {
		super();
		this.content=content;
		this.sourceName=newSourceName;
		this.author=newsAuthor;
		this.title=newsTitle;
		this.publicationDate=newsPublicationDate;
		
		
	}
	
	
	public News(int id,String userId,String content,String newSourceName,String newsAuthor,String newsTitle,String newsPublicationDate) {
		super();
		this.id=id;
		this.userId = userId;
		this.content=content;
		this.sourceName=newSourceName;
		this.author=newsAuthor;
		this.title=newsTitle;
		this.publicationDate=newsPublicationDate;
		
		
	}
	public News() {
		super();
	}
	


}

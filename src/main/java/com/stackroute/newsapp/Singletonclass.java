package com.stackroute.newsapp;

import com.stackroute.newsapp.domain.News;

public class Singletonclass {
	
	private static Singletonclass news;
	
	public static Singletonclass instantiateNews() {
		if(news == null) {
			news = new Singletonclass();
		}
		return news;
	}

	
	public static void main(String args) {
		instantiateNews();
	}
}

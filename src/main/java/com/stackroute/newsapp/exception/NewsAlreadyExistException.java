package com.stackroute.newsapp.exception;

public class NewsAlreadyExistException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public NewsAlreadyExistException(String message) {
		super(message);
		this.message = message;
	}
	
	public String toString() {
		return ("NewsAlreadyExistsException [message :"+getMessage() +"]");
	}
	

}

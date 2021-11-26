package com.stackroute.newsapp.exception;

public class NewsNotFoundException extends Exception {
	
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public NewsNotFoundException(String message) {
		super(message);
		this.message=message;
		
	}
	
	public String toString() {
		return ("News Not Found Exception ="+ "[message :" +getMessage() + "]"); 
		
	}
	
	
	

}

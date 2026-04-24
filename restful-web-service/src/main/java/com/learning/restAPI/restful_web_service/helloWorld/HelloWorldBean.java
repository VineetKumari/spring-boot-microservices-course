package com.learning.restAPI.restful_web_service.helloWorld;

public class HelloWorldBean {
	private String message;

	 
	  public String getMessage() { return message; }
	 

	public HelloWorldBean(String string) {
		// TODO Auto-generated constructor stub
		this.message = string;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}

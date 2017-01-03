package com.arkhotech.calendar.service.app;

public class Response {
	
	public int code;
	
	public String message;
	
	public Response(){
		
	}
	
	public Response(int code,String message){
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

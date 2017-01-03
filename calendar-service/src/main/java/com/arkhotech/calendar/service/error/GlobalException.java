package com.arkhotech.calendar.service.error;

public abstract class GlobalException   extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int code;
	
	
	public GlobalException(int code , String message){
		super(message);
		this.code = code;
	}

	public int getCode(){
		return code;
	}
}

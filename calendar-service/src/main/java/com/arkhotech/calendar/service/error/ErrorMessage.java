package com.arkhotech.calendar.service.error;

/**
 * Modelo de datos para controladore de errores global
 * 
 * @author msilva
 *
 */
public class ErrorMessage {
	
	private int code;
	
	private String mensaje;
	
	public ErrorMessage(){
		
	}
	
	public ErrorMessage(int code, String mensaje){
		this.code = code;
		this.mensaje = mensaje;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}

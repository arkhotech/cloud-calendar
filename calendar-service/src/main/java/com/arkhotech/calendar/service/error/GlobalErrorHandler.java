package com.arkhotech.calendar.service.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arkhotech.calendar.service.app.ApplicationManager;

/**
 * Controlador de errores globales. Manejar en lo posible todos los errores con esta clase
 * a menos que existan errores muy especificos.
 * 
 * @author msilva
 *
 */
@ControllerAdvice
public class GlobalErrorHandler {

	private static final Logger log = LoggerFactory.getLogger(ApplicationManager.class);
	
	 @ExceptionHandler(NoDataFoundException.class)
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	 @ResponseBody
	 ErrorMessage handleException(NoDataFoundException e){
	        log.debug("Entity Not Found Exception {}",e.getMessage());
	        log.trace(e.getMessage(),e);
	        return new ErrorMessage(e.getCode(),e.getMessage());
	 }

	
	 @ExceptionHandler(Exception.class)
	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	 @ResponseBody
	 ErrorMessage handleException(Exception e){
	        log.debug("Entity Not Found Exception {}",e.getMessage());
	        log.trace(e.getMessage(),e);
	        return new ErrorMessage(500,e.getMessage());
	 }
	 
	 @ExceptionHandler({AppkeyNoFoundException.class})
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 @ResponseBody
	 ErrorMessage handleException(GlobalException e){
	        log.debug("Entity Not Found Exception {}",e.getMessage());
	        log.trace(e.getMessage(),e);
	        return new ErrorMessage(2,e.getMessage());
	 }
}

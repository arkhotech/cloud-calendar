package com.arkhotech.calendar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorHandler {

	private static final Logger log = LoggerFactory.getLogger(ApplicationManager.class);
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="No existen datos")
	@ExceptionHandler(NoDataFound.class)
	public void noDataFound(){
		log.info("Error controlado");
	}
	
}

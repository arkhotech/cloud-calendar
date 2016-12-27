package com.arkhotech.calendar.service;


import javax.ws.rs.HeaderParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationManager {

	@RequestMapping("/info")
	public String getInfo(){
		return "Prueba de información:  ";
	}
	
	@RequestMapping(value="/app",method=RequestMethod.GET)
	public Applications listApplications(@HeaderParam(value = "appkey")String appkey ){
		Applications apps = new Applications();
		apps.setResponse(new Response());
		apps.getResponse().setCode(1);
		apps.getResponse().setMessage("no esta habilitado aún");
		return apps;
	}
	
	
}

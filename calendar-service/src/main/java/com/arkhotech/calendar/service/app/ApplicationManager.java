package com.arkhotech.calendar.service.app;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arkhotech.calendar.service.app.dao.ApplicationData;
import com.arkhotech.calendar.service.app.dao.Apps;
import com.arkhotech.calendar.service.error.NoDataFoundException;

import org.springframework.web.bind.annotation.RequestHeader;

@Configuration
@RestController
public class ApplicationManager {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationManager.class);
	
	@Autowired
	private ApplicationData data;
	

	@RequestMapping("/info")
	public String getInfo(){
		return "Prueba de información:  ";
	}
	
	@RequestMapping(value="/app",method=RequestMethod.GET)
	public Applications listApplications(
			@RequestParam("appkey") String appkey,
			@RequestParam("domain")String domain ){  
		
		log.debug("Recibiendo Consulta");
		log.debug("appkey:" +appkey );
		Applications result = new Applications();
		List<Apps> apps = data.listarApps(appkey);
		result.setApps(apps);
		result.setResponse(new Response());
		result.getResponse().setCode(0);
		result.getResponse().setMessage("OK");
		return result;
	}
	
	@RequestMapping(value="/app",method=RequestMethod.POST)
	public Applications addApplications(Apps application,@RequestParam("appkey") String appkey){  //localhost:1111
		log.info("POST nueva aplicación");
		log.info(application.toString());
		Applications result = new Applications();
		data.addApplications(application,null);		
		result.setResponse(new Response());
		result.getResponse().setCode(0);
		result.getResponse().setMessage("OK");
		return result;
	}
	
	@RequestMapping(value="/app",method=RequestMethod.PUT)
	public Response updateApplication(@RequestHeader("appkey")String appkey,@RequestHeader("domain")String domain){
		log.info("appkey: " + appkey);
		log.info("domain: " + domain);
		return new Response(1,"No habiltado");
	}
	
	@RequestMapping(value="/app/changeStatus",method=RequestMethod.PUT)
	public Response changeApplicationStatus(@RequestHeader("appkey")String appkey,
						@RequestHeader("domain")String domain){
		log.info("appkey: " + appkey);
		log.info("domain: " + domain);
		throw new NoDataFoundException(500,"No se encontraron datos");
	}
	
}

package com.arkhotech.calendar.service;


import javax.ws.rs.HeaderParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class ApplicationManager {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationManager.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/info")
	public String getInfo(){
		return "Prueba de información:  ";
	}
	
	@RequestMapping(value="/app",method=RequestMethod.GET)
	public Applications listApplications(@HeaderParam(value = "appkey") String appkey ){  //localhost:1111
		log.debug("Recibiendo Consulta");
		log.debug("appkey:" +appkey );
		Applications result = new Applications();
		jdbcTemplate.query(
                "SELECT * FROM apps",
                (rs, rowNum) -> new Apps(
                		rs.getString("appkey"),
                		rs.getString("contact_email"),
                		rs.getString("domain"),
                		rs.getString("from_email"),
                		rs.getString("from_name"),
                		rs.getString("html_cancel_email"),
                		rs.getString("html_confirmation_email"),
                		rs.getString("html_modify_email"),
                		rs.getString("name"),
                		rs.getString("status"))).forEach(apps -> result.getApps().add(apps));
		
		result.setResponse(new Response());
		result.getResponse().setCode(0);
		result.getResponse().setMessage("OK");
		return result;
	}
	
	@RequestMapping(value="/app/{appkey}",method=RequestMethod.POST)
	public Applications addApplications(Apps application,@PathVariable(value="appkey") String appkey){  //localhost:1111
		log.info("POST nueva aplicación");
		log.info(application.toString());
		Applications result = new Applications();
	
		
		result.setResponse(new Response());
		result.getResponse().setCode(0);
		result.getResponse().setMessage("OK");
		return result;
	}
}

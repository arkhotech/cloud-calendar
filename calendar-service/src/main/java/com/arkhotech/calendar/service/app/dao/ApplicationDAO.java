package com.arkhotech.calendar.service.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.arkhotech.calendar.service.error.AppkeyNoFoundException;
import com.arkhotech.calendar.service.error.NoDataFoundException;


@Configuration
@Component
public class ApplicationDAO implements ApplicationData{

	private static final Logger log = LoggerFactory.getLogger(ApplicationDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Apps> listarApps(String appkey) throws NoDataFoundException {
		List<Apps> result = new ArrayList<Apps>();
		log.info("Ejecutando implementaciónde DAO");
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
	      		rs.getString("status"))).forEach(apps -> result.add(apps));
		log.info("Result: " + result.size());
		if(result.size()==0){
			throw new NoDataFoundException(1,"No se encontraron registros de aplicación");
		}
		return result;
	}

	@Override
	public void addApplications(Apps app, String appkey) {
		if(app == null || appkey == null){
			throw new AppkeyNoFoundException(3,"No se ha especificado el appkey");
		}
			
		
	}
	
}

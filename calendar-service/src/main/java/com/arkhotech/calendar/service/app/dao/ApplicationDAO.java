package com.arkhotech.calendar.service.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.arkhotech.calendar.service.error.NoDataFoundException;


@Configuration
@Component
@CacheConfig(cacheNames="apps")
@CacheEvict(cacheNames="apps", allEntries=true)
public class ApplicationDAO implements ApplicationData{

	private static final Logger log = LoggerFactory.getLogger(ApplicationDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Cacheable
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
	public void addApplications(Apps app) {
		
		
		jdbcTemplate.update("insert into apps (" +
				"appkey,contact_email,domain,from_email" +
		  		"from_name,html_cancel_email,html_confirmation_email"+
		  		"html_modify_email,name,status");
		
//		rs.setString("appkey",createAppkey()),
//  		rs.setString("contact_email"),
//  		rs.setString("domain"),
//  		rs.setString("from_email"),
//  		rs.setString("from_name"),
//  		rs.setString("html_cancel_email"),
//  		rs.setString("html_confirmation_email"),
//  		rs.setString("html_modify_email"),
//  		rs.setString("name"),
//  		rs.setString("status"))).forEach(apps -> result.add(apps));
	}
	
	private String createAppkey(){
		return "2F";
	}


	@Override
	public void addNewDomain(String appkey, Apps apps) throws NoDataFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateApplication(String appkey, String domain, Apps application) throws NoDataFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableApplication(String appkey, String domain) throws NoDataFoundException {
		// TODO Auto-generated method stub
		
	}
}

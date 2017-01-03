package com.arkhotech.calendar.service.app.dao;

import java.util.List;

import com.arkhotech.calendar.service.error.NoDataFoundException;

public interface ApplicationData {
	
	public List<Apps> listarApps(String appkey) throws NoDataFoundException;
	
	public void addApplications(Apps app, String appkey);
}

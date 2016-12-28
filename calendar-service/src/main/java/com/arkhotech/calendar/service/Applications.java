package com.arkhotech.calendar.service;

import java.util.ArrayList;
import java.util.List;

public class Applications {
	
	private Response response;
	
	private List<Apps> apps = new ArrayList<Apps>();

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public List<Apps> getApps() {
		return apps;
	}

	public void setApps(List<Apps> apps) {
		this.apps = apps;
	}
}

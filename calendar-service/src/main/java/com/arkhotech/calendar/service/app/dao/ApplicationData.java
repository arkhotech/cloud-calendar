package com.arkhotech.calendar.service.app.dao;

import java.util.List;

import com.arkhotech.calendar.service.error.NoDataFoundException;

public interface ApplicationData {
	
	public List<Apps> listarApps(String appkey) throws NoDataFoundException;
	
	/**
	 * CRea una nueva aplicación
	 * @param app datos de la nueva aplicación
	 */
	public void addApplications(Apps app);

	/**
	 * CRea un nuevo dominio para el mismo appkey
	 * 
	 * @param appkey Identificador de la aplicación
	 * @param apps Información del nuevo dominio
	 * @throws NoDataFoundException Si la aplicación especificada con el appkey no existe
	 */
	public void addNewDomain(String appkey, Apps apps) throws NoDataFoundException;
	/**
	 * Actualiza los datos de una aplicación que corresponda a las claves appkey + domain
	 * @param appkey Clave de aplicación
	 * @param domain Dominio de aplicación 
	 * @param application Datos de la aplicación
	 * @throws NoDataFoundException Si la aplicación especificada con el appkey no existe
	 */
	public void updateApplication(String appkey, String domain, Apps application) throws NoDataFoundException;
	/**
	 * Deshabilita una aplicación. Esta queda marcada 
	 * @param appkey Clave de la aplicación
	 * @param domain Dominio de la aplicación
	 * @throws NoDataFoundException
	 */
	public void disableApplication(String appkey, String domain)throws NoDataFoundException;
}

package com.arkhotech.calendar.service;

public class Apps {
    private String appkey;
	
	private String contact_email;
	
	public Apps(){
		
	}
	
	public Apps(String appkey, String contact_email, String domain, String from_email, String from_name,
			String html_cancel_email, String html_confirmation_email, String html_modify_email, String name,
			String status) {
		super();
		this.appkey = appkey;
		this.contact_email = contact_email;
		this.domain = domain;
		this.from_email = from_email;
		this.from_name = from_name;
		this.html_cancel_email = html_cancel_email;
		this.html_confirmation_email = html_confirmation_email;
		this.html_modify_email = html_modify_email;
		this.name = name;
		this.status = status;
	}
	private String domain;
	
	private String from_email;
	private String from_name;
	private String html_cancel_email;
	private String html_confirmation_email;
	private String html_modify_email;
	private String name;
	private String status;
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getFrom_email() {
		return from_email;
	}
	public void setFrom_email(String from_email) {
		this.from_email = from_email;
	}
	public String getFrom_name() {
		return from_name;
	}
	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}
	public String getHtml_cancel_email() {
		return html_cancel_email;
	}
	public void setHtml_cancel_email(String html_cancel_email) {
		this.html_cancel_email = html_cancel_email;
	}
	public String getHtml_confirmation_email() {
		return html_confirmation_email;
	}
	public void setHtml_confirmation_email(String html_confirmation_email) {
		this.html_confirmation_email = html_confirmation_email;
	}
	public String getHtml_modify_email() {
		return html_modify_email;
	}
	public void setHtml_modify_email(String html_modify_email) {
		this.html_modify_email = html_modify_email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString(){
		return this.appkey +" " + this.domain;
	}
}

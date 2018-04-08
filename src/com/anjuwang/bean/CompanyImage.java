package com.anjuwang.bean;

import java.util.List;

public class CompanyImage {
	private String com_id;
	private List<String> banner;
	private String logo;
	private String home_logo;
	private List<String> body;
	public CompanyImage() {
		super();
		// TODO Auto-generated constructor stub
		this.com_id = null;
		this.banner = null;
		this.logo = null;
		this.home_logo = null;
		this.body = null;
	}
	public CompanyImage(String com_id, List<String> banner, String logo, String home_logo, List<String> body) {
		super();
		this.com_id = com_id;
		this.banner = banner;
		this.logo = logo;
		this.home_logo = home_logo;
		this.body = body;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public List<String> getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner.add(banner);
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getHome_logo() {
		return home_logo;
	}
	public void setHome_logo(String home_logo) {
		this.home_logo = home_logo;
	}
	public List<String> getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body.add(body);
	}
}

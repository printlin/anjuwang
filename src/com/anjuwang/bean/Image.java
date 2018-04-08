package com.anjuwang.bean;

public class Image {
	private String img_id;
	private String url;
	private String com_id;
	private String type;
	
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(String img_id, String url, String com_id, String type) {
		super();
		this.img_id = img_id;
		this.url = url;
		this.com_id = com_id;
		this.type = type;
	}
	public String getImg_id() {
		return img_id;
	}
	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

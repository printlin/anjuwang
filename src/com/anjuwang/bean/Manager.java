package com.anjuwang.bean;

public class Manager {
	private String mag_id;
	private String com_id;
	private String username;
	private String password;
	private String loginCount;
	private String lastLoginTime;
	private String level;
	public Manager() {
		super();
	}
	public Manager(String mag_id, String com_id, String username, String password, String loginCount,
			String lastLoginTime, String level) {
		super();
		this.mag_id = mag_id;
		this.com_id = com_id;
		this.username = username;
		this.password = password;
		this.loginCount = loginCount;
		this.lastLoginTime = lastLoginTime;
		this.level = level;
	}
	public String getMag_id() {
		return mag_id;
	}
	public void setMag_id(String mag_id) {
		this.mag_id = mag_id;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}

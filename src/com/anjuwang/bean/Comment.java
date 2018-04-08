package com.anjuwang.bean;

public class Comment {
	private String cmt_id;//评论id
	private String ord_id;//订单id
	private String ow_id;//评论人id
	private String time;//评论时间
	private String comment;//内容
	private String grade;//等级（好中差）
	private String level;//设计水平
	private String attitude;//服务态度
	private String quality;//施工质量
	
	public String getCmt_id() {
		return cmt_id;
	}
	public void setCmt_id(String cmt_id) {
		this.cmt_id = cmt_id;
	}
	public String getOw_id() {
		return ow_id;
	}
	public void setOw_id(String ow_id) {
		this.ow_id = ow_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAttitude() {
		return attitude;
	}
	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
}

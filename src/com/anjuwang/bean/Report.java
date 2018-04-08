package com.anjuwang.bean;

public class Report {
	private String rep_id;//进度id
	private String ord_id;//订单id
	private String explain;//进度说明
	private String time;//发布时间
	
	public Report(String rep_id, String ord_id, String explain, String time) {
		super();
		this.rep_id = rep_id;
		this.ord_id = ord_id;
		this.explain = explain;
		this.time = time;
	}
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRep_id() {
		return rep_id;
	}
	public void setRep_id(String rep_id) {
		this.rep_id = rep_id;
	}
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}

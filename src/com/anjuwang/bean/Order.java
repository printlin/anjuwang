package com.anjuwang.bean;

public class Order {
	private String ord_id;//订单id
	private String ow_id;//业主id
	private String com_id;//公司id
	private String area;//装修面积
	private String address;//装修地址
	private String phone;//联系电话
	private String time;//订单受理时间
	private String state;//订单状态：audit为审核中，refuse为拒绝状态，accept为受理状态，acceptance为验收状态，termination为终止状态，request_acceptance为请求验收状态，request_termination为请求终止状态
	private String explain;//订单说明
	private String report;//进度
	private String reportTime;//进度发布时间
	private String surname;//称谓
	private String price;//价格
	private Comment comment;//评论信息对象
	private Owner owner;//业主信息对象
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String ord_id, String ow_id, String com_id, String area, String address, String phone, String time,
			String state, String explain,String report,String reportTime,String surname,String price, Comment comment,Owner owner) {
		super();
		this.ord_id = ord_id;
		this.ow_id = ow_id;
		this.com_id = com_id;
		this.area = area;
		this.address = address;
		this.phone = phone;
		this.time = time;
		this.state = state;
		this.explain = explain;
		this.report=report;
		this.reportTime=reportTime;
		this.comment = comment;
		this.owner=owner;
		this.surname=surname;
		this.price=price;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public String getOw_id() {
		return ow_id;
	}
	public void setOw_id(String ow_id) {
		this.ow_id = ow_id;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
}

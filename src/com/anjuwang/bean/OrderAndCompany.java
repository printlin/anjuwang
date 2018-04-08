package com.anjuwang.bean;

public class OrderAndCompany {
	private Order order;
	private Company company;
	
	public OrderAndCompany(Order order, Company company) {
		super();
		this.order = order;
		this.company = company;
	}
	public OrderAndCompany() {
		super();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}

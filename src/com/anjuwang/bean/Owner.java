package com.anjuwang.bean;

public class Owner {
	private String ow_id;//业主id
	private String phomenumber;//账号（电话号码）
	private String nickname;//
	private String head;//头像地址
	private String password;//密码
	private Order[] orders;
	private Message[] messages;
	private Comment[] comments;
	public String getOw_id() {
		return ow_id;
	}
	public void setOw_id(String ow_id) {
		this.ow_id = ow_id;
	}
	public String getPhomenumber() {
		return phomenumber;
	}
	public void setPhomenumber(String phomenumber) {
		this.phomenumber = phomenumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Order[] getOrders() {
		return orders;
	}
	public void setOrders(Order orders[]) {
		this.orders = orders;
	}
	public Message[] getMessages() {
		return messages;
	}
	public void setMessages(Message[] messages) {
		this.messages = messages;
	}
	public Comment[] getComments() {
		return comments;
	}
	public void setComments(Comment[] comments) {
		this.comments = comments;
	}
}

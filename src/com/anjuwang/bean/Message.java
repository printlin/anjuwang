package com.anjuwang.bean;

public class Message {
	private String mes_id;//咨询消息id
	private String ow_id;//咨询业主id
	private String com_id;//咨询公司id
	private String question;//咨询内容
	private String answer;//回复内容
	private String is_answer;//公司是否回答
	private String is_read;//业主是否阅读
	private String time;
	public Message(String mes_id, String ow_id, String com_id, String question, String answer, String is_answer,
			String is_read,String time) {
		super();
		this.mes_id = mes_id;
		this.ow_id = ow_id;
		this.com_id = com_id;
		this.question = question;
		this.answer = answer;
		this.is_answer = is_answer;
		this.is_read = is_read;
		this.time=time;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMes_id() {
		return mes_id;
	}
	public void setMes_id(String mes_id) {
		this.mes_id = mes_id;
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getIs_answer() {
		return is_answer;
	}
	public void setIs_answer(String is_answer) {
		this.is_answer = is_answer;
	}
	public String getIs_read() {
		return is_read;
	}
	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}
	
}

package com.anjuwang.bean;

import java.text.DecimalFormat;



public class Company {
	private String com_id;//公司id
	private String accounts;//公司账号
	private String password;//公司秘密
	private String com_name;//名称
	private String profile;//简介
	private String address;//公司总部地址
	private String price_min;//报价最小
	private String price_max;//报价最大
	private String level;//设计水平累计分值（业主打分0——5的累计，除以评分的业主数）
	private String attitude;//服务态度累计分值（同设计水平一样）
	private String quality;//施工质量（同上）
	private String bad;//差评次数
	private String commonly;//中评次数
	private String praise;//好评次数
	private String inquiry;//咨询次数
	private String[] authentica;//认证
	private String hotline;//咨询热线
	private String hand;//头像
	private String img1;//简介图片
	private String img2;
	private String img3;
	private String orderImg1;//案例展示图片
	private String orderImg2;
	private String orderImg3;
	private Order[] orders;
	private Message[] messages;
	
	
	public Order[] getOrders() {
		return orders;
	}

	public Company(String com_id, String accounts, String password, String com_name, String profile, String address,
			String price_min, String price_max, String level, String attitude, String quality, String bad,
			String commonly, String praise, String inquiry, String[] authentica, String hotline, String hand,
			String img1, String img2, String img3, String orderImg1, String orderImg2, String orderImg3, Order[] orders,
			Message[] messages) {
		super();
		this.com_id = com_id;
		this.accounts = accounts;
		this.password = password;
		this.com_name = com_name;
		this.profile = profile;
		this.address = address;
		this.price_min = price_min;
		this.price_max = price_max;
		this.level = level;
		this.attitude = attitude;
		this.quality = quality;
		this.bad = bad;
		this.commonly = commonly;
		this.praise = praise;
		this.inquiry = inquiry;
		this.authentica = authentica;
		this.hotline = hotline;
		this.hand = hand;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.orderImg1 = orderImg1;
		this.orderImg2 = orderImg2;
		this.orderImg3 = orderImg3;
		this.orders = orders;
		this.messages = messages;
	}

	public String getOrderImg1() {
		return orderImg1;
	}

	public void setOrderImg1(String orderImg1) {
		this.orderImg1 = orderImg1;
	}

	public String getOrderImg2() {
		return orderImg2;
	}

	public void setOrderImg2(String orderImg2) {
		this.orderImg2 = orderImg2;
	}

	public String getOrderImg3() {
		return orderImg3;
	}

	public void setOrderImg3(String orderImg3) {
		this.orderImg3 = orderImg3;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public void setOrders(Order[] orders) {
		this.orders = orders;
	}

	public Message[] getMessages() {
		return messages;
	}

	public void setMessages(Message[] messages) {
		this.messages = messages;
	}


	public Company() {
		super();
	}
	
	

	public int getTurnover(){//获取成交次数
		if(bad!=null && commonly!=null && praise!=null){
			int b=Integer.valueOf(bad);
			int c=Integer.valueOf(commonly);
			int p=Integer.valueOf(praise);
			return b+c+p;
		}
		return 0;
	}
	public String getLel(){//获取设计水平得分值
		int turnover=getTurnover();
		if(level!=null && turnover!=0){
			int lev=Integer.valueOf(level);
			DecimalFormat df=new DecimalFormat("0.00");
			return df.format((double)lev/(double)(turnover));
		}
		return "0.00";
	}
	public String getAtde(){//获取服务态度得分值
		int turnover=getTurnover();
		if(attitude!=null && turnover!=0){
			int att=Integer.valueOf(attitude);
			DecimalFormat df=new DecimalFormat("0.00");
			return df.format((double)att/(double)(turnover));
		}
		return "0.00";
	}
	public String getQuty(){//获取施工质量得分值
		int turnover=getTurnover();
		if(quality!=null && turnover!=0){
			int qua=Integer.valueOf(quality);
			DecimalFormat df=new DecimalFormat("0.00");
			return df.format((double)qua/(double)(turnover));
		}
		return "0.00";
	}
	public String getPrse(){//获取好评率
		int turnover=getTurnover();
		if(praise!=null && turnover!=0){
			int pra=Integer.valueOf(praise);
			DecimalFormat df=new DecimalFormat("0.00");
			return df.format((double)pra/(double)(turnover));
		}
		return "0.00";
	}
	public int getReputation(){//获取口碑值
		if(praise!=null && bad!=null && level!=null && attitude!=null && quality!=null){
			int pra=Integer.valueOf(praise);
			int ba=Integer.valueOf(bad);
			int com=Integer.valueOf(commonly);
			int lev=Integer.valueOf(level);
			int att=Integer.valueOf(attitude);
			int qua=Integer.valueOf(quality);
			return lev+att+qua+pra*2+com-ba*5;
		}
		return 0;
	}
	public String getWom(){//获取推荐指数
		float lel=Float.valueOf(getLel());
		float atde=Float.valueOf(getAtde());
		float prse=Float.valueOf(getPrse());
		return String.valueOf((int) Math.round((lel+atde+prse)/3));
	}
	public String getCom_id() {
		return com_id;
	}

	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrice_min() {
		return price_min;
	}

	public void setPrice_min(String price_min) {
		this.price_min = price_min;
	}

	public String getPrice_max() {
		return price_max;
	}

	public void setPrice_max(String price_max) {
		this.price_max = price_max;
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

	public String getBad() {
		return bad;
	}

	public void setBad(String bad) {
		this.bad = bad;
	}

	public String getCommonly() {
		return commonly;
	}

	public void setCommonly(String commonly) {
		this.commonly = commonly;
	}

	public String getPraise() {
		return praise;
	}

	public void setPraise(String praise) {
		this.praise = praise;
	}

	public String getInquiry() {
		return inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	public String[] getAuthentica() {
		return authentica;
	}

	public void setAuthentica(String[] authentica) {
		this.authentica = authentica;
	}

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
}

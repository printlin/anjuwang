package com.anjuwang.formBean;

import java.util.HashMap;
import java.util.regex.Pattern;

import com.anjuwang.service.OwnerService;



public class RegistFormBean {
	private String phomenumber;//账号（电话号码）
	private String nickname;//称谓
	private String password;//密码
	private String repassword;//重复密码
	private String chackCode;//验证码
	public RegistFormBean() {
		super();
	}
	public RegistFormBean(String phomenumber, String nickname, String password, String repassword, String chackCode) {
		super();
		this.phomenumber = phomenumber;
		this.nickname = nickname;
		this.password = password;
		this.repassword = repassword;
		this.chackCode = chackCode;
	}
	public HashMap<String,String> chack(){
		HashMap<String,String> errors=new HashMap<String, String>();
		if(this.phomenumber!=null && !this.phomenumber.trim().equals("")){
			if(!Pattern.matches("^[1][3,4,5,7,8][0-9]{9}$", this.phomenumber)){
				errors.put("phomenumber", "*手机号码格式错误");
				return errors;
			}else{
				OwnerService os=new OwnerService();
				if(os.findByPhomenumber(this.phomenumber)){
					errors.put("phomenumber", "*该号码已被注册");
					return errors;
				}
			}
		}else{
			errors.put("phomenumber", "*手机号码不能为空");
			return errors;
		}
		if(this.nickname!=null && !this.nickname.trim().equals("")){
			if(!Pattern.matches("^[\u4e00-\u9fa5],{0,}$", this.nickname)){
				errors.put("nickname", "*称谓必须为中文");
				return errors;
			}
		}else{
			errors.put("nickname", "*称谓不能为空");
			return errors;
		}
		if(this.password!=null && !this.password.trim().equals("")){
			if(this.password.length()<6){
				errors.put("password", "*密码长度需大于等于六位");
				return errors;
			}
			if(this.password.length()>16){
				errors.put("password", "*密码长度需小于等于十六位");
				return errors;
			}
		}else{
			errors.put("password", "*密码不能为空");
			return errors;
		}
		
		return errors;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getChackCode() {
		return chackCode;
	}
	public void setChackCode(String chackCode) {
		this.chackCode = chackCode;
	}
}

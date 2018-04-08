package com.anjuwang.formBean;

import java.util.HashMap;
import java.util.regex.Pattern;

import com.anjuwang.service.OwnerService;



public class LoginFormBean {
	private String phomenumber;//账号（电话号码
	private String password;//密码
	private String chackCode;//验证码
	private String remember;//记住我   （设置7天内免登陆）
	public LoginFormBean() {
		super();
	}
	public LoginFormBean(String phomenumber, String password, String chackCode, String remember) {
		super();
		this.phomenumber = phomenumber;
		this.password = password;
		this.chackCode = chackCode;
		this.remember = remember;
	}
	
	public HashMap<String,String> chack(){
		HashMap<String,String> errors=new HashMap<String, String>();
		if(this.phomenumber!=null && !this.phomenumber.trim().equals("")){
			if(!Pattern.matches("^[1][3,4,5,7,8][0-9]{9}$", this.phomenumber)){
				errors.put("phomenumber", "*手机号码格式错误");
				return errors;
			}else{
				OwnerService os=new OwnerService();
				if(!(os.findByPhomenumber(this.phomenumber))){
					errors.put("phomenumber", "*该号码不存在");
					return errors;
				}
			}
		}else{
			errors.put("phomenumber", "*手机号码不能为空");
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
		OwnerService os=new OwnerService();
		if(os.login(this.phomenumber, this.password)==null){
			errors.put("password", "*密码错误");
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChackCode() {
		return chackCode;
	}
	public void setChackCode(String chackCode) {
		this.chackCode = chackCode;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}
	
}

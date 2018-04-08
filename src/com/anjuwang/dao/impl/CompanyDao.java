package com.anjuwang.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anjuwang.bean.Company;
import com.anjuwang.common.DBUtil;
import com.anjuwang.common.MyDbUtil;
import com.anjuwang.dao.ICompanyDao;



public class CompanyDao implements ICompanyDao {

	

	@Override
	public Company getCompanyForId(String com_id) {
		// TODO Auto-generated method stub
		List<Map<String, String>> list=MyDbUtil.executeQuery("SELECT * FROM company WHERE com_id=?", new Object[]{com_id});
		if(list!=null && list.size()>0){
			Map<String, String> com=list.get(0);
			Company company=toCompany(com);
			return company;
		}
		return null;
	}
	
	@Override
	public List<Company> getAllCompany() {
		
		List<Company> com=new ArrayList<Company>();
		List<Map<String, String>> companys=MyDbUtil.executeQuery("SELECT * FROM company", null);
		for(int i=0;i<companys.size();i++){
			
			Company company=toCompany(companys.get(i));
			com.add(company);
		}
		return com;
	}
	
	@Override
	public List<Company> getAllCompany(int start, int lenth) {
		
		List<Company> com=new ArrayList<Company>();
		List<Map<String, String>> companys=MyDbUtil.executeQuery("SELECT * FROM company LIMIT "+start+","+lenth, null);
		for(int i=0;i<companys.size();i++){
			
			Company company=toCompany(companys.get(i));
			com.add(company);
		}
		return com;
	}
	
	@Override
	public int getAllCompanyNum() {
		int number=0;
		Map<String, String> num=MyDbUtil.executeQuery("SELECT COUNT(*) AS num FROM company", null).get(0);
		number=Integer.valueOf(num.get("num"));
		return number;
	}

	@Override
	public List<Company> getPlaceCompany(String place) {
		List<Company> com=new ArrayList<Company>();
		
		List<Map<String, String>> adss=MyDbUtil.executeQuery("SELECT com_id,address FROM region WHERE place=?",new Object[]{place});
		Map<String, String> address=new HashMap<String, String>();
		for(int a=0;a<adss.size();a++){
			address.put(adss.get(a).get("com_id"), adss.get(a).get("address"));
		}
		
		//Map<String, String> fields=MyDbUtil.executeQuery("SELECT GROUP_CONCAT(column_name SEPARATOR ',') AS fields_name FROM information_schema.COLUMNS WHERE column_name <>'address' AND table_name='company' GROUP BY table_name", null).get(0);
		List<Map<String, String>> companys=MyDbUtil.executeQuery("SELECT * FROM company WHERE com_id IN (SELECT com_id FROM region WHERE place=?)", new Object[]{place});
		for(int i=0;i<companys.size();i++){
			
			Company company=toCompany(companys.get(i));
			company.setAddress(address.get(String.valueOf(company.getCom_id())));//(companys.get(i).get("address")));
			com.add(company);
		}
		return com;
	}

	@Override
	public List<Company> getPlaceCompany(String place, int start, int lenth) {
		
		List<Company> com=new ArrayList<Company>();
		
		List<Map<String, String>> adss=MyDbUtil.executeQuery("SELECT com_id,address FROM region WHERE place=?",new Object[]{place});
		Map<String, String> address=new HashMap<String, String>();
		for(int a=0;a<adss.size();a++){
			address.put(adss.get(a).get("com_id"), adss.get(a).get("address"));
		}
		
		//Map<String, String> fields=MyDbUtil.executeQuery("SELECT GROUP_CONCAT(column_name SEPARATOR ',') AS fields_name FROM information_schema.COLUMNS WHERE column_name <>'address' AND table_name='company' GROUP BY table_name", null).get(0);
		List<Map<String, String>> companys=MyDbUtil.executeQuery("SELECT * FROM company WHERE com_id IN (SELECT com_id FROM region WHERE place=? ) LIMIT "+start+","+lenth, new Object[]{place});
		for(int i=0;i<companys.size();i++){
			
			Company company=toCompany(companys.get(i));
			company.setAddress(address.get(String.valueOf(company.getCom_id())));//(companys.get(i).get("address")));
			com.add(company);
		}
		return com;
	}


	@Override
	public int getPlaceCompanyNum(String place) {
		int number=0;
		Map<String, String> num=MyDbUtil.executeQuery("SELECT COUNT(*) AS num FROM company WHERE com_id IN (SELECT com_id FROM region WHERE place=? )", new Object[]{place}).get(0);
		number=Integer.valueOf(num.get("num"));
		return number;
	}
	
	private Company toCompany(Map<String, String> com){
		Company company=new Company();
		
		company.setCom_id(com.get("com_id"));
		company.setAccounts(com.get("accounts"));
		company.setPassword(com.get("password"));
		company.setCom_name((com.get("com_name")));
		company.setProfile((com.get("profile")));
		company.setAddress((com.get("address")));
		company.setPrice_min((com.get("price_min")));
		company.setPrice_max((com.get("price_max")));
		company.setLevel((com.get("level")));
		company.setAttitude((com.get("attitude")));
		company.setQuality((com.get("quality")));
		company.setBad((com.get("bad")));
		company.setCommonly((com.get("commonly")));
		company.setPraise((com.get("praise")));
		company.setInquiry((com.get("inquiry")));
		company.setHotline(com.get("hotline"));
		company.setHand(com.get("hand"));
		company.setImg1(com.get("img1"));
		company.setImg2(com.get("img2"));
		company.setImg3(com.get("img3"));
		company.setOrderImg1(com.get("orderImg1"));
		company.setOrderImg2(com.get("orderImg2"));
		company.setOrderImg3(com.get("orderImg3"));
		String authentica=com.get("authentica");
		String authenticaA[]=authentica.split("-");
		company.setAuthentica(authenticaA);
		return company;
	}
	
	public boolean deleteThis(Company bean){
		String sql="delete from `company` where com_id=?";
		Object[] ob=new Object[]{bean.getCom_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean addThis(Company bean){
		String sql="insert into `company` (`accounts`,`password`,`com_name`,`profile`,`address`,`price_min`,`price_max`,`level`,`attitude`,`quality`,`bad`,`commonly`,`praise`,`authentica`,`inquiry`,`hotline`,`hand`,`img1`,`img2`,`img3`,`orderImg1`,`orderImg2`,`orderImg3`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String[] area=bean.getAuthentica();
		String authentica="" ;
		if(area!=null && area.length>0){
			authentica=area[0];
			for(int i=1,j=area.length;i<j;i++){
				authentica=authentica+"-"+area[i];
			}
		}
		Object[] ob=new Object[]{bean.getAccounts(),bean.getPassword(),bean.getCom_name(),bean.getProfile(),bean.getAddress(),bean.getPrice_min(),bean.getPrice_max(),bean.getLevel(),bean.getAttitude(),bean.getQuality(),bean.getBad(),bean.getCommonly(),bean.getPraise(),authentica,bean.getInquiry(),bean.getHotline(),bean.getHand(),bean.getImg1(),bean.getImg2(),bean.getImg3(),bean.getOrderImg1(),bean.getOrderImg2(),bean.getOrderImg3()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean updateThis(Company bean){
		String sql="update `company` set `accounts`=?,`password`=?,`com_name`=?,`profile`=?,`address`=?,`price_min`=?,`price_max`=?,`level`=?,`attitude`=?,`quality`=?,`bad`=?,`commonly`=?,`praise`=?,`authentica`=?,`inquiry`=?,`hotline`=?,`hand`=?,`img1`=?,`img2`=?,`img3`=?,`orderImg1`=?,`orderImg2`=?,`orderImg3`=? where com_id=?";
		String[] area=bean.getAuthentica();
		String authentica="" ;
		if(area!=null && area.length>0){
			authentica=area[0];
			for(int i=1,j=area.length;i<j;i++){
				authentica=authentica+"-"+area[i];
			}
		}
		Object[] ob=new Object[]{bean.getAccounts(),bean.getPassword(),bean.getCom_name(),bean.getProfile(),bean.getAddress(),bean.getPrice_min(),bean.getPrice_max(),bean.getLevel(),bean.getAttitude(),bean.getQuality(),bean.getBad(),bean.getCommonly(),bean.getPraise(),authentica,bean.getInquiry(),bean.getHotline(),bean.getHand(),bean.getImg1(),bean.getImg2(),bean.getImg3(),bean.getOrderImg1(),bean.getOrderImg2(),bean.getOrderImg3(),bean.getCom_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public Company selectThis(Company bean){
		Company[] beanA=null;
		String sql="select * from `company` where com_id=?";
		Object[] ob=new Object[]{bean.getCom_id()};
		beanA=full(DBUtil.executeQuery(sql, ob));
		if(beanA!=null && beanA.length>0){
			return beanA[0];
		}
		return null;
	}
	public Company[] selectAll(){
		Company[] beanA=null;
		String sql="select * from `company` order by level DESC";
		beanA=full(DBUtil.executeQuery(sql, null));
		return beanA;
	}
	public Company[] selectByName(String name){
		Company[] beanA=null;
		String sql="select * from `company` where com_name like '?' order by level DESC";
		StringBuffer sb=new StringBuffer();
		sb.append("%");
		for(int i=0;i<name.length();i++){
			sb.append(name.charAt(i)+"%");
		}
		Object[] ob=new Object[]{sb.toString()};
		beanA=full(DBUtil.executeQuery(sql, ob));
		return beanA;
	}
	
	private Company[] full(List<Map<String,String>> list){
		Company[] beanA=null;
		if(list!=null && list.size()>0){
			beanA=new Company[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				beanA[i]=toCompany(map);
			}
		}
		return beanA;
	}
	@Override
	public boolean addCompany(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updataCompany(String companyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompany(String companyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompanyByName(String companyName) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

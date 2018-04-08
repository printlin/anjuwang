package com.anjuwang.common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;



public class DBUtil {

	//得到数据库连接
	public static Connection getConnection(){
		
		//1.得到properties文件
		Connection con = null;
		Properties p = new Properties();
		try {
			p.load(MyDbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//1.加载驱动
			Class.forName(p.getProperty("driver"));
			//2.得到数据库连接
			con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("name"),p.getProperty("password"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static <T>List<T> executeQuery(Class<T> c,String sql,Object[] params){
		Connection con = getConnection();
		ResultSet rs = null;
		List<T> resultlist = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//遍历传入的参数
			if(params!=null){
				if(params.length!=0){
					for(int i=0;i<params.length;i++){
						//将问号替换成参数
						ps.setObject(i+1, params[i]);
					}
				}
			}
			//执行查询
			rs = ps.executeQuery();
			//得到结果集元数据
			ResultSetMetaData md =  rs.getMetaData();
			resultlist = new ArrayList<T>();
			//遍历结果集
			while(rs.next()){
				T entity;
				try {
					entity = c.newInstance();
					for(int i=1;i<=md.getColumnCount();i++){
						//setUname  setAge
						Method m = c.getMethod("set"+md.getColumnName(i).substring(0, 1).toUpperCase()+md.getColumnName(i).substring(1), String.class);
						m.invoke(entity, rs.getString(i));
						
					}
					resultlist.add(entity);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			close(con,ps,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultlist;
		
	}
	
	
	public static boolean executeUpdate(String sql,Object[] params){
		Connection con = getConnection();
		boolean result = true;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//遍历传入的参数
			if(params!=null){
				if(params.length!=0){
					for(int i=0;i<params.length;i++){
						//将问号替换成参数
						ps.setObject(i+1, params[i]);
					}
				}
			}
			//执行更新
			int row = ps.executeUpdate();
			result = row>0;
			close(con,ps,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static List<Map<String,String>> executeQuery(String sql,Object[] ob){
		List<Map<String,String>> resultlist =null;
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if(ob!=null){
				for(int i=0;i<ob.length;i++){
					ps.setObject(i+1, ob[i]);
				}
			}
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			resultlist = new ArrayList<Map<String,String>>();
			while(rs.next()){
				Map<String,String> m = new HashMap<String, String>();
				for(int i=0;i<md.getColumnCount();i++){
					m.put(md.getColumnName(i+1), rs.getString(i+1));
				}
				resultlist.add(m);
			}
			close(con, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultlist;
	}
	
	public static void close(Connection con,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
					rs.close();
			}
			if(ps!=null){
					ps.close();
			}
			if(con!=null){
					con.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

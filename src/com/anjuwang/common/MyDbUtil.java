package com.anjuwang.common;

import java.io.IOException;
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

public class MyDbUtil {
	//1.得到数据库连接
	public static Connection getConnection(){
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

	//2.关闭连接
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
	
	public static ResultSet executeQuery2(String sql,Object[] params) throws SQLException{
		//1.得到连接
		Connection con = getConnection();

			//2.创建语句块
			PreparedStatement ps = con.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
					
			//3.执行
		ResultSet rs = ps.executeQuery();
		close(con, ps, rs);
		System.out.println("有结果");
		return rs;

	}
	
	//3.执行通用查询(select * from student where id=? and sname=?)
	public static List<Map<String,String>> executeQuery(String sql,Object[] params){
		List<Map<String,String>> resultlist =null;
		//1.得到连接
		Connection con = getConnection();
		try {
			//2.创建语句块
			PreparedStatement ps = con.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			
			//3.执行
			ResultSet rs = ps.executeQuery();
			
			//4.遍历结果集
			ResultSetMetaData md = rs.getMetaData();//结果集元数据
			resultlist = new ArrayList<Map<String,String>>();
			while(rs.next()){
				Map<String,String> m = new HashMap<String, String>();//一行一个map
				for(int i=0;i<md.getColumnCount();i++){
					m.put(md.getColumnName(i+1), rs.getString(i+1));
				}
				resultlist.add(m);
			}
			
			//5.关闭连接
			close(con, ps, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultlist;
		
		
		
	}
	
	
	//4.执行增删改
	public static boolean executeUpdate(String sql,Object[] params){
		int row = 0;
		//1.得到连接
		Connection con = getConnection();
		try {
			//2.创建语句块
			PreparedStatement ps = con.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			
			//3.执行
			row = ps.executeUpdate();
			
			
			
			//4.关闭连接
			close(con, ps, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row>0;
	}
	
	
}

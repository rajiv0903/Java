package com.practice.nosql.gemfire.events.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.practice.nosql.gemfire.model.BookMaster;

public class BookMasterDaoImpl implements BookMasterDao {

	private String url;
	private Properties info = new Properties();
	
	public BookMasterDaoImpl(String driverClassName, String url, String userName, String password) {
		try {
			Class.forName(driverClassName);
			
		}catch(ClassNotFoundException ex) {
			System.err.println("unable to load the class");
			System.exit(1);
		}
		this.url = url;
		info.put("user", userName);
		info.put("password", password);
	}
	@Override
	public BookMaster getBookMaster(int itemNumber) {
		
		BookMaster book = null;
		Connection conn = null;
		String sql= "select * from Books where itemNumber = ?";
		try {
			conn= DriverManager.getConnection(url, info);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, itemNumber);
			ResultSet rs = st.executeQuery();
			rs.first();
			book = new BookMaster(rs.getInt("itemNumber"), 
					rs.getString("title") , 
					rs.getString("description") , 
					rs.getFloat("retailCost") , 
					rs.getInt("yearPublished") ,
					rs.getString("author"));
			
		}	
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}catch (Exception e) {
			}
		}
		
		return book;
	}

}

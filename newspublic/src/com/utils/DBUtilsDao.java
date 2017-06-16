package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;

public class DBUtilsDao {
	private static String url = "jdbc:mysql://localhost:3306/news?characterEncoding=utf-8";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "zyt123456789";
	
	private ResultSet resultSet;
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection () {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void close (PreparedStatement preparedStatement,Connection connection,ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultSet = null;
		}
		
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			preparedStatement = null;
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}
	
	public List executequery (String sql,String [] paras) {
		List list = new ArrayList();
		try {
			
			this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (paras !=null ) {
				for (int i=0;i<paras.length;i++) {
					preparedStatement.setString(i+1, paras[i]);
				}
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			int column = resultSetMetaData.getColumnCount();
			//System.out.println(column);
			while (resultSet.next()) {
				  Object[] ob = new Object[column];
				  for(int i = 1;i<=column;i++){
                      ob[i-1] = resultSet.getObject(i);
                 }
				  list.add(ob);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close(preparedStatement, connection, resultSet);
		}
		return list;
	}
	
	public void update (String sql,String paras[]) {
		try {
			this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (paras != null) {
				for (int i=0;i<paras.length;i++) {
					preparedStatement.setString(i+1, paras[i]);
				}
			}
			 preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close(preparedStatement, connection, resultSet);
		}
	}
	
	
	
	
}

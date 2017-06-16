package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.po.Admin;
import com.utils.DBUtilsDao;


public class TestDao {

	@Test
	public void test() throws SQLException {
		
		DBUtilsDao dao = new DBUtilsDao();
		String sql = "select * from admin where 1=? ";
		String paras[] = {"1"};
		List list = dao.executequery(sql, paras);
		List <Admin> list1 = new  ArrayList<Admin>();
		Admin admin = new Admin();
		for (int i=0;i<list.size();i++) {
			Object object[] = (Object[]) list.get(i); 
			admin.setId((Integer)object[0]);
			admin.setName(object[1].toString());
			admin.setPassword(object[2].toString());
			list1.add(admin);
		}
		
		for (Admin ad:list1) {
			System.out.println(ad.getName());
		}
		
	}
	
	@Test
	public void test2 () {
		DBUtilsDao dao = new DBUtilsDao();
		Admin ad = new Admin();
		String sql = "update admin set name=?";
		String [] paras = {"pp"};
		dao.update(sql, paras);
		
		
	}

}


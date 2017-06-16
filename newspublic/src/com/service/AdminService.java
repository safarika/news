package com.service;

import java.util.ArrayList;
import java.util.List;

import com.po.Admin;
import com.utils.DBUtilsDao;

public class AdminService {
	public boolean checkAdmin (Admin admin) {
		
		String sql = "select * from admin where id=? and password=?";
		String [] paras = {admin.getId()+"",admin.getPassword()};
		DBUtilsDao dao = new DBUtilsDao();
		List list = dao.executequery(sql, paras);
		if (list.size() != 0) {
			Object[] obj = (Object[]) list.get(0);
			admin.setId((Integer)obj[0]);
			admin.setName(obj[1].toString());
			admin.setPassword(obj[2].toString());
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public List showAdmin () {
			Admin admin = new  Admin();
			String sql = "select * from admin where 1=?";
			String [] paras = {"1"};
			DBUtilsDao dao = new DBUtilsDao();
			List list = dao.executequery(sql, paras);
			List l = new ArrayList();
			for (int i=0;i<list.size();i++) {
				Object[] obj = (Object[]) list.get(i);
				admin.setId((Integer)obj[0]);
				admin.setName((String)obj[1]);
				admin.setPassword((String)obj[2]);
				l.add(admin);
			}
				
				return l;	
		}
	
		public Admin fingById(String id) {
			Admin admin = new Admin();
			String sql = "select * from admin where id=?";
			String [] paras = {id};
			DBUtilsDao dao = new DBUtilsDao();
			List list = dao.executequery(sql, paras);
			if (list.size() != 0) {
				Object[] obj = (Object[]) list.get(0);
				admin.setId((Integer)obj[0]);
				admin.setName(obj[1].toString());
				admin.setPassword(obj[2].toString());
			}
			return admin;
		}
}

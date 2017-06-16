package com.service;

import java.util.ArrayList;
import java.util.List;

import com.po.Admin;
import com.po.User;
import com.utils.DBUtilsDao;

public class UserService {
	public List showUser () {
		
		String sql = "select * from user where 1=?";
		String [] paras = {"1"};
		DBUtilsDao dao = new DBUtilsDao();
		List list = dao.executequery(sql, paras);
		List l = new ArrayList();
		for (int i=0;i<list.size();i++) {
			User user = new User();
			Object[] obj = (Object[]) list.get(i);
			user.setId(obj[0].toString());
			user.setName(obj[1].toString());
			user.setPwd(obj[2].toString());
			l.add(user);
		}
			
			return l;	
	}
	
	public User findByid(String id) {
		String sql = "select * from user where id=?";
		String [] paras = {id};
		User user = new User();
		DBUtilsDao dao = new DBUtilsDao();
		List us = dao.executequery(sql, paras);
		if (us.size() != 0) {
			
			Object[] ob = (Object[]) us.get(0);
			user.setId(ob[0].toString());
			user.setName(ob[1].toString());
			user.setPwd(ob[2].toString());
			
		}
		return user;
	}
	
	public void update(User user) {
		String sql = "update user set name=?,pwd=? where id=?";
		String paras [] = {user.getName(),user.getPwd(),user.getId()};
		DBUtilsDao dao = new DBUtilsDao();
		dao.update(sql, paras);
	}
	
	public void delete (String id) {
		String sql = "delete from user where id=?";
		String paras[] = {id};
		DBUtilsDao dao = new DBUtilsDao();
		dao.update(sql, paras);
	}
}

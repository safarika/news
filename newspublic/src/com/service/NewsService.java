package com.service;

import java.util.ArrayList;
import java.util.List;

import com.control.News;
import com.po.New;
import com.po.User;
import com.utils.DBUtilsDao;

public class NewsService {
	public List showNews () {
		String sql = "select * from new where 1=?";
		String [] paras = {"1"};
		DBUtilsDao dao = new DBUtilsDao();
		List list = dao.executequery(sql, paras);
		List l = new ArrayList();
		for (int i=0;i<list.size();i++) {
			com.po.New news = new com.po.New();
			Object[] obj = (Object[]) list.get(i);
			news.setId(obj[0].toString());
			news.setTitle(obj[1].toString());
			news.setContent(obj[2].toString());
			l.add(news);
		}
			
			return l;	
	}
	
	public void delete(String id) {
		String sql = "delete from new where id=?";
		String paras[] = {id};
		DBUtilsDao dao = new DBUtilsDao();
		dao.update(sql, paras);
	}
	
	public void publish (New news) {
		String sql = "insert into new values(2,'china',?)";
		String paras[] = {news.getContent()};
		DBUtilsDao dao = new DBUtilsDao();
		dao.update(sql, paras);
	}
}

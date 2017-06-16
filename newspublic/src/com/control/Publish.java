package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.New;
import com.service.NewsService;

public class Publish extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("n");
		NewsService newsService = new NewsService();
		New news = new New();
		news.setContent(content);
		newsService.publish(news);
		List l = newsService.showNews();
		request.setAttribute("news", l);
		request.getRequestDispatcher("news.jsp").forward(request, response);
	}

}

package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;
import com.service.UserService;

public class Doupdate extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		
		String name = request.getParameter("nam");
		String pwd = request.getParameter("pwd");
		String id1 = request.getParameter("id1");
		UserService userService = new  UserService();
		User user = new User();
		user.setId(id1);
		user.setName(name);
		user.setPwd(pwd);
		userService.update(user);
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
		
	}

}

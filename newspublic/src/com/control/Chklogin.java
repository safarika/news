package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Admin;
import com.service.AdminService;
import com.service.UserService;

public class Chklogin extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		Admin admin = new Admin();
		AdminService adminService = new AdminService();
		admin.setId(Integer.parseInt(id));
		admin.setPassword(pwd);
		if (adminService.checkAdmin(admin)) {
			Admin ad = adminService.fingById(id);
			request.getSession().setAttribute("admin",ad );
			request.getRequestDispatcher("newsmanager.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
		
	}

}

package com.jjfk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjfk.entity.Tstudent;
import com.jjfk.util.BaseServlet;

public class LoginServlet extends BaseServlet {
	/**
	 * ��¼����
	 */
	public void userLong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//��ȡ�û��� ����
		String logName=request.getParameter("logName");
		String logPwd=request.getParameter("logPwd");
		
		//�������� ��ѯ����
		Tstudent logUser = new Tstudent(1001, logName, logPwd, "Ů", 20, "2000-10-22");
		
		HttpSession session = request.getSession();
		session.setAttribute("logUser", logUser);
		session.setMaxInactiveInterval(60*60*24*15);
		
		request.getRequestDispatcher("../index.jsp").forward(request, response);
	}
	
	public String userLong2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		request.setAttribute("list", "list");
		return "../main.jsp";
		
	}
}

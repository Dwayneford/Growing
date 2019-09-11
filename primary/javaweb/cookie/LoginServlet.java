package com.dkt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	//ʵ����
	public LoginServlet() {
		super();
	}
	//��ʼ��
	public void init() throws ServletException {
		
	}
	
	//���� �е������������� ִ�з��� (service() ָ��ָ���������ͷ��� dopost doget doput......)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//userLogin
		//��ȡ����ķ�������
		String choseMeth = request.getParameter("op");
		
		if(("userLogin").equals(choseMeth)){
			//���� ��¼ ����
			userLogin(request, response);
		}
	
		
	}
	/**
	 * ��¼����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��¼ �û��� ������
		String loginname = request.getParameter("loginname");
		String nloginpwd= request.getParameter("nloginpwd");
		
		//��ѯ ���ݿ��� �Ƿ��и�������
		
		if(("admin").equals(loginname)&&("123456").equals(nloginpwd)){
			//��ת����ҳ
			request.setAttribute("lonsuc", "��ϲ ��¼�ɹ�������");
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}else{
			//�����ڵ�ҳ����
			response.sendRedirect("../login.jsp");
		}
	}
	
	
	
	
	
	
	//�������������ٷ���
	public void destroy() {
		super.destroy(); 
	}

	

}

package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���� ��servlet ��
 * @author direct
 */
public class BaseServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//ȷ����������� ֻ���� BaseServlet ������
		Class<? extends BaseServlet> requestClass = this.getClass();
		//���ù��� ���� ������
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//.....
		
		//��ȡ ��������� ��������
		String methodName = req.getParameter("method");
		try {
			Method method = requestClass.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//ִ�и÷���:ִ�� ������ ��Ӧ������ ����
			Object invoke = method.invoke(this, req, res);
			
			//������ת
			if(invoke!=null){
				req.getRequestDispatcher((String)invoke).forward(req, res);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

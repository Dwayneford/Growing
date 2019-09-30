package com.summary;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

public class Two_way_call_method {

}
/**
���÷����ڵ����ַ���
����һ:�ù�dopost����
servlet��:
������̳�HttpServlet
response.setContentType("text/html");
		//�����ʽ����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//ͨ�������ж�ִ�кη���
		String op = request.getParameter("op");
		if (("updateImg").equals(op)) {
			//�������ˮӡ����
			updateImg(request, response);
		}else if (("getCode").equals(op)) {
			//���û�ȡ��֤�뷽��
			getCode(request, response);
		}
	updateImg(){}
	getCode(){}
�����ļ�:
  <servlet>
    <servlet-name>ChangeImg</servlet-name>
    <servlet-class>com.servlet.ChangeImg</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ChangeImg</servlet-name>
    <url-pattern>/servlet/ChangeImg</url-pattern>
  </servlet-mapping>
ǰ̨:
servlet/ChangeImg?op=getCode

������:����������:BaseServlet ex HttpServlet
@Override//��дservice����
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
ChangeImg_EX_BaseServlet extends BaseServlet�෽��:
	updateImg(){}
	getCode(){}
�����ļ�:
  <servlet>
    <servlet-name>ChangeImg_EX_BaseServlet</servlet-name>
    <servlet-class>com.servlet.ChangeImg_EX_BaseServlet</servlet-class>
  </servlet>
    <servlet-mapping>
    <servlet-name>ChangeImg_EX_BaseServlet</servlet-name>
    <url-pattern>/servlet/ChangeImg_EX_BaseServlet</url-pattern>
  </servlet-mapping>
ǰ̨:servlet/ChangeImg_EX_BaseServlet?method=getCode


*/
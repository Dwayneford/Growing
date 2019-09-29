package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class DoDownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		//�õ������ļ�������
		String fileName = new String(request.getParameter("filename").getBytes("ISO-8859-1"),"GB2312");
		//����һ��smartupload����
		SmartUpload su = new SmartUpload();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		//��ʼ��
		su.initialize(pageContext);
		su.setContentDisposition(null);
		//�����ļ�
		try {
			su.downloadFile("/upload/"+fileName);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}

//<p>�ļ�����</p>
//<a href="servlet/DoDownloadServlet?filename=logo.jpg">�������</a>


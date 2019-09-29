package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class DoUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		//�½�һ��smartupload����
		SmartUpload su = new SmartUpload();
		//d�õ�pagecontest����
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		//�ϴ���ʼ��
		su.initialize(pageContext);
		
		//�ϴ��ļ�
		try {
			su.upload();
			//���ϴ��ļ�ȫ�����浽ָ��Ŀ¼���������ϴ����ļ���
			int count = su.save("/upload");
			System.out.println(count+"���ļ��ϴ��ɹ�<br>");
			
			
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		//��һ��ȡ�ϴ��ļ���Ϣ��ͬʱ���Ա����ļ�
		for (int i = 0; i < su.getFiles().getCount(); i++) {
			SmartFile file = su.getFiles().getFile(i);
			//���ļ������������
			if (file.isMissing()) continue ;
			
			//��ʾ��ǰ�ļ���Ϣ
		
		}
		
	}
	
}

//<p>�ļ��ϴ�</p>
//<form method="post" enctype="multipart/form-data"  action="servlet/DoUploadServlet" >
//
//1.<input type="file" name="file1" size="30"><br>
//2.<input type="file" name="file2" size="30"><br>
//3.<input type="file" name="file2" size="30"><br>
//<input type="submit" name="submit" value="��ʼ�ϴ�" >
//</form>
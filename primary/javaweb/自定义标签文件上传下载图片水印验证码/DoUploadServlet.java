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
		//新建一个smartupload对象
		SmartUpload su = new SmartUpload();
		//d得到pagecontest对象
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		//上传初始化
		su.initialize(pageContext);
		
		//上传文件
		try {
			su.upload();
			//将上传文件全部保存到指定目录，并返回上传的文件数
			int count = su.save("/upload");
			System.out.println(count+"个文件上传成功<br>");
			
			
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		//逐一提取上传文件信息，同时可以保存文件
		for (int i = 0; i < su.getFiles().getCount(); i++) {
			SmartFile file = su.getFiles().getFile(i);
			//若文件不存在则继续
			if (file.isMissing()) continue ;
			
			//显示当前文件信息
		
		}
		
	}
	
}

//<p>文件上传</p>
//<form method="post" enctype="multipart/form-data"  action="servlet/DoUploadServlet" >
//
//1.<input type="file" name="file1" size="30"><br>
//2.<input type="file" name="file2" size="30"><br>
//3.<input type="file" name="file2" size="30"><br>
//<input type="submit" name="submit" value="开始上传" >
//</form>
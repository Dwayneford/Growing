package com.jjfk.servlet;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjfk.util.BaseServlet;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;

public class FileUploadSerlet extends BaseServlet {
	/**
	 * 文件上传操作
	 * @param req
	 * @param res
	 * @throws ServletException 
	 */
	public void uploadeFile(HttpServletRequest req,HttpServletResponse res) throws Exception{
		
		//确定文件上传位置
		String file = req.getSession().getServletContext().getRealPath("uploadFile");
		
		//确定是否 存在该文件 
		File fi =	new File(file);
		
		if(!fi.exists()){
			fi.mkdir();
		}
		//获取上传类 操作文件
		SmartUpload su = new SmartUpload();
		//初始化 上传信息
		su.initialize(this.getServletConfig(),req,res);
		
		//设置上传 文件的配置内容
		su.setMaxFileSize(5000000);//字节单位
		su.setAllowedFilesList("txt,jpg,png,ico,docx");//允许上传的内容
		su.setDeniedFilesList("html,exe");
		
		
		//上传
		su.upload();
		
		//获取参数 不能够直接 获取req参数
		/*String userNickName = req.getParameter("userNickName");
		String userAge = req.getParameter("userAge");*/
		//通过 SmartUpload 获取指定要请求的数据
		String userNickName =  su.getRequest().getParameter("userNickName");
		String userAge =  su.getRequest().getParameter("userAge");
		
		System.out.println("===>"+userNickName+"==="+userAge);
		
		
		//保存数据
		SmartFiles sf = su.getFiles();
		
		for (int i = 0; i < sf.getCount(); i++) {
			//String fileName = sf.getFile(i).getFieldName();
			String fileName = sf.getFile(i).getFileName();
			//su.save("/uploadFile/"+fileName);
			su.getFiles().getFile(i).saveAs("/uploadFile/"+fileName);
		}
		//跳转到文件页面
		res.sendRedirect("../index.jsp");
	}
	/**
	 * 显示文件列表
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public String showFileUrl(HttpServletRequest req,HttpServletResponse res) throws Exception{
		
		//获取文件夹中的文件
		String filePath = req.getServletContext().getRealPath("/uploadFile");
		
		//通过路径 获取 文件夹
		File upName = new File(filePath);
		//获取对应的 文件列表
		File[] namefs = upName.listFiles();
		
		ArrayList<String> list = new ArrayList<String>();
		//遍历操作
		for (File fi : namefs) {
			//判断是否 是文件  文件夹 ......
			list.add(fi.getName());
		}
		req.setAttribute("list", list);
		return "../index.jsp";
	}
	
	/**
	 * 文件下载操作
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	public  void downloadFile(HttpServletRequest req,HttpServletResponse res) throws Exception{
		//图片存放的位置
		String filePath = req.getServletContext().getRealPath("/uploadFile");
		
		//获取路径
		String fileName = req.getParameter("downFileName");
		
		//处理中文 get方式
		fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
		
		//下载 方法
		SmartUpload  smp = new SmartUpload();
		//初始化操作
		smp.initialize(this.getServletConfig(),req,res);
		//已文件的形式 保存下载内容
		smp.setContentDisposition(null);
		
		System.out.println(filePath+"/"+fileName);
		smp.downloadFile(filePath+"/"+fileName);
	}
	
	
	
	
	
	
	
}

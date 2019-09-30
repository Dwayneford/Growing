package com.jjfk.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjfk.util.BaseServlet;
import com.jjfk.util.CommonsUtil;

public class CommonsServlet extends BaseServlet {
	/**
	 * 文件上传
	 * @param req
	 * @param res
	 * @throws IOException 
	 */
	public void commonFileUp(HttpServletRequest req, HttpServletResponse res) throws IOException{
		//调用 文件上传方法
		HashMap<String, Object> map = CommonsUtil.uploadFile(req);
		
		//变量map 数据
		System.out.println(""+map.get("useImg"));
		System.out.println(""+map.get("userNickName"));
		System.out.println(""+map.get("userAge"));
		res.sendRedirect("../commonsFile.jsp");
	}
	/**
	 * 遍历显示 文件名称v
	 * @param req
	 * @param res
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void showCommonFileList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//上传文件目录
		String uploadPath = this.getServletContext().getRealPath("/upload");
		//定义 集合 存放文件名称
		/*Map<String, String> fileNameMap = new HashMap<String, String>();*/
		List<String> list = new ArrayList<String>();
 		//根据路径生成 文件
		File file =	new File(uploadPath);
		//调用方法
		this.listfile(file, list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("../commonsFile.jsp").forward(req, res);
	}
	
	//遍历 文件夹中的文件 
	public  void listfile(File file,List<String> list){
		//判断 是否 是一个文件 目录
		if(!file.isFile()){
			//取出文件夹遍历：递归方式
			File[] files= file.listFiles();
			
			for (File f : files) {
				listfile(f, list);
			}
		}else{
			//map.put(file.getName(), file.getName());
			list.add(file.getName());
		}
	}
	
	/**
	 * 图片下载
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	public void downloadFile(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//获取下载文件名称
		String fileName = req.getParameter("fileName");
		fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
		//确定下载的目录文件夹
		String fileSavePath = this.getServletContext().getRealPath("/upload");
		//拼接下载的文件路径
		File file = new File(fileSavePath+"\\"+fileName);
		
		if(!file.exists()){
			req.setAttribute("message", "下载的文件不存在....");
			req.getRequestDispatcher("../commonsFile.jsp").forward(req, res);
			return;
		}
		//如果文件存在 则下载
		res.setHeader("content-disposition","attachment; filename="+URLEncoder.encode(fileName, "utf-8"));
		//已文件流的方式 进行下载操作
		FileInputStream in = new FileInputStream(file);
		OutputStream out =	res.getOutputStream();
		byte buffer[] = new byte[1024];
		int lne = 0;
		//循环读取
		while((lne=in.read(buffer))>0){
			out.write(buffer, 0, lne);
		}
		in.close();
		out.close();
	}
	
}

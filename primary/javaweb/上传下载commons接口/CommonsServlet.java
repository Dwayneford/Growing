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
	 * �ļ��ϴ�
	 * @param req
	 * @param res
	 * @throws IOException 
	 */
	public void commonFileUp(HttpServletRequest req, HttpServletResponse res) throws IOException{
		//���� �ļ��ϴ�����
		HashMap<String, Object> map = CommonsUtil.uploadFile(req);
		
		//����map ����
		System.out.println(""+map.get("useImg"));
		System.out.println(""+map.get("userNickName"));
		System.out.println(""+map.get("userAge"));
		res.sendRedirect("../commonsFile.jsp");
	}
	/**
	 * ������ʾ �ļ�����v
	 * @param req
	 * @param res
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void showCommonFileList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//�ϴ��ļ�Ŀ¼
		String uploadPath = this.getServletContext().getRealPath("/upload");
		//���� ���� ����ļ�����
		/*Map<String, String> fileNameMap = new HashMap<String, String>();*/
		List<String> list = new ArrayList<String>();
 		//����·������ �ļ�
		File file =	new File(uploadPath);
		//���÷���
		this.listfile(file, list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("../commonsFile.jsp").forward(req, res);
	}
	
	//���� �ļ����е��ļ� 
	public  void listfile(File file,List<String> list){
		//�ж� �Ƿ� ��һ���ļ� Ŀ¼
		if(!file.isFile()){
			//ȡ���ļ��б������ݹ鷽ʽ
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
	 * ͼƬ����
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	public void downloadFile(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//��ȡ�����ļ�����
		String fileName = req.getParameter("fileName");
		fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
		//ȷ�����ص�Ŀ¼�ļ���
		String fileSavePath = this.getServletContext().getRealPath("/upload");
		//ƴ�����ص��ļ�·��
		File file = new File(fileSavePath+"\\"+fileName);
		
		if(!file.exists()){
			req.setAttribute("message", "���ص��ļ�������....");
			req.getRequestDispatcher("../commonsFile.jsp").forward(req, res);
			return;
		}
		//����ļ����� ������
		res.setHeader("content-disposition","attachment; filename="+URLEncoder.encode(fileName, "utf-8"));
		//���ļ����ķ�ʽ �������ز���
		FileInputStream in = new FileInputStream(file);
		OutputStream out =	res.getOutputStream();
		byte buffer[] = new byte[1024];
		int lne = 0;
		//ѭ����ȡ
		while((lne=in.read(buffer))>0){
			out.write(buffer, 0, lne);
		}
		in.close();
		out.close();
	}
	
}

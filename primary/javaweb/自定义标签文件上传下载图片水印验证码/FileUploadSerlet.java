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
	 * �ļ��ϴ�����
	 * @param req
	 * @param res
	 * @throws ServletException 
	 */
	public void uploadeFile(HttpServletRequest req,HttpServletResponse res) throws Exception{
		
		//ȷ���ļ��ϴ�λ��
		String file = req.getSession().getServletContext().getRealPath("uploadFile");
		
		//ȷ���Ƿ� ���ڸ��ļ� 
		File fi =	new File(file);
		
		if(!fi.exists()){
			fi.mkdir();
		}
		//��ȡ�ϴ��� �����ļ�
		SmartUpload su = new SmartUpload();
		//��ʼ�� �ϴ���Ϣ
		su.initialize(this.getServletConfig(),req,res);
		
		//�����ϴ� �ļ�����������
		su.setMaxFileSize(5000000);//�ֽڵ�λ
		su.setAllowedFilesList("txt,jpg,png,ico,docx");//�����ϴ�������
		su.setDeniedFilesList("html,exe");
		
		
		//�ϴ�
		su.upload();
		
		//��ȡ���� ���ܹ�ֱ�� ��ȡreq����
		/*String userNickName = req.getParameter("userNickName");
		String userAge = req.getParameter("userAge");*/
		//ͨ�� SmartUpload ��ȡָ��Ҫ���������
		String userNickName =  su.getRequest().getParameter("userNickName");
		String userAge =  su.getRequest().getParameter("userAge");
		
		System.out.println("===>"+userNickName+"==="+userAge);
		
		
		//��������
		SmartFiles sf = su.getFiles();
		
		for (int i = 0; i < sf.getCount(); i++) {
			//String fileName = sf.getFile(i).getFieldName();
			String fileName = sf.getFile(i).getFileName();
			//su.save("/uploadFile/"+fileName);
			su.getFiles().getFile(i).saveAs("/uploadFile/"+fileName);
		}
		//��ת���ļ�ҳ��
		res.sendRedirect("../index.jsp");
	}
	/**
	 * ��ʾ�ļ��б�
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public String showFileUrl(HttpServletRequest req,HttpServletResponse res) throws Exception{
		
		//��ȡ�ļ����е��ļ�
		String filePath = req.getServletContext().getRealPath("/uploadFile");
		
		//ͨ��·�� ��ȡ �ļ���
		File upName = new File(filePath);
		//��ȡ��Ӧ�� �ļ��б�
		File[] namefs = upName.listFiles();
		
		ArrayList<String> list = new ArrayList<String>();
		//��������
		for (File fi : namefs) {
			//�ж��Ƿ� ���ļ�  �ļ��� ......
			list.add(fi.getName());
		}
		req.setAttribute("list", list);
		return "../index.jsp";
	}
	
	/**
	 * �ļ����ز���
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	public  void downloadFile(HttpServletRequest req,HttpServletResponse res) throws Exception{
		//ͼƬ��ŵ�λ��
		String filePath = req.getServletContext().getRealPath("/uploadFile");
		
		//��ȡ·��
		String fileName = req.getParameter("downFileName");
		
		//�������� get��ʽ
		fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
		
		//���� ����
		SmartUpload  smp = new SmartUpload();
		//��ʼ������
		smp.initialize(this.getServletConfig(),req,res);
		//���ļ�����ʽ ������������
		smp.setContentDisposition(null);
		
		System.out.println(filePath+"/"+fileName);
		smp.downloadFile(filePath+"/"+fileName);
	}
	
	
	
	
	
	
	
}

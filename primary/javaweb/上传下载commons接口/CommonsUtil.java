package com.jjfk.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class CommonsUtil {
	//���幫�õĲ���
	private static final String UPLOAD_DIR = "upload";
	//�����ļ���С
	private static final int MEMORY_THR =1024*1024*3;//3M
	private static final int MAX_FILE_SIZE=1024*1024*200;//200M
	private static final int MAX_REQ_SIZE=1024*1024*1000;//1000M
	/**
	 * �ϴ��ļ� ��������
	 * @param request
	 * @return
	 */
	public static HashMap<String, Object>  uploadFile(HttpServletRequest request){
		//�����ļ�  ͬʱ ����form���е���������
		//�����ļ��ϴ���Ϣ
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//�����ڴ��ٽ�ֵ ������ ��Χ ���� ��ʱĿ¼��
		factory.setSizeThreshold(MEMORY_THR);
		
		//���ó�����Χ����ʱĿ¼   Java.io.tmpdir java.io.tmpdir
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		//�����ϴ��ļ�����
		upload.setFileSizeMax(MAX_FILE_SIZE);
		//�������ֵ
		upload.setSizeMax(MAX_REQ_SIZE);
		
		//�������ݱ���
		upload.setHeaderEncoding("UTF-8");
		//�������� ���� ����������
		HashMap<String, Object> map = new HashMap<String, Object>();
		//�ж� �ϴ��ļ������ͣ�ȷ���� file �ļ� ���� text����
		//ƴ��һ�� �ϴ��ļ��ı���·��: /   \/  //
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		//�ж��Ƿ����
		File uploadDir = new File(uploadPath);
		
		if(!uploadDir.exists()){
			uploadDir.mkdir();
		}
		//���� ���ݹ����Ĳ���
		try {
			List  itmes = upload.parseRequest(request);
			//���� �����ύ������
			Iterator<FileItem> iter = itmes.iterator();
			
			while(iter.hasNext()){
				//ȡ��ÿ����Ԫ�ض���
				FileItem item =	iter.next();
				//�ж� �ļ� ���� ���ļ�
				if(item.isFormField()){
					//��ȡֵ���� �� map������
					String value = item.getString("utf-8");
					String name = item.getFieldName();
					map.put(name, value);
				}else{
					//�ļ�����
					String type = item.getFieldName();
					
					String fileName = new File(item.getName()).getName();
					//ָ�����λ��
					String filePath = uploadPath+"/"+fileName;
					File storeFile = new File(filePath);
					//����ǰ�ϴ����ļ� ���ƴ������ݿ���
					map.put(type, fileName);
					//���ļ� ���浽������������
					item.write(storeFile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
}

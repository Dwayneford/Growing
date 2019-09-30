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
	//定义公用的参数
	private static final String UPLOAD_DIR = "upload";
	//缓存文件大小
	private static final int MEMORY_THR =1024*1024*3;//3M
	private static final int MAX_FILE_SIZE=1024*1024*200;//200M
	private static final int MAX_REQ_SIZE=1024*1024*1000;//1000M
	/**
	 * 上传文件 保存数据
	 * @param request
	 * @return
	 */
	public static HashMap<String, Object>  uploadFile(HttpServletRequest request){
		//保存文件  同时 接收form表单中的其他数据
		//配置文件上传信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//配置内存临界值 ，超过 范围 存入 临时目录中
		factory.setSizeThreshold(MEMORY_THR);
		
		//设置超出范围的临时目录   Java.io.tmpdir java.io.tmpdir
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		//配置上传文件参数
		upload.setFileSizeMax(MAX_FILE_SIZE);
		//请求最大值
		upload.setSizeMax(MAX_REQ_SIZE);
		
		//处理数据编码
		upload.setHeaderEncoding("UTF-8");
		//创建对象 接收 表单其他数据
		HashMap<String, Object> map = new HashMap<String, Object>();
		//判断 上传文件的类型，确定是 file 文件 还是 text内容
		//拼接一下 上传文件的保存路径: /   \/  //
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		//判断是否存在
		File uploadDir = new File(uploadPath);
		
		if(!uploadDir.exists()){
			uploadDir.mkdir();
		}
		//解析 传递过来的参数
		try {
			List  itmes = upload.parseRequest(request);
			//遍历 请求提交的内容
			Iterator<FileItem> iter = itmes.iterator();
			
			while(iter.hasNext()){
				//取出每个表单元素对象
				FileItem item =	iter.next();
				//判断 文件 还是 非文件
				if(item.isFormField()){
					//获取值保存 到 map集合中
					String value = item.getString("utf-8");
					String name = item.getFieldName();
					map.put(name, value);
				}else{
					//文件操作
					String type = item.getFieldName();
					
					String fileName = new File(item.getName()).getName();
					//指定存放位置
					String filePath = uploadPath+"/"+fileName;
					File storeFile = new File(filePath);
					//将当前上传的文件 名称存入数据库中
					map.put(type, fileName);
					//将文件 保存到服务器磁盘中
					item.write(storeFile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
}

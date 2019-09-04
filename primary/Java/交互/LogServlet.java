package com.baidu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class LogServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		//�������봦��
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡ�����ж�ִ�к���
		String op = request.getParameter("op"); // "".equals() null.equal();
		if (("regst").equals(op)) {
			userLogin(request, response);;
		}
		
		
	}

	/**
	 * �û���¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ղ��� �ж��û��Ƿ����
		String logName = request.getParameter("userName");
		String logPwd = request.getParameter("userPwd");
		
		//����������Ϣ�ļ���
		Map<String, Object> retmap = new HashMap<String, Object>();
		
		//�ж��Ƿ����
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("uname", "admin");
		map1.put("upwd", "123456");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("uname", "��С��");
		map2.put("upwd", "123456");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("uname", "����Ӣ");
		map3.put("upwd", "123456");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		//��¼ʧ�� ��Ϣ
		retmap.put("message", "�û����������");
		retmap.put("retStr", "error");
		//����
		for (Map<String, Object> map : list) {
			// �Ƚ�
			if(map.get("uname").equals(logName)&&map.get("upwd").equals(logPwd)){
				retmap.put("message", "��¼�ɹ�����");
				retmap.put("retStr", "success");
				break;
			}
		}
		
		
		PrintWriter out = response.getWriter();
		
		//��mpa����ת�� Ϊ json��ʽ���ݡ�
		Gson gs = new Gson();
		String jsonStr = gs.toJson(retmap);
		
		out.println(jsonStr);
		out.flush();
		out.close();
	}
	
}

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
		//中文乱码处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取类型判断执行函数
		String op = request.getParameter("op"); // "".equals() null.equal();
		if (("regst").equals(op)) {
			userLogin(request, response);;
		}
		
		
	}

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数 判断用户是否存在
		String logName = request.getParameter("userName");
		String logPwd = request.getParameter("userPwd");
		
		//包含返回信息的集合
		Map<String, Object> retmap = new HashMap<String, Object>();
		
		//判断是否存在
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("uname", "admin");
		map1.put("upwd", "123456");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("uname", "江小白");
		map2.put("upwd", "123456");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("uname", "刘若英");
		map3.put("upwd", "123456");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		//登录失败 信息
		retmap.put("message", "用户名密码错误");
		retmap.put("retStr", "error");
		//遍历
		for (Map<String, Object> map : list) {
			// 比较
			if(map.get("uname").equals(logName)&&map.get("upwd").equals(logPwd)){
				retmap.put("message", "登录成功！！");
				retmap.put("retStr", "success");
				break;
			}
		}
		
		
		PrintWriter out = response.getWriter();
		
		//将mpa集合转换 为 json格式数据、
		Gson gs = new Gson();
		String jsonStr = gs.toJson(retmap);
		
		out.println(jsonStr);
		out.flush();
		out.close();
	}
	
}

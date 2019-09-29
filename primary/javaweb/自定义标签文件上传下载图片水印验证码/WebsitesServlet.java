package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.IWebsites;
import com.dao.impl.WebsitesImpl;
import com.entity.Websites;
import com.google.gson.Gson;

//处理来自网页的请求

//Server Applet 服务连接程序
public class WebsitesServlet extends HttpServlet{

	//get请求的处理方法
	public void doGet(HttpServletRequest requset,HttpServletResponse response)throws ServletException,IOException{
		doPost(requset, response);
	}
	
	//post请求的处理方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//编码格式设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//通过参数判断执行何方法
		String op = request.getParameter("op");
		if (("queryWebsitesList").equals(op)) {
			//调用列表查询方法
			queryWebsitesList(request, response);
		}else if (("save").equals(op)) {
			//调用修改添加方法
			save(request, response);
		}else if (("queryWebsiteByName").equals(op)) {
			queryWebsiteByName(request, response);
		}else if (("update").equals(op)) {
			update(request, response);
		}else if (("delete").equals(op)) {
			delete(request, response);
		}else if (("queryWebsiteByNamelayout").equals(op)) {
			queryWebsiteByNamelayout(request, response);
		}else if (("query").equals(op)) {
			query(request, response);
		}
		

				
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		//调用dao层方法获取列表数据
		WebsitesImpl iWebsites=new WebsitesImpl();
		//返回的数据
		int web_id = Integer.parseInt(request.getParameter("id"));//获得传递的参数id

		boolean bool = iWebsites.delete(web_id);
		
	}

	//通过name查询对象    		@param request,@param response
	public void queryWebsiteByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//调用dao层方法获取列表数据
		WebsitesImpl iWebsites=new WebsitesImpl();
		//返回的数据
		String websiteName = request.getParameter("name");
		Websites wsEnt = iWebsites.queryWebsite(websiteName);
		
		//将数据返回到页面上，转换为json格式数据gson fastjson
		//[{},{},{}]
		Gson gs =new Gson();
		String jsonWebsites = gs.toJson(wsEnt);
		System.out.println("wsEnt===>"+wsEnt);
		//向客户端输出
		PrintWriter out = response.getWriter();
		out.print(jsonWebsites);
		//刷新关闭
		out.flush();
		out.close();
			
	}
	//添加方法
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受参数
//		String web_id = request.getParameter("id");
		String web_name = request.getParameter("name");
		String web_url = request.getParameter("url");
		String web_alexa = request.getParameter("alexa");
		String web_country = request.getParameter("country");
		
		
		//封装到ws对象中
		Websites wsEnt = new Websites(
				//(("").equals(web_id)||web_id==null) ? 0 : Integer.parseInt(web_id) ,
				web_name, 
				web_url, 
				web_alexa, 
				web_country);
		
//		System.out.println("sdf"+wsEnt.toString());
		//调用dao层方获取列表数据
		IWebsites iWebsites = new WebsitesImpl();
		boolean bool = iWebsites.save(wsEnt);
		String retMessage = "";
		if (bool) {
			retMessage = "success，成功！！";			
		}else {
			retMessage = "error错误！";
		}
		//向客户端输出内容
		PrintWriter out = response.getWriter();
		out.print(retMessage);
		//刷新关闭
		out.flush();
		out.close();				
	}
	
	//修改方法
		public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//接受参数
			int web_id = Integer.parseInt(request.getParameter("id"));
			String web_name = request.getParameter("name");
			String web_url = request.getParameter("url");
			String web_alexa = request.getParameter("alexa");
			String web_country = request.getParameter("country");
			//封装到ws对象中
//			Websites wsEnt = new Websites(
//				//	(("").equals(web_id)||web_id==null) ? 0 : Integer.parseInt(web_id) ,
//					web_name, 
//					web_url, 
//					web_alexa, 
//					web_country);
			Websites wsEnt = new Websites(web_id,web_name, web_url, web_alexa, web_country);
			//调用dao层方获取列表数据
			WebsitesImpl iWebsites = new WebsitesImpl();
			boolean bool = iWebsites.Update(wsEnt);
			String retMessage = "";
			if (bool) {
				retMessage = "success，成功！！";			
			}else {
				retMessage = "error错误！";
			}
			//向客户端输出内容
			PrintWriter out = response.getWriter();
			out.print(retMessage);
			//刷新关闭
			out.flush();
			out.close();				
		}
	
	public void queryWebsitesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//调用dao层方法获取列表数据
		IWebsites iWebsites = new WebsitesImpl();
		//返回的数据
		List<Websites> retList = iWebsites.queryWebsites();
		
		//拼接成 layUI需要的格式数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 200);
		map.put("data", retList);
		
		//将数据返回到页面上：转换为json格式数据gson fastjson
		//[{},{},{}]
				Gson gs =new Gson();
				String jsonWebsites = gs.toJson(map);
//				String jsonWebsites = gs.toJson(retList);
				System.out.println("wsEnt===>"+jsonWebsites);
				//向客户端输出
				PrintWriter out = response.getWriter();
				out.print(jsonWebsites);
				//刷新关闭
				out.flush();
				out.close();
		
	} 
	//弹出层后台取数据到框内，用于编辑
	public void queryWebsiteByNamelayout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//调用dao层方法获取列表数据
		WebsitesImpl iWebsites=new WebsitesImpl();
		//返回的数据
		String websiteName = request.getParameter("name");
		Websites wsEnt = iWebsites.queryWebsite(websiteName);
		
		//存入作用域	
		request.setAttribute("wsEnt", wsEnt);
		//响应到页面
		request.getRequestDispatcher("editwebsiteinfo.jsp").forward(request, response);

		
		
	}
	//用于查询弹出层
	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//调用dao层方法获取列表数据
		WebsitesImpl iWebsites=new WebsitesImpl();
		//返回的数据
		String websiteName = request.getParameter("name");
		Websites wsEnt = iWebsites.queryWebsite(websiteName);
		
		//存入作用域	
//		request.setAttribute("wsEnt", wsEnt);
		//响应到页面
//		request.getRequestDispatcher("querywebsiteresult.jsp").forward(request, response);
//		request.getRequestDispatcher("editwebsiteinfo.jsp").forward(request, response);

		//将数据返回到页面上，转换为json格式数据gson fastjson
				//[{},{},{}]
				Gson gs =new Gson();
				String jsonWebsites = gs.toJson(wsEnt);
				System.out.println("wsEnt===>"+wsEnt);
				//向客户端输出
				PrintWriter out = response.getWriter();
				out.print(jsonWebsites);
				//刷新关闭
				out.flush();
				out.close();
		
	}
	
}

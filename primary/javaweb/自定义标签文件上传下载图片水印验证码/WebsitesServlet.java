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

//����������ҳ������

//Server Applet �������ӳ���
public class WebsitesServlet extends HttpServlet{

	//get����Ĵ�����
	public void doGet(HttpServletRequest requset,HttpServletResponse response)throws ServletException,IOException{
		doPost(requset, response);
	}
	
	//post����Ĵ�����
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//�����ʽ����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//ͨ�������ж�ִ�кη���
		String op = request.getParameter("op");
		if (("queryWebsitesList").equals(op)) {
			//�����б��ѯ����
			queryWebsitesList(request, response);
		}else if (("save").equals(op)) {
			//�����޸���ӷ���
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
		//����dao�㷽����ȡ�б�����
		WebsitesImpl iWebsites=new WebsitesImpl();
		//���ص�����
		int web_id = Integer.parseInt(request.getParameter("id"));//��ô��ݵĲ���id

		boolean bool = iWebsites.delete(web_id);
		
	}

	//ͨ��name��ѯ����    		@param request,@param response
	public void queryWebsiteByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//����dao�㷽����ȡ�б�����
		WebsitesImpl iWebsites=new WebsitesImpl();
		//���ص�����
		String websiteName = request.getParameter("name");
		Websites wsEnt = iWebsites.queryWebsite(websiteName);
		
		//�����ݷ��ص�ҳ���ϣ�ת��Ϊjson��ʽ����gson fastjson
		//[{},{},{}]
		Gson gs =new Gson();
		String jsonWebsites = gs.toJson(wsEnt);
		System.out.println("wsEnt===>"+wsEnt);
		//��ͻ������
		PrintWriter out = response.getWriter();
		out.print(jsonWebsites);
		//ˢ�¹ر�
		out.flush();
		out.close();
			
	}
	//��ӷ���
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ܲ���
//		String web_id = request.getParameter("id");
		String web_name = request.getParameter("name");
		String web_url = request.getParameter("url");
		String web_alexa = request.getParameter("alexa");
		String web_country = request.getParameter("country");
		
		
		//��װ��ws������
		Websites wsEnt = new Websites(
				//(("").equals(web_id)||web_id==null) ? 0 : Integer.parseInt(web_id) ,
				web_name, 
				web_url, 
				web_alexa, 
				web_country);
		
//		System.out.println("sdf"+wsEnt.toString());
		//����dao�㷽��ȡ�б�����
		IWebsites iWebsites = new WebsitesImpl();
		boolean bool = iWebsites.save(wsEnt);
		String retMessage = "";
		if (bool) {
			retMessage = "success���ɹ�����";			
		}else {
			retMessage = "error����";
		}
		//��ͻ����������
		PrintWriter out = response.getWriter();
		out.print(retMessage);
		//ˢ�¹ر�
		out.flush();
		out.close();				
	}
	
	//�޸ķ���
		public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//���ܲ���
			int web_id = Integer.parseInt(request.getParameter("id"));
			String web_name = request.getParameter("name");
			String web_url = request.getParameter("url");
			String web_alexa = request.getParameter("alexa");
			String web_country = request.getParameter("country");
			//��װ��ws������
//			Websites wsEnt = new Websites(
//				//	(("").equals(web_id)||web_id==null) ? 0 : Integer.parseInt(web_id) ,
//					web_name, 
//					web_url, 
//					web_alexa, 
//					web_country);
			Websites wsEnt = new Websites(web_id,web_name, web_url, web_alexa, web_country);
			//����dao�㷽��ȡ�б�����
			WebsitesImpl iWebsites = new WebsitesImpl();
			boolean bool = iWebsites.Update(wsEnt);
			String retMessage = "";
			if (bool) {
				retMessage = "success���ɹ�����";			
			}else {
				retMessage = "error����";
			}
			//��ͻ����������
			PrintWriter out = response.getWriter();
			out.print(retMessage);
			//ˢ�¹ر�
			out.flush();
			out.close();				
		}
	
	public void queryWebsitesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//����dao�㷽����ȡ�б�����
		IWebsites iWebsites = new WebsitesImpl();
		//���ص�����
		List<Websites> retList = iWebsites.queryWebsites();
		
		//ƴ�ӳ� layUI��Ҫ�ĸ�ʽ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 200);
		map.put("data", retList);
		
		//�����ݷ��ص�ҳ���ϣ�ת��Ϊjson��ʽ����gson fastjson
		//[{},{},{}]
				Gson gs =new Gson();
				String jsonWebsites = gs.toJson(map);
//				String jsonWebsites = gs.toJson(retList);
				System.out.println("wsEnt===>"+jsonWebsites);
				//��ͻ������
				PrintWriter out = response.getWriter();
				out.print(jsonWebsites);
				//ˢ�¹ر�
				out.flush();
				out.close();
		
	} 
	//�������̨ȡ���ݵ����ڣ����ڱ༭
	public void queryWebsiteByNamelayout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//����dao�㷽����ȡ�б�����
		WebsitesImpl iWebsites=new WebsitesImpl();
		//���ص�����
		String websiteName = request.getParameter("name");
		Websites wsEnt = iWebsites.queryWebsite(websiteName);
		
		//����������	
		request.setAttribute("wsEnt", wsEnt);
		//��Ӧ��ҳ��
		request.getRequestDispatcher("editwebsiteinfo.jsp").forward(request, response);

		
		
	}
	//���ڲ�ѯ������
	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//����dao�㷽����ȡ�б�����
		WebsitesImpl iWebsites=new WebsitesImpl();
		//���ص�����
		String websiteName = request.getParameter("name");
		Websites wsEnt = iWebsites.queryWebsite(websiteName);
		
		//����������	
//		request.setAttribute("wsEnt", wsEnt);
		//��Ӧ��ҳ��
//		request.getRequestDispatcher("querywebsiteresult.jsp").forward(request, response);
//		request.getRequestDispatcher("editwebsiteinfo.jsp").forward(request, response);

		//�����ݷ��ص�ҳ���ϣ�ת��Ϊjson��ʽ����gson fastjson
				//[{},{},{}]
				Gson gs =new Gson();
				String jsonWebsites = gs.toJson(wsEnt);
				System.out.println("wsEnt===>"+wsEnt);
				//��ͻ������
				PrintWriter out = response.getWriter();
				out.print(jsonWebsites);
				//ˢ�¹ر�
				out.flush();
				out.close();
		
	}
	
}

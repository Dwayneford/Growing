package com.baidu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.dao.IGoods;
import com.baidu.dao.impl.GoodsImpl;
import com.baidu.entity.Goods_table;
import com.google.gson.Gson;

public class GoodsSerevlet extends HttpServlet {
	/**
	 * get���� �Ĵ��� ����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * post ����Ĵ��� ����
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//�����ʽ����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//'Access-Control-Allow-Origin'
		//response.setHeader("Access-Control-Allow-Origin", "*");//������� ��Դ http://192.168.98.254
		
		//ͨ������ �ж� ִ��ָ���� ����
		//String op = request.getParameter("op");
		
		String op = "goodsList";
		if(("goodsList").equals(op)){
			//�����б��ѯ����
			queryGoodsList(request, response);
		}else if(("saveOrUpdate").equals(op)){
			//�����޸� ��ӷ���
			saveOrUpdateI(request, response);
		}else if(("querGoodsById").equals(op)){
			querGoodsById(request, response);
		}
		
	}
	/**
	 * ͨ��id ��ѯ ʵ����� 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void querGoodsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� dao�� ������ȡ ���б�����
		IGoods igoods = new GoodsImpl();
		//���ص�����
		String goodId = request.getParameter("goodId");
		Goods_table gdEnt = igoods.getGoodsInfo(Integer.parseInt(goodId));
		
		//������ ���ص�ҳ���� ��ת��Ϊjson��ʽ���� gson fastjson
		// [{},{},{}]
		Gson gs = new Gson();
		String jsonGoods = gs.toJson(gdEnt);
		System.out.println("jsonGoods==>"+jsonGoods);
		//��ͻ������
		PrintWriter out = response.getWriter();
		out.print(jsonGoods);
		//ˢ�� �ر�
		out.flush();
		out.close();
	
	}
	
	
	//�޸� ��� ����
	public void saveOrUpdateI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ղ���
		String good_id = request.getParameter("good_id");
		String good_name = request.getParameter("good_name");
		String good_num = request.getParameter("good_num");
		String good_type = request.getParameter("good_type");
		String good_price = request.getParameter("good_price");
		String good_date = request.getParameter("good_date");
		String good_beg_time = request.getParameter("good_beg_time");
		// ��װ��gdEnt ������
		Goods_table gdEnt = new Goods_table(
							(("").equals(good_id)||good_id==null) ? 0 : Integer.parseInt(good_id),
							good_name,
							Integer.parseInt(good_num),
							good_type,
							(("").equals(good_price)||good_price==null) ? 0.00D : Double.parseDouble(good_price),
							good_date,
							good_beg_time);
		//���� dao�� ������ȡ ���б�����
		IGoods igoods = new GoodsImpl();
		boolean bool = igoods.saveOrUpdate(gdEnt);
		String retMessage = "";
		if(bool){
			retMessage = "success";
		}else{
			retMessage = "error";
		}
		//��ͻ��� ��� ����
		PrintWriter out = response.getWriter();
		out.print(retMessage);
		//ˢ�� �ر�
		out.flush();
		out.close();
	}
	/**
	 * ��ѯ �����б�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryGoodsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� dao�� ������ȡ ���б�����
		IGoods igoods = new GoodsImpl();
		//���ص�����
		List<Goods_table> retList = igoods.queryGoods(null, 0.00);
		
		//������ ���ص�ҳ���� ��ת��Ϊjson��ʽ���� gson fastjson
		// [{},{},{}]
		Gson gs = new Gson();
		String jsonGoods = gs.toJson(retList);
		
		//String callback = request.getParameter("callback");
		
		String callback = request.getParameter("myFunction");
		//���ַ����� ���ص� �������ƽ���ƴ��
		jsonGoods = callback+"("+jsonGoods+")";
		System.out.println("jsonGoods==>"+jsonGoods);
		//��ͻ������
		PrintWriter out = response.getWriter();
		out.print(jsonGoods);
		//ˢ�� �ر�
		out.flush();
		out.close();
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	

}

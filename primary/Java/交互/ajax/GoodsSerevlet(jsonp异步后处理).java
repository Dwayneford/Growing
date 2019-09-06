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
	 * get请求 的处理 方法
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * post 请求的处理 方法
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//编码格式设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//'Access-Control-Allow-Origin'
		//response.setHeader("Access-Control-Allow-Origin", "*");//允许访问 来源 http://192.168.98.254
		
		//通过参数 判断 执行指定的 方法
		//String op = request.getParameter("op");
		
		String op = "goodsList";
		if(("goodsList").equals(op)){
			//调用列表查询方法
			queryGoodsList(request, response);
		}else if(("saveOrUpdate").equals(op)){
			//调用修改 添加方法
			saveOrUpdateI(request, response);
		}else if(("querGoodsById").equals(op)){
			querGoodsById(request, response);
		}
		
	}
	/**
	 * 通过id 查询 实体对象 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void querGoodsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用 dao层 方法获取 ，列表数据
		IGoods igoods = new GoodsImpl();
		//返回的数据
		String goodId = request.getParameter("goodId");
		Goods_table gdEnt = igoods.getGoodsInfo(Integer.parseInt(goodId));
		
		//将数据 返回到页面上 ：转换为json格式数据 gson fastjson
		// [{},{},{}]
		Gson gs = new Gson();
		String jsonGoods = gs.toJson(gdEnt);
		System.out.println("jsonGoods==>"+jsonGoods);
		//向客户端输出
		PrintWriter out = response.getWriter();
		out.print(jsonGoods);
		//刷新 关闭
		out.flush();
		out.close();
	
	}
	
	
	//修改 添加 方法
	public void saveOrUpdateI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String good_id = request.getParameter("good_id");
		String good_name = request.getParameter("good_name");
		String good_num = request.getParameter("good_num");
		String good_type = request.getParameter("good_type");
		String good_price = request.getParameter("good_price");
		String good_date = request.getParameter("good_date");
		String good_beg_time = request.getParameter("good_beg_time");
		// 封装到gdEnt 对象中
		Goods_table gdEnt = new Goods_table(
							(("").equals(good_id)||good_id==null) ? 0 : Integer.parseInt(good_id),
							good_name,
							Integer.parseInt(good_num),
							good_type,
							(("").equals(good_price)||good_price==null) ? 0.00D : Double.parseDouble(good_price),
							good_date,
							good_beg_time);
		//调用 dao层 方法获取 ，列表数据
		IGoods igoods = new GoodsImpl();
		boolean bool = igoods.saveOrUpdate(gdEnt);
		String retMessage = "";
		if(bool){
			retMessage = "success";
		}else{
			retMessage = "error";
		}
		//向客户端 输出 内容
		PrintWriter out = response.getWriter();
		out.print(retMessage);
		//刷新 关闭
		out.flush();
		out.close();
	}
	/**
	 * 查询 数据列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryGoodsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用 dao层 方法获取 ，列表数据
		IGoods igoods = new GoodsImpl();
		//返回的数据
		List<Goods_table> retList = igoods.queryGoods(null, 0.00);
		
		//将数据 返回到页面上 ：转换为json格式数据 gson fastjson
		// [{},{},{}]
		Gson gs = new Gson();
		String jsonGoods = gs.toJson(retList);
		
		//String callback = request.getParameter("callback");
		
		String callback = request.getParameter("myFunction");
		//将字符串和 返回的 方法名称进行拼接
		jsonGoods = callback+"("+jsonGoods+")";
		System.out.println("jsonGoods==>"+jsonGoods);
		//向客户端输出
		PrintWriter out = response.getWriter();
		out.print(jsonGoods);
		//刷新 关闭
		out.flush();
		out.close();
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	

}

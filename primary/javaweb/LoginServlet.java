package com.dkt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	//实例化
	public LoginServlet() {
		super();
	}
	//初始化
	public void init() throws ServletException {
		
	}
	
	//服务 中的两个具体请求 执行方法 (service() 指派指定请求类型方法 dopost doget doput......)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//userLogin
		//获取请求的方法参数
		String choseMeth = request.getParameter("op");
		
		if(("userLogin").equals(choseMeth)){
			//调用 登录 方法
			userLogin(request, response);
		}
	
		
	}
	/**
	 * 登录方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取登录 用户名 和密码
		String loginname = request.getParameter("loginname");
		String nloginpwd= request.getParameter("nloginpwd");
		
		//查询 数据库中 是否有该条数据
		
		if(("admin").equals(loginname)&&("123456").equals(nloginpwd)){
			//跳转到主页
			request.setAttribute("lonsuc", "恭喜 登录成功！！！");
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}else{
			//继续在登页面上
			response.sendRedirect("../login.jsp");
		}
	}
	
	
	
	
	
	
	//服务结束后的销毁方法
	public void destroy() {
		super.destroy(); 
	}

	

}

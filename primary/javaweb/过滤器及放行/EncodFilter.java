package com.jjfk.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjfk.entity.Tstudent;

public class EncodFilter implements Filter{
	private String encode;
	@Override
	public void destroy() {
		//销毁业务 逻辑处理
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 过滤 器的业务 逻辑处理
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		
		//判断用户是否 登录 如果登录 放行 否则提示 请求先登录系统
		//转换 获取 session
		HttpServletRequest req =(HttpServletRequest)request;
		HttpServletResponse res =(HttpServletResponse)response;
		
		
		
		//对于特定 路径 放行
		String uri = req.getRequestURI();
		StringBuffer url = req.getRequestURL();
		//过滤器将直接放行css样式以及图片资源文件
		if (url.indexOf(".jpg") > 0 || url.indexOf(".png") > 0 ||url.indexOf(".gif") > 0 || url.indexOf(".css") > 0 || uri.indexOf("js") > 0) {
			chain.doFilter(request, response);
		}
		
		if(uri.contains("/LayUIDemo/login.jsp")){
			chain.doFilter(request, response);
			return;
		}
		
		String method = req.getParameter("method");
		if(("userLong").equals(method)){
			chain.doFilter(request, response);
			return;
		}
		//System.out.println(uri);
		Tstudent logUser =(Tstudent)req.getSession().getAttribute("logUser");
		//判断
		if(logUser.getStu_name()!=null&&("").equals(logUser.getStu_name())){
			//放行
			chain.doFilter(req, res);
		}else{
			//跳转到错误界面
			request.setAttribute("errorInfo", "请先登录 在访问....");
			request.getRequestDispatcher("../login.jsp");
		}
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 环境配置 参数设置.....
		encode=filterConfig.getInitParameter("encoding");
	}
	
}

package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 公共 的servlet 类
 * @author direct
 */
public class BaseServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//确定请求的子类 只能是 BaseServlet 上限类
		Class<? extends BaseServlet> requestClass = this.getClass();
		//设置公用 属性 方法、
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//.....
		
		//获取 被请求类的 方法名称
		String methodName = req.getParameter("method");
		try {
			Method method = requestClass.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//执行该方法:执行 子类中 对应的名称 方法
			Object invoke = method.invoke(this, req, res);
			
			//界面跳转
			if(invoke!=null){
				req.getRequestDispatcher((String)invoke).forward(req, res);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

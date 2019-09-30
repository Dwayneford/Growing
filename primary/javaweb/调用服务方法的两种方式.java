package com.summary;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

public class Two_way_call_method {

}
/**
调用服务内的两种方法
方法一:用过dopost调用
servlet类:
此类需继承HttpServlet
response.setContentType("text/html");
		//编码格式设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//通过参数判断执行何方法
		String op = request.getParameter("op");
		if (("updateImg").equals(op)) {
			//调用添加水印方法
			updateImg(request, response);
		}else if (("getCode").equals(op)) {
			//调用获取验证码方法
			getCode(request, response);
		}
	updateImg(){}
	getCode(){}
配置文件:
  <servlet>
    <servlet-name>ChangeImg</servlet-name>
    <servlet-class>com.servlet.ChangeImg</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ChangeImg</servlet-name>
    <url-pattern>/servlet/ChangeImg</url-pattern>
  </servlet-mapping>
前台:
servlet/ChangeImg?op=getCode

方法二:创建公共类:BaseServlet ex HttpServlet
@Override//重写service方法
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
ChangeImg_EX_BaseServlet extends BaseServlet类方法:
	updateImg(){}
	getCode(){}
配置文件:
  <servlet>
    <servlet-name>ChangeImg_EX_BaseServlet</servlet-name>
    <servlet-class>com.servlet.ChangeImg_EX_BaseServlet</servlet-class>
  </servlet>
    <servlet-mapping>
    <servlet-name>ChangeImg_EX_BaseServlet</servlet-name>
    <url-pattern>/servlet/ChangeImg_EX_BaseServlet</url-pattern>
  </servlet-mapping>
前台:servlet/ChangeImg_EX_BaseServlet?method=getCode


*/
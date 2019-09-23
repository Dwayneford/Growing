package com.baidu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    public  String user_con;
	/**
		构造函数
	*/
	public LoginServlet() {
		super();
	}
	/**
	 * 服务结束 销毁 servlet
	*/
	public void destroy() {
		super.destroy(); 
	}

	/**
	 * 处理get请求方法
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
		 处理post请求方法
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//编码格式设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//
		String  mehodName = request.getParameter("op");
		if(("login").equals(mehodName)){
			remberLogin(request, response);
		}

	}
	/**
	 * 记住密码 登录方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void remberLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取 方法的参数
		String login_name=request.getParameter("login_name");
		String password=request.getParameter("password");
		
		String isLogin=request.getParameter("isLogin");
		
		
		//查询数据库中是否 有该对象，将对象信息 存入 session中
		
		HttpSession session = request.getSession();
		session.setAttribute("login_name", login_name);
		session.setAttribute("login_time", new Date());
		
		session.setMaxInactiveInterval(60*60);
		
		//判断 登录时 是否记住 登录信息
		if(("yes").equals(isLogin)){
			//记住用户 信息
			Cookie loginName = new Cookie("userName", login_name);
			Cookie loginPwd = new Cookie("password", password);
			
			Cookie loginType = new Cookie("isLogin", isLogin);
			
			//设置 cookie参数 有效时间， 服务器 访问路径  共享方法....
			loginName.setMaxAge(60*60*24*12);
			loginPwd.setMaxAge(60*60*24*12);
			loginType.setMaxAge(60*60*24*12);
			//确定 服务器的访问 路径格式
			loginName.setPath("/");
			loginPwd.setPath("/");
			loginType.setPath("/");
			//设置 跨域 共享方法
			loginName.setDomain("localhost");
			loginPwd.setDomain("localhost");
			loginType.setDomain("localhost");
			
			//其他参数 设置............
			
			//响应给 客户端
			response.addCookie(loginName);
			response.addCookie(loginPwd);
			response.addCookie(loginType);
			
		}else{
			//清除 登录信息
			
			//获取客户端的cookie 数组 对象
			Cookie[] cookies = request.getCookies();
			if(cookies!=null && cookies.length>0){
				//遍历操作
				for(int i=0; i<cookies.length;i++){
					
					if(("userName").equals(cookies[i].getName())){
						cookies[i].setMaxAge(0);
						cookies[i].setPath("/");
						//响应给客户端
						response.addCookie(cookies[i]);
					}else if(("password").equals(cookies[i].getName())){
						cookies[i].setMaxAge(0);
						cookies[i].setPath("/");
						//响应给客户端
						response.addCookie(cookies[i]);
						
					}else if(("isLogin").equals(cookies[i].getName())){
						cookies[i].setMaxAge(0);
						cookies[i].setPath("/");
						//响应给客户端
						response.addCookie(cookies[i]);
					}
				}
			}
		}
		
		//内部跳转 的方式  到指定页面中：
		request.getRequestDispatcher("../main.jsp").forward(request, response);
		
	}
	
	/**
	 * old登录方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loginOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		
				//获取用户登录信息
				String logN = request.getParameter("logName");
				String logP = request.getParameter("logPwd");
				
				//链接数据库  查询 出数据 进行比对、
				if("江小白".equals(logN)&&"123456".equals(logP)){
					
					//存入用户信息 跳转到客户端 request中，页面同用：session  服务用：application  页面作用域：pageContext
					HttpSession session = request.getSession();
					session.setAttribute("userNakme", logN);
					session.setAttribute("userPwd",logP);
					//设置session 的有效时间；
					session.setMaxInactiveInterval(60*10);
					//移除属性
					//session.removeAttribute("userPwd");
					//销毁session
					//session.invalidate();
					//跳转页面 响应方式之一：三种 内部跳转  外部跳转   数据响应
					
					//内部跳转:并且将参数 传递到 页面上
					request.getRequestDispatcher("../main.jsp").forward(request, response);
				}else{
					//登录失败 外部跳转  
					//response.sendRedirect("../index.jsp");
					request.setAttribute("errMsg", "登录的用户名/密码错误！！！");
					request.getRequestDispatcher("../index.jsp").forward(request, response);
				}
		
	}
	
	
	

	/**
	 * 初始化
	 */
	public void init() throws ServletException {
		//初始化 配置信息
	}
	/**
	 * 认识 xml文档
	 * 	作用：通过xml格式 传递数据到 服务器 或者客户端，结构简单 格式清除，更适合 开发人员对数据的 查看 信息的整理；
			格式：树形结构，必须定义为标准的 结构；
			根目录：
			子元素
			内部子元素
			元素的属性
			元素值
	 * 例如：xml格式的文件：
	 * 		<?xml version="1.0" encoding="UTF-8"?>
				<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
				  <display-name>JavaWebDemo</display-name>
				  <servlet>
				    <servlet-name>LoginServlet</servlet-name>
				    <servlet-class>com.baidu.servlet.LoginServlet</servlet-class>
				  </servlet>
				
				  <servlet-mapping>
				    <servlet-name>LoginServlet</servlet-name>
				    <url-pattern>/servlet/LoginServlet</url-pattern>
				  </servlet-mapping>
				  <welcome-file-list>
				    <welcome-file>index.html</welcome-file>
				    <welcome-file>index.htm</welcome-file>
				    <welcome-file>index.jsp</welcome-file>
				    <welcome-file>default.html</welcome-file>
				    <welcome-file>default.htm</welcome-file>
				    <welcome-file>default.jsp</welcome-file>
				  </welcome-file-list>
				</web-app>
	 * 
	 * 标准的xml格式文档：
	 * 	根目录下的子元素 是有规律的；
	 * 		<?xml version="1.0" encoding="UTF-8"?>
	 * 			<root>
	 * 				<studInfo id="10" name="stu_10">
	 * 					<stuId>1001</stuId>
	 * 					<stuName>刘德华</stuName>	
					    <stuSex>男</stuSex>	
					    <stuAge>30</stuAge>	
					    <booksList>
					    	<bookInfo>
					    		<bookId>102</bookId>
					    		<bookName>三国演义</bookName>
					    		<bookPrice>88.88</bookPrice>
					    		<bookDate>2011-10-8</bookDate>
					    	</bookInfo>
					    	<bookInfo>
					    		<bookId>102</bookId>
					    		<bookName>三国演义</bookName>
					    		<bookPrice>88.88</bookPrice>
					    		<bookDate>2011-10-8</bookDate>
					    	</bookInfo>
					    	<bookInfo>
					    		<bookId>102</bookId>
					    		<bookName>三国演义</bookName>
					    		<bookPrice>88.88</bookPrice>
					    		<bookDate>2011-10-8</bookDate>
					    	</bookInfo>
					    </booksList>
	 * 				</studInfo>
	 * 				<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>刘德华</stuName>	
					    <stuSex>男</stuSex>	
					    <stuAge>30</stuAge>	
					    <booksList>
					    	
					    </booksList>
	 * 				</studInfo>
	 * 				<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>刘德华</stuName>	
					    <stuSex>男</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 *			 <studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>刘德华</stuName>	
					    <stuSex>男</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>刘德华</stuName>	
					    <stuSex>男</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>刘德华</stuName>	
					    <stuSex>男</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>刘德华</stuName>	
					    <stuSex>男</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			</root>
	 * 
	 * 	二章： WEB开发基础：
	 * 		1. web 万维网 WWW ：World wide Web;
	 * 		2. web 开发的三大核心
	 * 			html 网页， url 定位，  http 传输协议；		
	 * 			
	 * 		 页面：动态 静态
	 * 			html +css  jsp  asp(VB)  ado.net(C#) php 电子商务
	 * 		
	 * 			
	 * 		定位：
	 * 			url:统一资源定位器，用来定位web服务中的某个资源；
	 * 			uri:通用资源标识符，不仅可以定位某个资源，还可以确定 资源的具体位置(url是uri的组成部分之一);
	 * 		
	 * 		请求提交方式：get post  put  delete  head  options 六种提交方式
	 * 			get：传输速度 快，不安全 数据 会在 url中显示，传输数据量小 1024字节
	 * 			post：速度慢 相对比较安全，将数据 已打包的形式传输 传输数据量大 一般为4M;
	 *			
	 *		3. B/S 和 C/S
	 *		 	B/S: 浏览器 服务器： 易于维护 成本低  分布式 
	 *			C/S： 客户端 服务器：维护困难 处理数据量大 交换性强 
	 *
	 *		4.http协议 /https   fpt/ 
	 * 			俗称：超文本传输 协议
	 * 			特点：无状态 -- 不能记住 客户端请求的数据
	 * 		
	 * 		5.状态码：
	 * 			200 ：操作成功
	 * 			301：资源绑定到其他URL
	 * 			404：请求url错误
	 * 			400：请求的服务器参数异常
	 * 			415：请求服务内部错误
	 * 			500：服务器逻辑错误
	 * 			...............
	 * 		自定义状态码：
	 * 			NO8858885569_599:这是一个什么错误........
	 * 
	 * 		6.Web服务器：tomcate jBoss webLogic Oracle.......
	 * 			
	 * 第三章 serlert:
	 * 		一 什么是 servlet？
	 * 			是有Java代码编写的 Java源文件，运行在web服务器中，用于接收用户请求，并且调用javaBean业务逻辑 获取响应得结果，响应给请求；
	 * 			
	 * 		二 生命周期
	 * 			五个阶段 3方法：
	 * 			加载实例化：执行构造函数
	 * 			初始化：执行 inint() 方法
	 * 			服务：执行 service(),根据请求类型 调用 get post  updata delete .....
	 *  		销毁：执行 destory()方法。服务停止 执行该方法
	 *  		不可用状态：系统自动回收，造成内存不可用状态；
	 * 			
	 * 			服务的加载顺序：
	 * 			第一次：执行顺序：请求 ===》加载实例化===》初始化===》服务===》响应===》===》
	 * 			第二次：执行顺序：请求 ===》服务===》响应===》===》
	 * 
	 * 			最终====》销毁

	 *
	 * 		三如何 使用servlet?
	 * 						
	 *     	Jsp动态页面：
	 *     		什么是 jsp?
	 *     			jsp:(java Server page) 运行在服务器上
	 *     				jsp中的业务逻辑代码：
	 *     					<% Date nowTime = new  Date();%>
	 * 					输出内容：<%= 输出结果%>
	 * 
	 * 				如何不使用servlet服务，可以在jsp页面 写 逻辑代码 + html 渲染数据；
	 * 
	 * 			jsp 运行特点：
	 * 				第一次访问 ：
	 * 					将 jsp文件由jsp引擎，转换为servelt 的源文件(.java) ===>将源文件 编译为字节码文件（.class）
	 * 				===> jmv 执行字节码 ===》然后再向客户端输出===》浏览器渲染输出数据生成静态html页面；
	 * 
	 * 				第二次访问：
	 * 						在页面内容没有改变的情况下，直接执行 字节码文件；否则按照第一次编译过程执行；
	 * 
	 * 			jsp页面的组成：
	 * 				html   静态页面
	 * 				<% script  %> 脚本的引入
	 * 				<% JAVA 业务逻辑代码%> Java代码
	 * 				<%= %> 数据的输出， 等同于：servlet中的out.print("。。。。");
	 * 				<%! 变量 方法....%>声明全局变量 / 方法
	 *  			<%@ %> 指令：
	 *  				 page 指令： 导入包
	 *  				 pageEncoding 设置编码
	 *  				 errorPage :指定错误页面
	 *  				 include：引入页面，
	 *  				静态引入 和动态引入的区别？
	 *  						
	 * 			案例 在jsp实现 后台业务逻辑的处理 
	 * 
	 * 				 <%  IUserDao  userDao =  new UserDaoImpl();
				  	    //调用 列表方法
				  	    List<UserInfo> list =  userDao.querList();
				  	    
				  	    for(int i=0;i<list.size;i++){
				  	  %>  
							<!-- 循环的数据 -->  
							<%=list[i].userName %>,<%=list[i].userAge %>,<%=list[i].userSex %><br/>
				  	  <%  		
				  	    }
				  	  %>
	 * 				
	 * 			jsp 中的内置对象：
	 * 				jsp页面中不需要创建的对象，可以直接调用
	 * 				有哪些 内置对象，分类
	 * 					输入输出：out request response
	 * 					作用域：page request session application
	 * 					通讯域：pageContext  request/requestContext session/sessionContext 
	 * 								 application/applicationContext
	 * 					其他：config  exception
	 * 					
	 * 			作用域的 范围大小：page request session application
	 * 
	 * 			页面取值：
	 * 				<% out.print()  %> <%= 变量名称%> ${变量名称}
	 * 				pageContext.setAttribute("name",'小白');
	 * 				request.setAttribute("name",'小花');
	 * 				session.setAttribute("name",'小红');
	 * 				application.setAttribute("name",'小灰');
	 * 					
	 * 				 ${name}  == 小白
	 * 				 ${sessionScore.name}  == 小红
	 * 		
	 *       案例练习：  
	 *       	使用 四大作用域存值:通过 不同页面+浏览器+ 客户端 进行访问 验证四大作用域的 范围；
	 *       
	 *       EL表达式的使用：
	 *       	${ }
	 * 			放变量， 作用域.变量，  对象.属性;
	 * 			还可以：
	 * 				运算符 + - * /  % || && ! eq .....  三目运行符；
	 * 
	 * 
	 *      jstl 核心吧标签库：
	 *       
	 *      cookie:会话跟踪：（session 隐藏表单  URL）
	 *      
	 *      
	 *      jQuery中的ajax 解析xml个数数据
	 *      
	 *      
	 *      layUI 功能实现：(列表 分页  添加 修改  删除  条件检索.....);
	 *      
	 *      **************************************************************************************
	 *      xml创建 解析 操作
	 *      	定义：标准格式的数据描述文档，可扩展的文档语言，不依赖域 系统 运行平台；
	 *      	
	 *      	类似：html : html 是有W3C提供，使用方式：直接在页面布局  浏览器 进行解析；、
	 *      	自定义标签xml:自己定义的标准格式 文档，必须是闭合标签，用来 传递数据；
	 *      
	 *      特点：
	 *      	XML: 对大小写 敏感；
	 *      	xml：必须正确的嵌套；
	 *      	xml：必须有根目录；
	 *      	xml：属性必须添加引号；
	 *          .......
	 *          
	 *      如何操作xml ?
	 *      	1 创建xml文档
	 *      	2 读取xml文档
	 *      	3 写入数据
	 *      	4 修改文档....	
	 *      
	 *      	jDom ,dom4j 基于api面向Java的操作语言，是 API的高级封装；
	 *      
	 *      	底层的实现：
	 *      		dom:是解析 xml的底层接口；
	 *      		sax：也是解析 xml的底层接口；
	 *      	
	 *      	jDom,dom4j区别？
	 *      		dom4j:是使用最多的操作模式，速度 效果 性能 均好，很多框架 解析xml配置文件 都使用的 这种方式
	 *      		jdom 和 dom 在性能上表现不佳，在文档超过 10M 后 会有数据溢出的 情况发生；
	 *      
	 *      如何使用？
	 *      	jDom,dom4j 直接查找文档API,掌握 常用的 方法 20个左右！！！！！！！！
	 *      
	 *      新建项目 导入支持包： jdom_xxx.jar, dom4j-xxx.jar
	 *      jDom :案例
	 *      	
	 *      
	 *      	    
	 *      **************************************************************************************
	 *      	
	 *      
	 *      
	 *      
	 *      
	 *      
	 *      
	 *      excel 导入导出 ：不同方式实现
	 *      
	 *      .................
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

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
		���캯��
	*/
	public LoginServlet() {
		super();
	}
	/**
	 * ������� ���� servlet
	*/
	public void destroy() {
		super.destroy(); 
	}

	/**
	 * ����get���󷽷�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
		 ����post���󷽷�
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//�����ʽ����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//
		String  mehodName = request.getParameter("op");
		if(("login").equals(mehodName)){
			remberLogin(request, response);
		}

	}
	/**
	 * ��ס���� ��¼����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void remberLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ �����Ĳ���
		String login_name=request.getParameter("login_name");
		String password=request.getParameter("password");
		
		String isLogin=request.getParameter("isLogin");
		
		
		//��ѯ���ݿ����Ƿ� �иö��󣬽�������Ϣ ���� session��
		
		HttpSession session = request.getSession();
		session.setAttribute("login_name", login_name);
		session.setAttribute("login_time", new Date());
		
		session.setMaxInactiveInterval(60*60);
		
		//�ж� ��¼ʱ �Ƿ��ס ��¼��Ϣ
		if(("yes").equals(isLogin)){
			//��ס�û� ��Ϣ
			Cookie loginName = new Cookie("userName", login_name);
			Cookie loginPwd = new Cookie("password", password);
			
			Cookie loginType = new Cookie("isLogin", isLogin);
			
			//���� cookie���� ��Чʱ�䣬 ������ ����·��  ������....
			loginName.setMaxAge(60*60*24*12);
			loginPwd.setMaxAge(60*60*24*12);
			loginType.setMaxAge(60*60*24*12);
			//ȷ�� �������ķ��� ·����ʽ
			loginName.setPath("/");
			loginPwd.setPath("/");
			loginType.setPath("/");
			//���� ���� ������
			loginName.setDomain("localhost");
			loginPwd.setDomain("localhost");
			loginType.setDomain("localhost");
			
			//�������� ����............
			
			//��Ӧ�� �ͻ���
			response.addCookie(loginName);
			response.addCookie(loginPwd);
			response.addCookie(loginType);
			
		}else{
			//��� ��¼��Ϣ
			
			//��ȡ�ͻ��˵�cookie ���� ����
			Cookie[] cookies = request.getCookies();
			if(cookies!=null && cookies.length>0){
				//��������
				for(int i=0; i<cookies.length;i++){
					
					if(("userName").equals(cookies[i].getName())){
						cookies[i].setMaxAge(0);
						cookies[i].setPath("/");
						//��Ӧ���ͻ���
						response.addCookie(cookies[i]);
					}else if(("password").equals(cookies[i].getName())){
						cookies[i].setMaxAge(0);
						cookies[i].setPath("/");
						//��Ӧ���ͻ���
						response.addCookie(cookies[i]);
						
					}else if(("isLogin").equals(cookies[i].getName())){
						cookies[i].setMaxAge(0);
						cookies[i].setPath("/");
						//��Ӧ���ͻ���
						response.addCookie(cookies[i]);
					}
				}
			}
		}
		
		//�ڲ���ת �ķ�ʽ  ��ָ��ҳ���У�
		request.getRequestDispatcher("../main.jsp").forward(request, response);
		
	}
	
	/**
	 * old��¼����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loginOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		
				//��ȡ�û���¼��Ϣ
				String logN = request.getParameter("logName");
				String logP = request.getParameter("logPwd");
				
				//�������ݿ�  ��ѯ ������ ���бȶԡ�
				if("��С��".equals(logN)&&"123456".equals(logP)){
					
					//�����û���Ϣ ��ת���ͻ��� request�У�ҳ��ͬ�ã�session  �����ã�application  ҳ��������pageContext
					HttpSession session = request.getSession();
					session.setAttribute("userNakme", logN);
					session.setAttribute("userPwd",logP);
					//����session ����Чʱ�䣻
					session.setMaxInactiveInterval(60*10);
					//�Ƴ�����
					//session.removeAttribute("userPwd");
					//����session
					//session.invalidate();
					//��תҳ�� ��Ӧ��ʽ֮һ������ �ڲ���ת  �ⲿ��ת   ������Ӧ
					
					//�ڲ���ת:���ҽ����� ���ݵ� ҳ����
					request.getRequestDispatcher("../main.jsp").forward(request, response);
				}else{
					//��¼ʧ�� �ⲿ��ת  
					//response.sendRedirect("../index.jsp");
					request.setAttribute("errMsg", "��¼���û���/������󣡣���");
					request.getRequestDispatcher("../index.jsp").forward(request, response);
				}
		
	}
	
	
	

	/**
	 * ��ʼ��
	 */
	public void init() throws ServletException {
		//��ʼ�� ������Ϣ
	}
	/**
	 * ��ʶ xml�ĵ�
	 * 	���ã�ͨ��xml��ʽ �������ݵ� ������ ���߿ͻ��ˣ��ṹ�� ��ʽ��������ʺ� ������Ա�����ݵ� �鿴 ��Ϣ������
			��ʽ�����νṹ�����붨��Ϊ��׼�� �ṹ��
			��Ŀ¼��
			��Ԫ��
			�ڲ���Ԫ��
			Ԫ�ص�����
			Ԫ��ֵ
	 * ���磺xml��ʽ���ļ���
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
	 * ��׼��xml��ʽ�ĵ���
	 * 	��Ŀ¼�µ���Ԫ�� ���й��ɵģ�
	 * 		<?xml version="1.0" encoding="UTF-8"?>
	 * 			<root>
	 * 				<studInfo id="10" name="stu_10">
	 * 					<stuId>1001</stuId>
	 * 					<stuName>���»�</stuName>	
					    <stuSex>��</stuSex>	
					    <stuAge>30</stuAge>	
					    <booksList>
					    	<bookInfo>
					    		<bookId>102</bookId>
					    		<bookName>��������</bookName>
					    		<bookPrice>88.88</bookPrice>
					    		<bookDate>2011-10-8</bookDate>
					    	</bookInfo>
					    	<bookInfo>
					    		<bookId>102</bookId>
					    		<bookName>��������</bookName>
					    		<bookPrice>88.88</bookPrice>
					    		<bookDate>2011-10-8</bookDate>
					    	</bookInfo>
					    	<bookInfo>
					    		<bookId>102</bookId>
					    		<bookName>��������</bookName>
					    		<bookPrice>88.88</bookPrice>
					    		<bookDate>2011-10-8</bookDate>
					    	</bookInfo>
					    </booksList>
	 * 				</studInfo>
	 * 				<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>���»�</stuName>	
					    <stuSex>��</stuSex>	
					    <stuAge>30</stuAge>	
					    <booksList>
					    	
					    </booksList>
	 * 				</studInfo>
	 * 				<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>���»�</stuName>	
					    <stuSex>��</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 *			 <studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>���»�</stuName>	
					    <stuSex>��</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>���»�</stuName>	
					    <stuSex>��</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>���»�</stuName>	
					    <stuSex>��</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			<studInfo>
	 * 					<stuId>1001</stuId>
	 * 					<stuName>���»�</stuName>	
					    <stuSex>��</stuSex>	
					    <stuAge>30</stuAge>	
	 * 				</studInfo>
	 * 			</root>
	 * 
	 * 	���£� WEB����������
	 * 		1. web ��ά�� WWW ��World wide Web;
	 * 		2. web �������������
	 * 			html ��ҳ�� url ��λ��  http ����Э�飻		
	 * 			
	 * 		 ҳ�棺��̬ ��̬
	 * 			html +css  jsp  asp(VB)  ado.net(C#) php ��������
	 * 		
	 * 			
	 * 		��λ��
	 * 			url:ͳһ��Դ��λ����������λweb�����е�ĳ����Դ��
	 * 			uri:ͨ����Դ��ʶ�����������Զ�λĳ����Դ��������ȷ�� ��Դ�ľ���λ��(url��uri����ɲ���֮һ);
	 * 		
	 * 		�����ύ��ʽ��get post  put  delete  head  options �����ύ��ʽ
	 * 			get�������ٶ� �죬����ȫ ���� ���� url����ʾ������������С 1024�ֽ�
	 * 			post���ٶ��� ��ԱȽϰ�ȫ�������� �Ѵ������ʽ���� ������������ һ��Ϊ4M;
	 *			
	 *		3. B/S �� C/S
	 *		 	B/S: ����� �������� ����ά�� �ɱ���  �ֲ�ʽ 
	 *			C/S�� �ͻ��� ��������ά������ ������������ ������ǿ 
	 *
	 *		4.httpЭ�� /https   fpt/ 
	 * 			�׳ƣ����ı����� Э��
	 * 			�ص㣺��״̬ -- ���ܼ�ס �ͻ������������
	 * 		
	 * 		5.״̬�룺
	 * 			200 �������ɹ�
	 * 			301����Դ�󶨵�����URL
	 * 			404������url����
	 * 			400������ķ����������쳣
	 * 			415����������ڲ�����
	 * 			500���������߼�����
	 * 			...............
	 * 		�Զ���״̬�룺
	 * 			NO8858885569_599:����һ��ʲô����........
	 * 
	 * 		6.Web��������tomcate jBoss webLogic Oracle.......
	 * 			
	 * ������ serlert:
	 * 		һ ʲô�� servlet��
	 * 			����Java�����д�� JavaԴ�ļ���������web�������У����ڽ����û����󣬲��ҵ���javaBeanҵ���߼� ��ȡ��Ӧ�ý������Ӧ������
	 * 			
	 * 		�� ��������
	 * 			����׶� 3������
	 * 			����ʵ������ִ�й��캯��
	 * 			��ʼ����ִ�� inint() ����
	 * 			����ִ�� service(),������������ ���� get post  updata delete .....
	 *  		���٣�ִ�� destory()����������ֹͣ ִ�и÷���
	 *  		������״̬��ϵͳ�Զ����գ�����ڴ治����״̬��
	 * 			
	 * 			����ļ���˳��
	 * 			��һ�Σ�ִ��˳������ ===������ʵ����===����ʼ��===������===����Ӧ===��===��
	 * 			�ڶ��Σ�ִ��˳������ ===������===����Ӧ===��===��
	 * 
	 * 			����====������

	 *
	 * 		����� ʹ��servlet?
	 * 						
	 *     	Jsp��̬ҳ�棺
	 *     		ʲô�� jsp?
	 *     			jsp:(java Server page) �����ڷ�������
	 *     				jsp�е�ҵ���߼����룺
	 *     					<% Date nowTime = new  Date();%>
	 * 					������ݣ�<%= ������%>
	 * 
	 * 				��β�ʹ��servlet���񣬿�����jspҳ�� д �߼����� + html ��Ⱦ���ݣ�
	 * 
	 * 			jsp �����ص㣺
	 * 				��һ�η��� ��
	 * 					�� jsp�ļ���jsp���棬ת��Ϊservelt ��Դ�ļ�(.java) ===>��Դ�ļ� ����Ϊ�ֽ����ļ���.class��
	 * 				===> jmv ִ���ֽ��� ===��Ȼ������ͻ������===���������Ⱦ����������ɾ�̬htmlҳ�棻
	 * 
	 * 				�ڶ��η��ʣ�
	 * 						��ҳ������û�иı������£�ֱ��ִ�� �ֽ����ļ��������յ�һ�α������ִ�У�
	 * 
	 * 			jspҳ�����ɣ�
	 * 				html   ��̬ҳ��
	 * 				<% script  %> �ű�������
	 * 				<% JAVA ҵ���߼�����%> Java����
	 * 				<%= %> ���ݵ������ ��ͬ�ڣ�servlet�е�out.print("��������");
	 * 				<%! ���� ����....%>����ȫ�ֱ��� / ����
	 *  			<%@ %> ָ�
	 *  				 page ָ� �����
	 *  				 pageEncoding ���ñ���
	 *  				 errorPage :ָ������ҳ��
	 *  				 include������ҳ�棬
	 *  				��̬���� �Ͷ�̬���������
	 *  						
	 * 			���� ��jspʵ�� ��̨ҵ���߼��Ĵ��� 
	 * 
	 * 				 <%  IUserDao  userDao =  new UserDaoImpl();
				  	    //���� �б���
				  	    List<UserInfo> list =  userDao.querList();
				  	    
				  	    for(int i=0;i<list.size;i++){
				  	  %>  
							<!-- ѭ�������� -->  
							<%=list[i].userName %>,<%=list[i].userAge %>,<%=list[i].userSex %><br/>
				  	  <%  		
				  	    }
				  	  %>
	 * 				
	 * 			jsp �е����ö���
	 * 				jspҳ���в���Ҫ�����Ķ��󣬿���ֱ�ӵ���
	 * 				����Щ ���ö��󣬷���
	 * 					���������out request response
	 * 					������page request session application
	 * 					ͨѶ��pageContext  request/requestContext session/sessionContext 
	 * 								 application/applicationContext
	 * 					������config  exception
	 * 					
	 * 			������� ��Χ��С��page request session application
	 * 
	 * 			ҳ��ȡֵ��
	 * 				<% out.print()  %> <%= ��������%> ${��������}
	 * 				pageContext.setAttribute("name",'С��');
	 * 				request.setAttribute("name",'С��');
	 * 				session.setAttribute("name",'С��');
	 * 				application.setAttribute("name",'С��');
	 * 					
	 * 				 ${name}  == С��
	 * 				 ${sessionScore.name}  == С��
	 * 		
	 *       ������ϰ��  
	 *       	ʹ�� �Ĵ��������ֵ:ͨ�� ��ͬҳ��+�����+ �ͻ��� ���з��� ��֤�Ĵ�������� ��Χ��
	 *       
	 *       EL���ʽ��ʹ�ã�
	 *       	${ }
	 * 			�ű����� ������.������  ����.����;
	 * 			�����ԣ�
	 * 				����� + - * /  % || && ! eq .....  ��Ŀ���з���
	 * 
	 * 
	 *      jstl ���İɱ�ǩ�⣺
	 *       
	 *      cookie:�Ự���٣���session ���ر�  URL��
	 *      
	 *      
	 *      jQuery�е�ajax ����xml��������
	 *      
	 *      
	 *      layUI ����ʵ�֣�(�б� ��ҳ  ��� �޸�  ɾ��  ��������.....);
	 *      
	 *      **************************************************************************************
	 *      xml���� ���� ����
	 *      	���壺��׼��ʽ�����������ĵ�������չ���ĵ����ԣ��������� ϵͳ ����ƽ̨��
	 *      	
	 *      	���ƣ�html : html ����W3C�ṩ��ʹ�÷�ʽ��ֱ����ҳ�沼��  ����� ���н�������
	 *      	�Զ����ǩxml:�Լ�����ı�׼��ʽ �ĵ��������Ǳպϱ�ǩ������ �������ݣ�
	 *      
	 *      �ص㣺
	 *      	XML: �Դ�Сд ���У�
	 *      	xml��������ȷ��Ƕ�ף�
	 *      	xml�������и�Ŀ¼��
	 *      	xml�����Ա���������ţ�
	 *          .......
	 *          
	 *      ��β���xml ?
	 *      	1 ����xml�ĵ�
	 *      	2 ��ȡxml�ĵ�
	 *      	3 д������
	 *      	4 �޸��ĵ�....	
	 *      
	 *      	jDom ,dom4j ����api����Java�Ĳ������ԣ��� API�ĸ߼���װ��
	 *      
	 *      	�ײ��ʵ�֣�
	 *      		dom:�ǽ��� xml�ĵײ�ӿڣ�
	 *      		sax��Ҳ�ǽ��� xml�ĵײ�ӿڣ�
	 *      	
	 *      	jDom,dom4j����
	 *      		dom4j:��ʹ�����Ĳ���ģʽ���ٶ� Ч�� ���� ���ã��ܶ��� ����xml�����ļ� ��ʹ�õ� ���ַ�ʽ
	 *      		jdom �� dom �������ϱ��ֲ��ѣ����ĵ����� 10M �� ������������� ���������
	 *      
	 *      ���ʹ�ã�
	 *      	jDom,dom4j ֱ�Ӳ����ĵ�API,���� ���õ� ���� 20�����ң���������������
	 *      
	 *      �½���Ŀ ����֧�ְ��� jdom_xxx.jar, dom4j-xxx.jar
	 *      jDom :����
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
	 *      excel ���뵼�� ����ͬ��ʽʵ��
	 *      
	 *      .................
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//HttpSessionListener������ʵ��ͳ����վ���������Ĺ���
public class SessionCounter implements HttpSessionListener{

			
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext servletContext = se.getSession().getServletContext();
		Integer TOTAL_ONLINE_USERS = (Integer) servletContext.getAttribute("TOTAL_ONLINE_USERS");
		// ����û��˳���TOTAL_ONLINE_USERS�Լ�1
		if (TOTAL_ONLINE_USERS == null) {
			TOTAL_ONLINE_USERS = new Integer(1);
		}else {
			int count = TOTAL_ONLINE_USERS.intValue( );
			TOTAL_ONLINE_USERS = new Integer(count + 1);
		}
		servletContext.setAttribute("TOTAL_ONLINE_USERS", TOTAL_ONLINE_USERS);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext servletContext = se.getSession().getServletContext();
		Integer TOTAL_ONLINE_USERS = (Integer) servletContext.getAttribute("TOTAL_ONLINE_USERS");
		// ����û��˳���TOTAL_ONLINE_USERS�Լ�1
		if (TOTAL_ONLINE_USERS == null	) {
			TOTAL_ONLINE_USERS = new Integer(0);
		}else {
			int count = TOTAL_ONLINE_USERS.intValue( );
			TOTAL_ONLINE_USERS = new Integer(count - 1);
		}
		servletContext.setAttribute("TOTAL_ONLINE_USERS", TOTAL_ONLINE_USERS);
		
		
	}

	
	
	
	
}

package com.accp.mybatis_house.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class MyListenter
 *
 */
public class MyListenter implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyListenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        ServletContext application= arg0.getSession().getServletContext();
        Integer count= (Integer) application.getAttribute("count");
        if(count>0) {
        	count--;
        }
        application.setAttribute("count", count);
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	ServletContext application=arg0.getServletContext();
    	application.removeAttribute("count");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent context)  { 
       ServletContext application= context.getServletContext();
       application.setAttribute("count", 0);
       System.out.println("dd");
    }
	
}

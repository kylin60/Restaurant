package com.netease;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.lf5.Log4JLogRecord;
import org.apache.log4j.lf5.viewer.LogFactor5Dialog;


public class NoodlesServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(NoodlesServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter writer = response.getWriter();
		
		String vegetable = request.getParameter("vegetable");
		
		if(vegetable == null){
			vegetable = "Tomato";	
		}else{
			vegetable = new String(vegetable.getBytes("ISO-8859-1"),"utf-8");
		}
		
		ServletContext sct = getServletContext();
	    String prefix = sct.getRealPath("/");
	    
	    //log4j 配置文件存放目录
	    String file = getInitParameter("log4j");
	    
	     //log4j 配置文件
	    if (file != null) {
	    	PropertyConfigurator.configure(prefix + "\\"+file);
	    }
	    logger.info(vegetable);
	    
	     
		response.setContentType("text/html; charset=UTF-8");
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1> Noodles with " + vegetable + "</h1>");
		writer.println("</body></html>"); 

	}
}
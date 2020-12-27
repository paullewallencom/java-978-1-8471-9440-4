
package com.binildas.esb.servicemix.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet{

   public static final String XML_CONTENT = "<?xml version=\"1.0\"?><Name>Binil's Servlet wishes you</Name>";

   public void init(ServletConfig config) throws ServletException {
      super.init (config);
   }

   public void doGet (HttpServletRequest  request, HttpServletResponse response)throws ServletException, IOException{
      doPost (request, response);
   }

   public void doPost (HttpServletRequest  request, HttpServletResponse response)throws ServletException, IOException{

      System.out.println("WelcomeServlet.doPost...");

      response.setContentType("text/xml");
      response.setContentLength(XML_CONTENT.length());
      PrintWriter out = response.getWriter();
      out.println (XML_CONTENT);
      out.flush();
   }
}

//    http://localhost:8080/EsbServlet/hello/

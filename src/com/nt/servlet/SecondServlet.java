package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String exp=null,skils=null;
		HttpSession ses=null;
//general settings
		pw=res.getWriter();
		res.setContentType("text/html");

//read form1/req1 data
		
		exp=req.getParameter("exp");
		skils=req.getParameter("skils");
		
//creating session object
		
		ses=req.getSession(false);
		
//keep form1/req1 data in session attribute
		ses.setAttribute("exp",exp);
		ses.setAttribute("skils",skils);
//create form3 dynamically
		pw.println("<body bgcolor=cyan>");
		pw.println("<h1><center><font color=red>Provide Your City & Salary</font></center></h1>");
		pw.println("<form action="+res.encodeURL("thirdurl")+" method='post'>");
		pw.println("<table align=center>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h3><font color=blue>Enter Preference City:</font></h3>");
		pw.println("<input type=text name=city");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h3><font color=blue>Enter Expected Salalry:</font></h3>");
		pw.println("<input type=text name=sal");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<input type=submit value=Submit>");
		pw.println("</td></tr></table></body>");
		
		pw.println("</table></body>");
		
	//close stream
		pw.close();
		
	}//doget
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}//class

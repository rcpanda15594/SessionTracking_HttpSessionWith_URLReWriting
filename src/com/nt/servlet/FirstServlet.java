package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String name=null,address=null,age=null;
		HttpSession ses=null;
//general settings
		pw=res.getWriter();
		res.setContentType("text/html");

//read form1/req1 data
		
		name=req.getParameter("name");
		address=req.getParameter("address");
		age=req.getParameter("age");
		
//creating session object
		
		ses=req.getSession(true);
		
//keep form1/req1 data in session attribute
		ses.setAttribute("name",name);
		ses.setAttribute("address",address);
		ses.setAttribute("age",age);
		
//create form2 dynamically
		pw.println("<body bgcolor=cyan>");
		pw.println("<h1><center><font color=red>Provide Your Exp & Skill</font></center></h1>");
		pw.println("<form action="+res.encodeURL("secondurl")+" method='post'>");
		pw.println("<table align=center>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h3><font color=blue>Enter no of Exp:</font></h3>");
		pw.println("<input type=text name=exp");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h3><font color=blue>Enter no of Exp:</font></h3>");
	    pw.println("<select name=skils>");
	    pw.println("<option >Enter Skill Types </option>");
		pw.println("<option value=java> JAVA </option>");
		pw.println("<option value=.net> .NET </option>");
		pw.println("<option value=oracle> Oracle </option>");
		pw.println("<option value=xml> XML WebService </option>");
		pw.println("</select>");
		pw.println("</tr>");
		pw.println("</td>");
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<input type=submit value=Continue>");
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

/**
 * 
 */
package com.surith.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kxhb130
 *
 */
public class MyServlet extends HttpServlet {

	/**
	 * /Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin/java
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.write("Hello Surith<br>");
		Enumeration<String> en = req.getHeaderNames();
		while (en.hasMoreElements()) {
			String header = en.nextElement();
			out.write("<b>" + header + ":</b> " + req.getHeader(header) + "<br>");
		}

		out.write("<br>");
		out.write("<br>");
		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		System.out.println(name);
		System.out.println(pass);
		if (!"abc".equalsIgnoreCase(name) && !"abc".equalsIgnoreCase(pass)) {
			out.write("<h2>Login Page</h2>");
			out.write("<br>");
			out.write("<h3>Wrong credentials!</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}

	}

	@Override
	public void init() {
		System.out.println("Heuyyyyy Surith -> u gave birth to me");
	}
}

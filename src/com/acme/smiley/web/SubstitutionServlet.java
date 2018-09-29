package com.acme.smiley.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubstitutionServlet
 */
@WebServlet("/substitution")
public class SubstitutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		out.println("<html><head><title>Substitution Service</title></head><body>");
		out.println("<form action='#' method='POST'>");
		out.println("<p>Please enter a message.</p>");
		out.println("<textarea name='msg'>Hello :)</textarea><p/>");
		out.println("<button type='submit'>Send</button>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String message = request.getParameter("msg");
		message = message.replace(":)", "☺");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Substitution Service</title></head><body>");
		out.println("<p>You entered the following message.</p>");
		out.printf("<p>%s</p>\n", message);
		out.println("<a href=''>Try again</a><br/>");
		out.println("<a href='hello'>Go to welcome page</a><br/>");
		out.println("</body></html>");
	}

}

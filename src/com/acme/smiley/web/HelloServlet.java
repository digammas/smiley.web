package com.acme.smiley.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(description = "Greeting Servlet", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("nm");
		HttpSession session = request.getSession();
		if (name == null) {
			name = (String) session.getAttribute("user");
		} else {
			session.setAttribute("user", name);
		}
		response.getWriter().println("<html><head><title>Hello Page</title><head><body>");
		response.getWriter().printf("<p>Hello <b>Smiley</b> %s ☺</p>\n", name);
		response.getWriter().println("<a href='substitution'>Substitution service</a><br/>");
		response.getWriter().println("<a href='index.html'>Back to home page</a>");
		response.getWriter().println("</body></html>");
	}

}

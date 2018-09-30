package com.acme.smiley.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.smiley.service.SubstitutionService;

/**
 * Servlet implementation class SubstitutionServlet
 */
@WebServlet("/substitution")
public class SubstitutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SubstitutionService service = new SubstitutionService();

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/substitution.html").forward(request, response);
	}

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String message = request.getParameter("msg");
		message = service.substitute(message);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/substitution.jsp").forward(request, response);
	}

}

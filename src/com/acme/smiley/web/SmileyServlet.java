package com.acme.smiley.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.smiley.model.Smiley;
import com.acme.smiley.model.SmileyDao;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/smiley")
public class SmileyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SmileyDao dao = SmileyDao.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String action = request.getParameter("act");
		Smiley smiley = dao.read(Integer.parseInt(id));
		if (smiley == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		request.setAttribute("smiley", smiley);
		String path = "edit".equals(action) ? "/edit.jsp" : "/view.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Smiley smiley = new Smiley();
		smiley.setFace(request.getParameter("face"));
		smiley.setShortcut(request.getParameter("shortcut"));
		smiley.setDescription(request.getParameter("description"));
		smiley.setId(Integer.parseInt(id));
		dao.update(smiley);
		response.sendRedirect("list");
	}
}

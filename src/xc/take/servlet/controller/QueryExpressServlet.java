package xc.take.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.util.Express;
import xc.take.util.ReaderExpressJson;

public class QueryExpressServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  key= request.getParameter("key");
		
		List<Express> listExpress = ReaderExpressJson.getLike(key);
	
		request.setAttribute("listExpress", listExpress);
		request.getRequestDispatcher("/WEB-INF/showScreenExpress.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	
	}

}

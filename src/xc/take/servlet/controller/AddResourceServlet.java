package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Resource;
import xc.take.service.IResourceService;
import xc.take.service.impl.ResourceServiceImpl;

public class AddResourceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IResourceService resourceServiceImpl = new ResourceServiceImpl();
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		Resource resource = new Resource();
		
		resource.setName(name);
		resource.setUrl(url);
		resourceServiceImpl.addResource(resource);
		
		request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}

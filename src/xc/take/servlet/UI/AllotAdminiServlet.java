package xc.take.servlet.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Resource;
import xc.take.service.IResourceService;
import xc.take.service.impl.ResourceServiceImpl;

public class AllotAdminiServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IResourceService resourceServiceImpl=new ResourceServiceImpl();
		String roleId = request.getParameter("roleId");
		List<Resource> resourceList = resourceServiceImpl.findAll();
		
		
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("roleId", roleId);
		request.getRequestDispatcher("/WEB-INF/allotAdmini.jsp").forward(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}

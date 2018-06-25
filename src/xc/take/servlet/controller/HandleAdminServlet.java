package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import xc.take.domain.RoleVo;
import xc.take.service.IRoleVoService;
import xc.take.service.impl.RoleVoServiceImpl;

public class HandleAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IRoleVoService roleVoServiceImpl = new RoleVoServiceImpl();	
		
		String[] ids = request.getParameterValues("resourceIds");
		String role_id = request.getParameter("roleId");
		
		List<Long> resourceIds= new ArrayList<Long>();
		for (String id : ids) {
			resourceIds.add(Long.valueOf(id));
		}
		
		roleVoServiceImpl.saveRoleOfResource(Long.valueOf(role_id), resourceIds);
		
		response.sendRedirect(request.getContextPath()+"/ShowMenuServlet");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}

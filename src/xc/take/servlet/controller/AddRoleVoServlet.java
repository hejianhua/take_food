package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.RoleVo;
import xc.take.service.IRoleVoService;
import xc.take.service.impl.RoleVoServiceImpl;

public class AddRoleVoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			IRoleVoService  roleServiceImpl = new RoleVoServiceImpl();
			String name = request.getParameter("name");
		    RoleVo roleVo = new RoleVo();
			
		    roleVo.setName(name);
			roleServiceImpl.saveRoleVo(roleVo);
			
			response.sendRedirect(request.getContextPath()+"/ShowRoleServlet");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}

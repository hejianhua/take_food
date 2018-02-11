package xc.take.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.service.IUserService;
import xc.take.service.impl.UserServiceImpl;

public class AddUserOfRoleServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			IUserService userServiceImpl = new UserServiceImpl();
			String UId = request.getParameter("u_id");
			String[] arr_id = request.getParameterValues("roleIds");
			String rrr = request.getParameter("roleIds");
			System.out.println("看看rrr"+rrr);
			List<Long> roleIds=new ArrayList<Long>();
			
			for (String r_id : arr_id) {
				System.out.println("看看r_id"+r_id);
				roleIds.add(Long.valueOf(r_id));
			}
			
			userServiceImpl.saveUser_Role(Long.valueOf(UId), roleIds);
	
			response.sendRedirect(request.getContextPath()+"/ShowMenuServlet");
			
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}

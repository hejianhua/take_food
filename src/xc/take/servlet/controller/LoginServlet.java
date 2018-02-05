package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.UserVo;
import xc.take.service.IUserService;
import xc.take.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	private IUserService userServiceImpl=new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVo userVo=null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		if(username!=null&&password!=null){
			userVo = userServiceImpl.login(username, password);
		}
		if(userVo!=null){
			
			response.sendRedirect(request.getContextPath()+"/ShowMenuServlet");
			//request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			this.doGet(request, response);
	}

}

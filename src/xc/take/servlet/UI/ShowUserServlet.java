package xc.take.servlet.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.PageModel;
import xc.take.domain.RoleVo;
import xc.take.domain.UserVo;
import xc.take.service.IRoleVoService;
import xc.take.service.IUserService;
import xc.take.service.impl.RoleVoServiceImpl;
import xc.take.service.impl.UserServiceImpl;

public class ShowUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String pageSize = request.getParameter("pageSize");
		String pageNumber = request.getParameter("pageNumber");
		PageModel pageModel = new PageModel();
		pageModel.setPageNumber(Integer.valueOf(pageNumber).intValue());
		pageModel.setPageSize(Integer.parseInt(pageSize));
		
		IUserService userServiceImpl = new UserServiceImpl();
		//角色
		IRoleVoService roleVoServiceImpl = new RoleVoServiceImpl();
		
		int total = userServiceImpl.findByCount();
		pageModel.setTotalCount(total);
		
		List<UserVo> list = userServiceImpl.findByPage(pageModel);
		List<RoleVo> roleList = roleVoServiceImpl.findByAll();
		request.setAttribute("list", list);
		request.setAttribute("roleList", roleList);
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("/WEB-INF/showUserList.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	
	}

}

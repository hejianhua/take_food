package xc.take.servlet.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.UserVo;
import xc.take.service.IUserService;
import xc.take.service.impl.UserServiceImpl;

public class BillServlet extends HttpServlet {
	private IUserService userServiceImpl=new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		List<UserVo> list = userServiceImpl.showList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/showList.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}

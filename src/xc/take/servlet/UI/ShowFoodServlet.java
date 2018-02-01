package xc.take.servlet.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Food;
import xc.take.service.IFoodService;
import xc.take.service.impl.FoodServiceImpl;

public class ShowFoodServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
			
		
		//展示所有的food
		IFoodService foodServiceImpl = new FoodServiceImpl();
		List<Food> list = foodServiceImpl.showList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/showFoodList.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}

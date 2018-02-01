package xc.take.servlet.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Meals;
import xc.take.service.IMealsService;
import xc.take.service.impl.MealsServiceImpl;

public class ShowMealsServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		IMealsService mealsServiceImpl = new MealsServiceImpl();
		List<Meals> list = mealsServiceImpl.showList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/showMealsList.jsp").forward(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	
	}

}

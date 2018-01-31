package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Meals;
import xc.take.service.IMealsService;
import xc.take.service.impl.MealsServiceImpl;

public class AddMealsServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		IMealsService mealsServiceImpl = new MealsServiceImpl();
		
		Meals meals = new Meals();
		String name = request.getParameter("name");
		
		meals.setName(name);
		meals.setStatus(Short.valueOf("1"));
		
		mealsServiceImpl.createMeals(meals);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				this.doGet(request, response);
		
	}

}

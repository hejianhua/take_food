package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Food;
import xc.take.service.IFoodService;
import xc.take.service.impl.FoodServiceImpl;

public class AddFoodServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		BigDecimal price1=new BigDecimal(price);
		
		Food food = new Food();
		food.setName(name);
		food.setPrice(price1);
		
		//创建一个 foodservice
		IFoodService foodServiceImpl = new FoodServiceImpl();
		foodServiceImpl.createFood(food);
		
		response.sendRedirect("menu.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}

package xc.take.servlet.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Food;
import xc.take.domain.Meals;
import xc.take.domain.UserVo;
import xc.take.service.IFoodService;
import xc.take.service.IMealsService;
import xc.take.service.IUserService;
import xc.take.service.impl.FoodServiceImpl;
import xc.take.service.impl.MealsServiceImpl;
import xc.take.service.impl.UserServiceImpl;

public class TransferAddBillVoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			
			//去到添加页面，需要获取到所有的用户， 商品，还有餐型
			//添加service
			IUserService userServiceImpl = new UserServiceImpl();
			IFoodService  foodServiceImpl = new FoodServiceImpl();
			IMealsService mealsServiceImpl = new MealsServiceImpl();
			
			//取数据
			List<UserVo> userVoList = userServiceImpl.showList();
			List<Food> foodList = foodServiceImpl.showList();
			List<Meals> mealsList = mealsServiceImpl.showList();
			
			//封装数据
			request.setAttribute("userVoList", userVoList);
			request.setAttribute("foodList", foodList);
			request.setAttribute("mealsList", mealsList);
			
			//转发
			request.getRequestDispatcher("/WEB-INF/addBillVo.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				this.doGet(request, response);
	}

}

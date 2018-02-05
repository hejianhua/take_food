package xc.take.servlet.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.BillVo;
import xc.take.domain.Food;
import xc.take.domain.Meals;
import xc.take.domain.Param;
import xc.take.domain.QueryParam;
import xc.take.domain.UserVo;
import xc.take.service.IBillVoService;
import xc.take.service.IFoodService;
import xc.take.service.IMealsService;
import xc.take.service.IUserService;
import xc.take.service.impl.BillVoServiceImpl;
import xc.take.service.impl.FoodServiceImpl;
import xc.take.service.impl.MealsServiceImpl;
import xc.take.service.impl.UserServiceImpl;

public class ShowBillVoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			//创建service
			IBillVoService billVoServiceImpl = new BillVoServiceImpl();
			IUserService userServiceImpl = new UserServiceImpl();
			IFoodService foodServiceImpl = new FoodServiceImpl();
			IMealsService mealsServiceImpl = new MealsServiceImpl();
			
			//得到查询条件
			String status = request.getParameter("status");
			String total = request.getParameter("totalMoney"); 
			
			
			//设置查询条件
				
				QueryParam qpm = new QueryParam();
				if(status!=null&&status!=""){
					qpm.addParam(new Param("status",status,"="));
				}
				request.setAttribute("status", status);
				if(total!=null&&total!=""){
					System.out.println("执行这里吗？");
					qpm.addParam(new Param("totalMoney",total,"="));
					request.setAttribute("totalMoney",total );
				}
			//容器放数据
			//List<BillVo> list = billVoServiceImpl.findBillVo();
			List<BillVo> list = billVoServiceImpl.findParam(qpm);
			Map<Long,UserVo> userMap= new HashMap<Long,UserVo>();
			Map<Long, Meals> mealsMap = new HashMap<Long,Meals>();
			Map<Long, Food> foodMap = new HashMap<Long,Food>();
			
			
			//根据id获取各种信息
			for (BillVo billVo : list) {
				UserVo userVo = userServiceImpl.findById(billVo.getU_id());
				Meals meals = mealsServiceImpl.findById(billVo.getM_id());
				Food food = foodServiceImpl.findById(billVo.getF_id());
				
				//封装到map里面啦
				userMap.put(billVo.getId(), userVo);
				mealsMap.put(billVo.getId(),meals);
				foodMap.put(billVo.getId(), food);
				
			}
			
			request.setAttribute("list", list);
			request.setAttribute("userMap", userMap);
			request.setAttribute("mealsMap", mealsMap);
			request.setAttribute("foodMap", foodMap);
			
		
			request.getRequestDispatcher("/WEB-INF/showBillList.jsp").forward(request, response);
		
			
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}

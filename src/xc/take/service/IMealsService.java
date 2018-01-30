package xc.take.service;

import java.util.List;

import xc.take.domain.Meals;

public interface IMealsService {
	
	//创建一个餐型
	void createMeals(Meals meals);
	
	//修改餐
	void modifyMeals(Meals meals);
	
	//显示
	List<Meals> showList();
	
}	

package xc.take.service;

import java.util.List;

import xc.take.domain.Food;

public interface IFoodService {
	
	//新建一种食物
	void  createFood(Food food);
	
	//修改一个食物
	void modifyFood(Food food);
	
	//查看食物列表
	List<Food> showList();
	
	//根据id查询
	
	Food findById(Long id);
}

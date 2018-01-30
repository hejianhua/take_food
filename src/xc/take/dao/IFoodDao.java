package xc.take.dao;

import java.util.List;

import xc.take.domain.Food;

public interface IFoodDao {
	//保存食物
	void saveFood (Food food);
	
	//修改食物
	void modifyFood(Food food);
	
	//查看食物
	List<Food> findAll();
	
	//按id查询
	Food findById(Long id);
}

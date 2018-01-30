package xc.take.dao;

import java.util.List;

import xc.take.domain.Meals;

public interface IMealsDao {

	//保存餐型
	void saveMeals (Meals meals);

	//修改餐型
	void modifyMeals (Meals meals);
	
	//查看餐型
	List<Meals>  findAll();
	
	//按id查
	Meals findById(Long id);

}

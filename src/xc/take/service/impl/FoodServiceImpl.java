package xc.take.service.impl;

import java.util.List;

import xc.take.dao.IFoodDao;
import xc.take.dao.impl.FoodDaoImpl;
import xc.take.domain.Food;
import xc.take.service.IFoodService;

public class FoodServiceImpl implements IFoodService {
   private IFoodDao foodDaoImpl= new FoodDaoImpl();
	
	@Override
	public void createFood(Food food) {
		foodDaoImpl.saveFood(food);
		
	}

	@Override
	public void modifyFood(Food food) {
		foodDaoImpl.modifyFood(food);
		
	}

	@Override
	public List<Food> showList() {
		return foodDaoImpl.findAll();
	}

	@Override
	public Food findById(Long id) {
		
		return foodDaoImpl.findById(id);
	}

	

}

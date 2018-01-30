package xc.take.service.impl;

import java.util.List;

import xc.take.dao.IMealsDao;
import xc.take.dao.impl.MealsDaoImpl;
import xc.take.domain.Meals;
import xc.take.service.IMealsService;

public class MealsServiceImpl implements IMealsService {
	private IMealsDao mealDaoImpl=new MealsDaoImpl();
	@Override
	public void createMeals(Meals meals) {
		mealDaoImpl.saveMeals(meals);

	}

	@Override
	public void modifyMeals(Meals meals) {
		mealDaoImpl.modifyMeals(meals);

	}

	@Override
	public List<Meals> showList() {
		
		return mealDaoImpl.findAll();
	}

}

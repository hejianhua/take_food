package xc.take.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xc.take.dao.IFoodDao;
import xc.take.domain.Food;
import xc.take.util.JDBCUtil;

public class FoodDaoImpl implements IFoodDao {

	@Override
	public void saveFood(Food food) {
		String sql= "insert into food(f_name,f_price) values(?,?)";
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, food.getName());
			pre.setBigDecimal(1, food.getPrice());
			int index = pre.executeUpdate();
			if(index>0){
				System.out.println("保存成功");
			}
			JDBCUtil.closeConnection(connection, pre, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifyFood(Food food) {
		String sql= "update food set f_name=? f_price=? where f_id=?";
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, food.getName());
			pre.setBigDecimal(2, food.getPrice());
			pre.setLong(3, food.getId());
			int index = pre.executeUpdate();
			if(index>0){
				System.out.println("食物修改成功");
			}
			
			JDBCUtil.closeConnection(connection, pre, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Food> findAll() {
		String sql= "select * from  food";
		Connection connection = JDBCUtil.getConnection();
		List<Food> list= new ArrayList<Food>();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				Food food = new Food();
				String name = rs.getString("f_name");
				BigDecimal price=rs.getBigDecimal("f_price");
				long id = rs.getLong("f_id");
				food.setId(id);
				food.setName(name);
				food.setPrice(price);
				list.add(food);
			}
			JDBCUtil.closeConnection(connection, pre, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Food findById(Long id) {
		String sql= "select * from  food where f_id=?";
		Connection connection = JDBCUtil.getConnection();
		Food food = new Food();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, id);
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				String name = rs.getString("f_name");
				BigDecimal price=rs.getBigDecimal("f_price");
				food.setId(id);
				food.setName(name);
				food.setPrice(price);
			}
			JDBCUtil.closeConnection(connection, pre, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}

}

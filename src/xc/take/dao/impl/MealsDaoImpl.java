package xc.take.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xc.take.dao.IMealsDao;
import xc.take.domain.Food;
import xc.take.domain.Meals;
import xc.take.util.JDBCUtil;

public class MealsDaoImpl implements IMealsDao {

	@Override
	public void saveMeals(Meals meals) {
		String sql= "insert into meals(m_name,m_status) values(?,?)";
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, meals.getName());
			pre.setShort(1, meals.getStatus());
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
	public void modifyMeals(Meals meals) {
		String sql= "update meals set m_name=? m_status=? where m_id=?";
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, meals.getName());
			pre.setShort(2, meals.getStatus());
			pre.setLong(3, meals.getId());
			int index = pre.executeUpdate();
			if(index>0){
				System.out.println("修改成功");
			}
			
			JDBCUtil.closeConnection(connection, pre, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Meals> findAll() {
		String sql= "select * from  meals";
		Connection connection = JDBCUtil.getConnection();
		List<Meals> list= new ArrayList<Meals>();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				Meals meals = new Meals();
				String name = rs.getString("m_name");
				Short status=rs.getShort("m_status");
				long id = rs.getLong("m_id");
				meals.setId(id);
				meals.setName(name);
				meals.setStatus(status);
				list.add(meals);
			}
			JDBCUtil.closeConnection(connection, pre, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Meals findById(Long id) {
		String sql= "select * from  meals where m_id=?";
		Connection connection = JDBCUtil.getConnection();
		Meals meals = new Meals();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, id);
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				String name = rs.getString("m_name");
				Short status=rs.getShort("m_status");
				meals.setId(id);
				meals.setName(name);
				meals.setStatus(status);
			}
			JDBCUtil.closeConnection(connection, pre, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meals;
	}

}

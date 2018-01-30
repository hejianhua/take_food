package xc.take.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xc.take.dao.IUserDao;
import xc.take.domain.UserVo;
import xc.take.util.JDBCUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public void saveUser(UserVo userVo) {
		Connection connection = JDBCUtil.getConnection();
		String sql ="insert into user(username,password,nikename) values (?,?,?)";
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, userVo.getUserName());
			pre.setString(2, userVo.getPassword());
			pre.setString(3, userVo.getNikename());
			
			int index = pre.executeUpdate();
			if(index>0){
				System.out.println("添加成功");
			}
			JDBCUtil.closeConnection(connection, pre, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifyUser(UserVo userVo) {
		String sql = "update user set username=?,password=?,nikename=? where id=?";
		Connection connection = JDBCUtil.getConnection();
		try {
		PreparedStatement  pre = connection.prepareStatement(sql);
		pre.setString(1, userVo.getUserName());
		pre.setString(2, userVo.getPassword());
		pre.setString(3, userVo.getNikename());
		pre.setLong(4, userVo.getId());
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
	public UserVo findById(Long id) {
		String sql="select * from user where id=?";
		Connection connection = JDBCUtil.getConnection();
		UserVo userVo=new UserVo();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, id);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				 String username = rs.getString("username");
				 String password = rs.getString("password");
				 String nikename = rs.getString("nikename");
				 userVo.setId(id);
				 userVo.setUserName(username);
				 userVo.setPassword(password);
				 userVo.setNikename(nikename);
			}
			
			JDBCUtil.closeConnection(connection, pre, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userVo;
		
	
	}

	@Override
	public List<UserVo> findAll() {
		String sql = "select * from user";
		Connection connection = JDBCUtil.getConnection();
		List<UserVo> list= new ArrayList<UserVo>();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				UserVo userVo=new UserVo();
				 Long id = rs.getLong("id");
				 String username = rs.getString("username");
				 String password = rs.getString("password");
				 String nikename = rs.getString("nikename");
				 userVo.setId(id);
				 userVo.setUserName(username);
				 userVo.setPassword(password);
				 userVo.setNikename(nikename);
				 list.add(userVo);
			}
			
			JDBCUtil.closeConnection(connection, pre, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public UserVo findByUserNameAndPassword(String username, String password) {
		String sql="select * from user where username=? and password=?";
		Connection connection = JDBCUtil.getConnection();
		UserVo userVo=new UserVo();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				 String username1 = rs.getString("username");
				 String password1 = rs.getString("password");
				 String nikename = rs.getString("nikename");
				 Long id = rs.getLong("id");
				 userVo.setId(id);
				 userVo.setUserName(username1);
				 userVo.setPassword(password1);
				 userVo.setNikename(nikename);
			}
			
			JDBCUtil.closeConnection(connection, pre, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userVo;
	}
		
}

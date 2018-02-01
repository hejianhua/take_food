package xc.take.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xc.take.dao.IUserDao;
import xc.take.domain.PageModel;
import xc.take.domain.UserVo;
import xc.take.util.JDBCUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public void saveUser(UserVo userVo) {
		Connection connection = JDBCUtil.getConnection();
		String sql ="insert into user(u_username,u_password,u_nikename) values (?,?,?)";
		try {
			System.out.println(userVo.getNikename());
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
		String sql = "update user set u_username=?,u_password=?,u_nikename=? where u_id=?";
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
		String sql="select * from user where u_id=?";
		Connection connection = JDBCUtil.getConnection();
		UserVo userVo=new UserVo();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, id);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				 String username = rs.getString("u_username");
				 String password = rs.getString("u_password");
				 String nikename = rs.getString("u_nikename");
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
				 Long id = rs.getLong("u_id");
				 String username = rs.getString("u_username");
				 String password = rs.getString("u_password");
				 String nikename = rs.getString("u_nikename");
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
		String sql="select * from user where u_username=? and u_password=?";
		Connection connection = JDBCUtil.getConnection();
		UserVo userVo=new UserVo();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				 String username1 = rs.getString("u_username");
				 String password1 = rs.getString("u_password");
				 String nikename = rs.getString("u_nikename");
				 Long id = rs.getLong("u_id");
				 userVo.setId(id);
				 userVo.setUserName(username1);
				 userVo.setPassword(password1);
				 userVo.setNikename(nikename);
			}
			
			JDBCUtil.closeConnection(connection, pre, rs);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return userVo;
	}

	@Override
	public List<UserVo> findByPage(PageModel page) {
		String sql = "select * from  user limit ?,?";
		Connection connection = JDBCUtil.getConnection();
		List<UserVo> list= new ArrayList<UserVo>();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, Long.valueOf(page.getPageIndex()));
			pre.setLong(2, Long.valueOf(page.getPageSize()));
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				UserVo userVo=new UserVo();
				 Long id = rs.getLong("u_id");
				 String username = rs.getString("u_username");
				 String password = rs.getString("u_password");
				 String nikename = rs.getString("u_nikename");
				 userVo.setId(id);
				 userVo.setUserName(username);
				 userVo.setPassword(password);
				 userVo.setNikename(nikename);
				 list.add(userVo);
			}
			
			JDBCUtil.closeConnection(connection, pre, rs);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int findByCount() {
		String sql="select count(*) from user";
		Connection connection = JDBCUtil.getConnection();
		int count=0;
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				count= rs.getInt(1);
			}
			JDBCUtil.closeConnection(connection, pre, rs);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}
		
}

package xc.take.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xc.take.dao.IRoleVoDao;
import xc.take.domain.RoleVo;
import xc.take.util.JDBCUtil;

public class RoleVoDaoImpl implements IRoleVoDao {

	@Override
	public void saveRole(RoleVo roleVo) {
		String sql="insert into role (name) values (?)";
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, roleVo.getName());
			int index = pst.executeUpdate();
			if(index>0){
				System.out.println("添加角色成功");
			}
			
			JDBCUtil.closeConnection(connection, pst, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modifyRole(RoleVo roleVo) {
		String sql ="update role set name=?  where id=?";
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, roleVo.getName());
			
			int index = pst.executeUpdate();
			if(index>0){
				System.out.println("修改角色成功");
			}
			
			JDBCUtil.closeConnection(connection, pst, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public RoleVo findById(Long id) {
		String sql="select * from role where id=?";
		Connection connection = JDBCUtil.getConnection();
		RoleVo roleVo = new RoleVo();
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Long r_id = rs.getLong("id");
				String name = rs.getString("name");
				roleVo.setId(r_id);
				roleVo.setName(name);
			}
			JDBCUtil.closeConnection(connection, pst, rs);
			
			
			return roleVo;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public List<RoleVo> findAll() {
		String sql="select * from role ";
		Connection connection = JDBCUtil.getConnection();
		List<RoleVo> list = new ArrayList<RoleVo>();
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				RoleVo roleVo = new RoleVo();
				Long r_id = rs.getLong("id");
				String name = rs.getString("name");
				roleVo.setId(r_id);
				roleVo.setName(name);
				list.add(roleVo);
			}
			JDBCUtil.closeConnection(connection, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
		
	}

	@Override
	public List<RoleVo> findByUId(Long UId) {
		String sql = "select * from user_role where u_id=?";
		Connection connection = JDBCUtil.getConnection();
		List<RoleVo> list = new ArrayList<RoleVo>();
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, UId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Long r_id = rs.getLong("r_id");
				RoleVo roleVo = findById(r_id);
				
				list.add(roleVo);
			}
			JDBCUtil.closeConnection(connection, pst, rs);
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void addRoleByResource(Long role_id, List<Long> resourceIds) {
		String sql = "insert into role_resource (role_id,resource_id) values (?,?)";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			
			for (Long resourceId : resourceIds) {
				pst.setLong(1, role_id);
				pst.setLong(2, resourceId);
				pst.addBatch();
			}
			pst.executeBatch();
			pst.clearBatch();
			
			JDBCUtil.closeConnection(connection, pst, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

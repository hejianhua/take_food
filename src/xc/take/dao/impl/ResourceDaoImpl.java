package xc.take.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xc.take.dao.IResourceDao;
import xc.take.domain.Resource;
import xc.take.util.JDBCUtil;

public class ResourceDaoImpl implements IResourceDao {

	@Override
	public void addResource(Resource resource) {
		String sql = "insert into resource (url,name) values(?,?)";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, resource.getUrl());
			pst.setString(2, resource.getName());
			int index = pst.executeUpdate();
			if(index>0){
				System.out.println("添加资源成功");
			}
			JDBCUtil.closeConnection(connection, pst, null);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteResource(Long id) {
		String sql = "delete from resource where id=?";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, id);
			int index = pst.executeUpdate();
			if(index>0){
				System.out.println("删除资源成功");
			}
			JDBCUtil.closeConnection(connection, pst, null);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Resource> findByRoleId(Long role_Id) {
		String sql = "select * from role_resource where role_id=?";
		List<Resource> list= new ArrayList<Resource>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, role_Id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Long resourceId = rs.getLong("resource_id");
				Resource resource = findById(resourceId);
				list.add(resource);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

	

	@Override
	public List<Resource> findAll() {
		String sql = "select * from resource";
		List<Resource> list= new ArrayList<Resource>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Resource resource = new Resource();
				String url = rs.getString("url");
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				resource.setName(name);
				resource.setId(id);
				resource.setUrl(url);
				list.add(resource);
			}
			JDBCUtil.closeConnection(connection, pst, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public Resource findById(Long id) {
		String sql ="select * from  resource where id=?";
		Resource resource=null;
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				String url = rs.getString("url");
				String name = rs.getString("name");
				resource=new Resource();
				resource.setId(id);
				resource.setUrl(url);
				resource.setName(name);
			}
			
			JDBCUtil.closeConnection(connection, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return resource;
		
	}

	@Override
	public Resource findByUri(String uri) {
		String sql ="select * from  resource where url=?";
		Resource resource= null;
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, uri);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Long id = rs.getLong("id");
				String url = rs.getString("url");
				String name = rs.getString("name");
				resource= new Resource();
				resource.setId(id);
				resource.setUrl(url);
				resource.setName(name);
			}
			
			JDBCUtil.closeConnection(connection, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return resource;
	}

}

package xc.take.dao;

import java.util.List;

import xc.take.domain.Resource;

public interface IResourceDao {

	//增加资源
	public void addResource(Resource resource);
	
	//删除资源
	public void deleteResource(Long id);
	
	//根据role_id查询资源
	
	public List<Resource> findByRoleId(Long role_Id);
	
	//查询所有资源
	public List<Resource> findAll();
	//根据id查询resource
	
	public Resource findById(Long id);
	
	//根据uri查询
	
	public Resource findByUri(String uri);
}

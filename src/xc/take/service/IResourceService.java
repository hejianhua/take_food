package xc.take.service;

import java.util.List;

import xc.take.domain.Resource;

public interface IResourceService {

	 void addResource (Resource resource);
	
	 List<Resource>  findByRoleId(Long role_Id);
	 
	 Resource findById(Long id);
	 
	 List<Resource> findAll();
	 
	 //根据uri查询
	 Resource findByUri(String uri);
}

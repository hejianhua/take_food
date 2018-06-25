package xc.take.service.impl;

import java.util.List;

import xc.take.dao.IResourceDao;
import xc.take.dao.impl.ResourceDaoImpl;
import xc.take.domain.Resource;
import xc.take.service.IResourceService;

public class ResourceServiceImpl implements IResourceService{

	private IResourceDao resourceDaoImpl = new ResourceDaoImpl();
	
	@Override
	public void addResource(Resource resource) {
		
		resourceDaoImpl.addResource(resource);
	}

	@Override
	public List<Resource> findByRoleId(Long role_Id) {
		
		return resourceDaoImpl.findByRoleId(role_Id);
	}

	@Override
	public Resource findById(Long id) {
		
		return resourceDaoImpl.findById(id);
	}

	@Override
	public List<Resource> findAll() {
		
		return resourceDaoImpl.findAll();
	}

	@Override
	public Resource findByUri(String uri) {
		
		return resourceDaoImpl.findByUri(uri); 
				
	}


}

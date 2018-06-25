package xc.take.service.impl;

import java.util.List;

import xc.take.dao.IRoleVoDao;
import xc.take.dao.impl.RoleVoDaoImpl;
import xc.take.domain.RoleVo;
import xc.take.service.IRoleVoService;

public class RoleVoServiceImpl implements IRoleVoService{

	private IRoleVoDao roleVoDaoImpl=  new RoleVoDaoImpl();
	@Override
	public void saveRoleVo(RoleVo roleVo) {
		roleVoDaoImpl.saveRole(roleVo);
		
	}

	@Override
	public void modifyRoleVo(RoleVo roleVo) {
		roleVoDaoImpl.modifyRole(roleVo);
		
	}

	@Override
	public RoleVo findById(Long id) {
		
		return roleVoDaoImpl.findById(id);
	}

	@Override
	public List<RoleVo> findByUId(Long UId) {
		
		return roleVoDaoImpl.findByUId(UId);
	}

	@Override
	public List<RoleVo> findByAll() {
		
		return roleVoDaoImpl.findAll();
	}

	@Override
	public void saveRoleOfResource(Long role_id, List<Long> resourceIds) {
		 roleVoDaoImpl.addRoleByResource(role_id,  resourceIds);
		
	}

}

package xc.take.service;

import java.util.List;

import xc.take.domain.RoleVo;

public interface IRoleVoService {

	//添加角色
	void saveRoleVo(RoleVo roleVo);
	
	//修改角色
	
	void modifyRoleVo(RoleVo roleVo);
	
	//根据id查询角色、 
	
	RoleVo findById(Long id);
	
	//根据用户id查询
	List<RoleVo> findByUId(Long UId);
	
	//查询所有角色
	
	List<RoleVo> findByAll();
	
	//为角色添加资源
	void saveRoleOfResource(Long role_id,List<Long> resourceIds);
}

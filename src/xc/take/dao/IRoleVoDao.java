package xc.take.dao;

import java.util.List;

import xc.take.domain.RoleVo;

public interface IRoleVoDao {

	//添加角色
	
	void saveRole(RoleVo roleVo);
	
	//修改角色
	
	void modifyRole(RoleVo roleVo);
	
	//按id查询角色
	
	RoleVo findById(Long id);
	
	//查询所有角色
	
	List<RoleVo> findAll();
	
	//按照Uid查询角色
	List<RoleVo> findByUId(Long UId);
	
	//为角色添加资源。
	void addRoleByResource(Long role_id, List<Long> resourceIds);
	
}

package xc.take.dao;

import java.util.List;

import xc.take.domain.PageModel;
import xc.take.domain.UserVo;

public interface IUserDao {
	
	//保存用户
	void saveUser(UserVo userVo);
	
	void modifyUser(UserVo userVo);
	
	UserVo findById(Long id);
	
	List<UserVo> findAll();
	
	UserVo findByUserNameAndPassword(String username,String password);
	
	//分页查询
	List<UserVo> findByPage(PageModel page);
	//查询总记录数
	
	int findByCount();
	
	//为用户分配角色
	void saveUser_Role(Long UId , List<Long> roleIds);
	
}

package xc.take.service;

import java.util.List;

import xc.take.domain.PageModel;
import xc.take.domain.UserVo;

public interface IUserService {
	
	//注册用户
	void register(UserVo userVo);
	
	//登录
	UserVo  login (String username,String password);
	
	//列表显示
	
	List<UserVo> showList();
	
	//根据id查询
	
	UserVo findById(Long id);
	
	//分页查询
	List<UserVo> findByPage(PageModel page);
	
	//查询总记录数
	int findByCount();

	void saveUser_Role(Long UId, List<Long> roleIds);
}

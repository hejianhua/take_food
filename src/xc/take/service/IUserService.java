package xc.take.service;

import java.util.List;

import xc.take.domain.UserVo;

public interface IUserService {
	
	//注册用户
	void register(UserVo userVo);
	
	//登录
	UserVo  login (String username,String password);
	
	//列表显示
	
	List<UserVo> showList();

}

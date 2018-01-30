package xc.take.dao;

import java.util.List;

import xc.take.domain.UserVo;

public interface IUserDao {
	
	void saveUser(UserVo userVo);
	
	void modifyUser(UserVo userVo);
	
	UserVo findById(Long id);
	
	List<UserVo> findAll();
	
	UserVo findByUserNameAndPassword(String username,String password);
}

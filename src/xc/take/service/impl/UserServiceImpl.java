package xc.take.service.impl;

import java.util.List;

import xc.take.dao.IUserDao;
import xc.take.dao.impl.UserDaoImpl;
import xc.take.domain.UserVo;
import xc.take.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDaoImpl= new UserDaoImpl();
	@Override
	public void register(UserVo userVo) {
		userDaoImpl.saveUser(userVo);

	}

	@Override
	public UserVo login(String username, String password) {
		return userDaoImpl.findByUserNameAndPassword(username, password);

	}

	@Override
	public List<UserVo> showList() {
		return userDaoImpl.findAll();
	}

}

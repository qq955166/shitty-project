package johnny.dailylunchgenerator.service.impl;

import java.sql.SQLException;

import johnny.dailylunchgenerator.dao.UserDao;
import johnny.dailylunchgenerator.service.UserService;
import johnny.dailylunchgenerator.viewBean.UserBean;

public class UserServiceImpl implements UserService
{
	private UserDao userDao;

	public UserDao getUserDao()
	{
		return this.userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException
	{
		return userDao.isValidUser(username, password);
	}
	
	@Override
	public boolean isCreatedUser(String username) throws SQLException
	{
		return userDao.isCreatedUser(username);
	}
	
	@Override
	public boolean createUser(String username, String password) throws SQLException
	{
		return userDao.createUser(username, password);
	}
	
	@Override
	public int getUserIDbyName(String username) throws SQLException
	{
		return userDao.getUserIDbyName(username);
	}
	
	@Override
	public UserBean getUserByName(String username) throws SQLException
	{
		return userDao.getUserByName(username);
	}

	public UserBean getUserByID(int id) throws SQLException
	{
		return userDao.getUserByID(id);
	}
}

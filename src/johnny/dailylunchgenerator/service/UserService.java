package johnny.dailylunchgenerator.service;

import java.sql.SQLException;

import johnny.dailylunchgenerator.viewBean.UserBean;

public interface UserService
{
	public boolean isValidUser(String username, String password) throws SQLException;
	public boolean isCreatedUser(String username) throws SQLException;
	public boolean createUser(String username, String password) throws SQLException;
	public int getUserIDbyName(String username) throws SQLException;
	public UserBean getUserByName(String username) throws SQLException;
	public UserBean getUserByID(int id) throws SQLException;
}

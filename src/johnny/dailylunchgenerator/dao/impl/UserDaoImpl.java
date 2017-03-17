package johnny.dailylunchgenerator.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import johnny.dailylunchgenerator.dao.UserDao;
import johnny.dailylunchgenerator.viewBean.UserBean;

public class UserDaoImpl implements UserDao
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public DataSource getDataSource()
	{
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean isValidUser(String username, String password)
	{
		try{
			
			String query = "Select * from account where username = ? and password = ?";
			UserBean ac = jdbcTemplateObject.queryForObject(query, new Object[]{username, password}, new AccountMapper());
			
			return true;
			
		}catch(IncorrectResultSizeDataAccessException e)
		{
			return false;
		}
	}
	
	@Override
	public boolean isCreatedUser(String username)
	{
		try{
			
			String query = "Select * from account where username = ?";
			UserBean ac = jdbcTemplateObject.queryForObject(query, new Object[]{username}, new AccountMapper());
			
			return true;
			
		}catch(IncorrectResultSizeDataAccessException e)
		{
			return false;
		}
	}
	
	@Override
	public boolean createUser(String username, String password)
	{
		String SQL = "insert into account (username, password) values (?, ?)";
		int num = jdbcTemplateObject.update( SQL, username, password);
		
		return num==1;
	}
	
	@Override
	public int getUserIDbyName(String username)
	{
		String SQL = "select id from account where username=?";
		int id = jdbcTemplateObject.queryForObject( SQL, new Object[] {username}, Integer.class);
		
		return id;
	}
	
	@Override
	public UserBean getUserByName(String username)
	{
		String SQL = "select * from account where username=?";
		UserBean user = jdbcTemplateObject.queryForObject( SQL, new Object[] {username}, new AccountMapper());
		
		return user;
	}
	
	@Override
	public UserBean getUserByID(int id)
	{
		String SQL = "select * from account where id=?";
		UserBean user = jdbcTemplateObject.queryForObject( SQL, new Object[] {id}, new AccountMapper());
		
		return user;
	}

}
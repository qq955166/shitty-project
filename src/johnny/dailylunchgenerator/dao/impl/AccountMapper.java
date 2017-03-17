package johnny.dailylunchgenerator.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import johnny.dailylunchgenerator.viewBean.UserBean;

import org.springframework.jdbc.core.RowMapper;

public class AccountMapper implements RowMapper<UserBean>{

	@Override
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean ac = new UserBean();
		ac.setUsername(rs.getString("username"));
		ac.setPassword(rs.getString("password"));
		return ac;
	}

}

package johnny.dailylunchgenerator.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import johnny.dailylunchgenerator.viewBean.RestaurantBean;

import org.springframework.jdbc.core.RowMapper;

public class RestaurantMapper implements RowMapper<RestaurantBean>{

	@Override
	public RestaurantBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		RestaurantBean res = new RestaurantBean();
		res.setId(rs.getInt("id"));
		res.setUser_id(rs.getInt("user_id"));
		res.setResname(rs.getString("resname"));
		res.setAddress(rs.getString("address"));
		res.setDescription(rs.getString("description"));
		res.setFood_type(rs.getString("food_type"));
		res.setLastvisitedday(rs.getString("lastvisitedday"));
		return res;
	}

}

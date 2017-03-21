package johnny.dailylunchgenerator.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import johnny.dailylunchgenerator.dao.RestaurantDAO;
import johnny.dailylunchgenerator.viewBean.RestaurantBean;

import org.springframework.jdbc.core.JdbcTemplate;


public class RestaurantDAOImpl implements RestaurantDAO{
	
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean addRestaurant(RestaurantBean resBean) {
		String SQL = "insert into restaurant (user_id, resname, address, description, food_type) values (?, ?, ?, ?, ?)";

		int num = jdbcTemplateObject.update( SQL, resBean.getUser_id(), resBean.getResname(), resBean.getAddress(), resBean.getDescription(), resBean.getFood_type());
		return num!=0;
	}
	
	@Override
	public List<RestaurantBean> getRestaurantbyBean(RestaurantBean resBean) throws Exception{
		
		String SQL = "select * from restaurant where resname = ?";
		List<RestaurantBean> resList;
		
		resList = jdbcTemplateObject.query(SQL, new Object[]{resBean.getResname()}, new RestaurantMapper());

		return resList;
	}

	@Override
	public RestaurantBean getRestaurantbyId(int id) {
		String SQL = "select * from restaurant where id = ?";
		RestaurantBean res;
		try{
			
			res = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new RestaurantMapper());
			
		}catch(Exception e)
		{
			return null;
		}
		return res;
	}
	
	@Override
	public RestaurantBean getRestaurantbyName(String resname) {
		
		String SQL = "select * from restaurant where resname = ?";
		RestaurantBean res;
		
		try{
			res = jdbcTemplateObject.queryForObject(SQL, new Object[]{resname}, new RestaurantMapper());
		}catch(Exception e)
		{
			return null;
		}
		return res;
	}
	
	@Override
	public RestaurantBean getRestaurantByRandom(){
		
		String SQL = "select * from restaurant order by RAND() limit 1";
		RestaurantBean res;
		
		try{
			res = jdbcTemplateObject.queryForObject(SQL, new Object[]{}, new RestaurantMapper());
		}catch(Exception e)
		{
			return null;
		}
		return res;
	}
	
	@Override
	public RestaurantBean getRestaurantByRandomWithFilter(Map<String, String> filter){
		StringBuilder SQL = new StringBuilder();
		
		SQL.append("select * from restaurant where 1=1 ");
		
		for(String key: filter.keySet()){
			SQL.append("and ")
			.append(key)
			.append("='")
			.append(filter.get(key))
			.append("'");
		}
		
		SQL.append(" order by RAND() limit 1");
		
		System.out.println("SQL: " + SQL);
		
		RestaurantBean res;
		
		try{
			res = jdbcTemplateObject.queryForObject(SQL.toString(), new Object[]{}, new RestaurantMapper());
		}catch(Exception e)
		{
			return null;
		}
		return res;
	}
	
	@Override
	public int getRestaurantCount() {
		String SQL = "select count(*) from restaurant";
		int count = jdbcTemplateObject.queryForObject(SQL, Integer.class);
		return count;
	}
	
	@Override
	public List<RestaurantBean> listRestaurant() {
		String SQL = "select * from restaurant";
		List <RestaurantBean> ress = jdbcTemplateObject.query(SQL, new RestaurantMapper());
		return ress;
	}
	
	@Override
	public boolean deleteResByName(String resname){
		String SQL = "delete from restaurant where resname = ?";
		int num = jdbcTemplateObject.update(SQL, resname);
		System.out.println("Deleted Record with name = " + resname);
		return num==1;
	}
	
	@Override
	public boolean deleteResById(int id){
		String SQL = "delete from restaurant where id = ?";
		int num = jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return num==1;
	}

	@Override
	public boolean updateRestaurant(RestaurantBean resBean){
		String SQL = "update restaurant set resname = ? , address = ? , description = ? , lastvisitedday = ? , food_type = ? where id = ?";
		int num = jdbcTemplateObject.update(SQL, resBean.getResname(), resBean.getAddress(), resBean.getDescription(), resBean.getLastvisitedday(), resBean.getFood_type(), String.valueOf(resBean.getId()));
		System.out.println("Updated Record with resname = " + resBean.getResname());
		return num==1;
	}

}

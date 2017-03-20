package johnny.dailylunchgenerator.dao;

import java.util.List;
import java.util.Map;

import johnny.dailylunchgenerator.viewBean.RestaurantBean;

public interface RestaurantDAO {
	
	public boolean addRestaurant(RestaurantBean resBean);
	
	public List<RestaurantBean> getRestaurantbyBean(RestaurantBean resBean) throws Exception;
	
	public RestaurantBean getRestaurantbyId(int id);
	
	public RestaurantBean getRestaurantbyName(String resname);
	
	public RestaurantBean getRestaurantByRandom();
	
	public RestaurantBean getRestaurantByRandomWithFilter(Map<String, String> filter);
	
	public int getRestaurantCount();
	
	public List<RestaurantBean> listRestaurant();
	
	public boolean deleteResByName(String resname);
	
	public boolean deleteResById(int id);
	
	public boolean updateRestaurant(RestaurantBean resBean);

}

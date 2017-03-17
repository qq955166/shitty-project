package johnny.dailylunchgenerator.dao;

import java.util.List;
import java.util.Map;

import johnny.dailylunchgenerator.viewBean.EmployeeBean;

public interface RestaurantDAO {
	
	public boolean addRestaurant(EmployeeBean resBean);
	
	public List<EmployeeBean> getRestaurantbyBean(EmployeeBean resBean) throws Exception;
	
	public EmployeeBean getRestaurantbyId(int id);
	
	public EmployeeBean getRestaurantbyName(String resname);
	
	public EmployeeBean getRestaurantByRandom();
	
	public EmployeeBean getRestaurantByRandomWithFilter(Map<String, String> filter);
	
	public int getRestaurantCount();
	
	public List<EmployeeBean> listRestaurant();
	
	public boolean deleteResByName(String resname);
	
	public boolean deleteResById(int id);
	
	public boolean updateRestaurant(EmployeeBean resBean);

}
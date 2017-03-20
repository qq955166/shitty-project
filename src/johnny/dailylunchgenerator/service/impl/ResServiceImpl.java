package johnny.dailylunchgenerator.service.impl;

import java.util.List;
import java.util.Map;

import johnny.dailylunchgenerator.dao.RestaurantDAO;
import johnny.dailylunchgenerator.service.ResService;
import johnny.dailylunchgenerator.viewBean.RestaurantBean;

public class ResServiceImpl implements ResService
{
	private RestaurantDAO resDao;

	public RestaurantDAO getRestaurantDAO()
	{
		return this.resDao;
	}

	public void setRestaurantDAO(RestaurantDAO resDao)
	{
		this.resDao = resDao;
	}
	public boolean addRestaurant(RestaurantBean resBean)
	{
		return resDao.addRestaurant(resBean);
	}
	public List<RestaurantBean> getRestaurantbyBean(RestaurantBean resBean) throws Exception
	{
		return resDao.getRestaurantbyBean(resBean);
	}
	public RestaurantBean getRestaurantbyId(int id)
	{
		return resDao.getRestaurantbyId(id);
	}
	public RestaurantBean getRestaurantbyName(String resname)
	{
		return resDao.getRestaurantbyName(resname);
	}
	public RestaurantBean getRestaurantByRandom()
	{
		return resDao.getRestaurantByRandom();
	}
	public RestaurantBean getRestaurantByRandomWithFilter(Map<String, String> filter)
	{
		return resDao.getRestaurantByRandomWithFilter(filter);
	}
	public int getRestaurantCount()
	{
		return resDao.getRestaurantCount();
	}
	public List<RestaurantBean> listRestaurant()
	{
		return resDao.listRestaurant();
	}
	public boolean deleteResByName(String resname)
	{
		return resDao.deleteResByName(resname);
	}
	public boolean deleteResById(int id)
	{
		return resDao.deleteResById(id);
	}
	public boolean updateRestaurant(RestaurantBean resBean)
	{
		return resDao.updateRestaurant(resBean);
	}

}

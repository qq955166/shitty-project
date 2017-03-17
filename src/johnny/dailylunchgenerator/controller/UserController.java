package johnny.dailylunchgenerator.controller;

import java.sql.SQLException;
import java.util.List;

import johnny.dailylunchgenerator.service.ResService;
import johnny.dailylunchgenerator.service.UserService;
import johnny.dailylunchgenerator.viewBean.EmployeeBean;
import johnny.dailylunchgenerator.viewBean.UserBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ResService resService;
	
	@RequestMapping(value="{id}/dashboard", method=RequestMethod.GET)
	public ModelAndView displayHome(@PathVariable("id") int id){
		
		ModelAndView mav = null;
		
		if(id==1)
		{
			mav = new ModelAndView("dashboard");
		}else{
			mav = new ModelAndView("user");
		}
		
		List<EmployeeBean> list = null;
		UserBean user;
		
		try {
			user = userService.getUserByID(id);
			list = resService.listRestaurant();
			mav.addObject("loggedInUser", user.getUsername());
			mav.addObject("lists", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mav;
	}

}

package johnny.dailylunchgenerator.controller;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import johnny.dailylunchgenerator.service.ResService;
import johnny.dailylunchgenerator.service.UserService;
import johnny.dailylunchgenerator.validator.restaurantValidator;
import johnny.dailylunchgenerator.viewBean.RestaurantBean;
import johnny.dailylunchgenerator.viewBean.UserBean;

@Controller
public class AddResController {
	
	private static final Logger logger = Logger.getLogger(AddResController.class);

	@Autowired
	private ResService resService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private restaurantValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/{id}/addRes", method=RequestMethod.GET)
	public ModelAndView addResHome(@PathVariable("id") int id, @ModelAttribute("resBean") RestaurantBean resBean, BindingResult result)
	{
		logger.debug("GET addRes");
		ModelAndView mav = new ModelAndView("addRes");
		
		UserBean user;
		try {
			user = userService.getUserByID(id);
			String username = user.getUsername();
			mav.addObject("loggedInUser", username);
		} catch (SQLException e) {
			logger.error("retrieve user name error: " + e.getMessage());
		}
		
		return mav;
	}
	
	@RequestMapping(value="/{id}/addRes",  params="cancel", method=RequestMethod.POST)
	public ModelAndView retrun(@PathVariable("id") int id, @RequestParam String cancel){
		
		ModelAndView mav = new ModelAndView("redirect:/"+id+"/dashboard");
		
		return mav;
		
	}
	
	@RequestMapping(value="/{id}/addRes", params="addRes", method=RequestMethod.POST)
	public ModelAndView addRes(@PathVariable("id") int id, @ModelAttribute("resBean") @Validated RestaurantBean resBean, BindingResult result)
	{
		ModelAndView mav =  null;
		String username = "";
		
		try {
			
			UserBean user = userService.getUserByID(id);
			username = user.getUsername();
			
			if(result.hasErrors()){
				logger.debug("return addRes page");
				mav = new ModelAndView("addRes");
				mav.addObject("loggedInUser", username);
				return mav;
			}
			
			mav = new ModelAndView("addRes");
			mav.addObject("loggedInUser", username);
			mav.addObject("resBean", new RestaurantBean());
		
			List<RestaurantBean> resList = resService.getRestaurantbyBean(resBean);
			
			if(resList==null || resList.size()==0){
				
				resBean.setUser_id(id);
				
				boolean isAddedSucesseded = resService.addRestaurant(resBean);
				
				if(isAddedSucesseded){
					mav.addObject("result", "Add Restaurant Sucesseded.");
					logger.debug("Add Restaurant" + resBean.toString() + " Sucesseded");
				}else{
					mav.addObject("result", "Add Restaurant Failed.");
					logger.debug("Add Restaurant" + resBean.toString() + " Failed 1");
				}
				
			}else{
				mav.addObject("result", "The restaurant is existed.");
				logger.debug("The restaurant " + resBean.getResname() + " is existed.");
			}

		} catch (Exception e) {
			mav.addObject("result", "Add Restaurant Failed.");
			mav.addObject("loggedInUser", username);
			mav.addObject("resBean", new RestaurantBean());
			logger.error("Add Restaurant" + resBean.toString() + " Failed with error: " + e.getMessage());
		}
		
		return mav;
	}
}

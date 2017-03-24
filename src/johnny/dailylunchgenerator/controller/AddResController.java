package johnny.dailylunchgenerator.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import johnny.dailylunchgenerator.service.ResService;
import johnny.dailylunchgenerator.service.UserService;
import johnny.dailylunchgenerator.viewBean.RestaurantBean;

@Controller
public class AddResController {
	
	private static final Logger logger = Logger.getLogger(AddResController.class);

	@Autowired
	private ResService resService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{id}/addRes", method=RequestMethod.GET)
	public ModelAndView addResHome(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response, RestaurantBean resBean)
	{
		ModelAndView model = new ModelAndView("addRes");
		model.addObject("resBean", new RestaurantBean());
		request.setAttribute("loggedInUser", request.getParameter("loggedInUser"));
		return model;
	}
	
	@RequestMapping(value="/{id}/action",  params="cancel", method=RequestMethod.POST)
	public ModelAndView retrun(@PathVariable("id") int id, @RequestParam String cancel){
		
		ModelAndView mav = new ModelAndView("redirect:/"+id+"/dashboard");
		
		return mav;
		
	}
	
	@RequestMapping(value="/{id}/action", params="addRes", method=RequestMethod.POST)
	public ModelAndView addRes(@PathVariable("id") int id, HttpServletRequest request, @ModelAttribute("RestaurantBean") RestaurantBean resBean, BindingResult result)
	{
		ModelAndView mav = new ModelAndView("addRes");
		String username = (String)request.getParameter("loggedInUser");
		
		try {
		
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
			logger.debug("Add Restaurant" + resBean.toString() + " Failed with error: " + e.getMessage());
		} finally{
			mav.addObject("loggedInUser", username);
			mav.addObject("resBean", new RestaurantBean());
		}
		
		return mav;
	}
}

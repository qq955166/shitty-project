package johnny.dailylunchgenerator.controller;

import johnny.dailylunchgenerator.service.ResService;
import johnny.dailylunchgenerator.service.UserService;
import johnny.dailylunchgenerator.viewBean.RestaurantBean;
import johnny.dailylunchgenerator.viewBean.UserBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UpdateResController {
	
	private static final Logger logger = Logger.getLogger(UpdateResController.class);
	
	@Autowired
	private ResService resService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/{id}/{resid}/update", method=RequestMethod.GET)
	public ModelAndView updateResHome(@ModelAttribute("resBean") RestaurantBean resBean, BindingResult result){
		
		ModelAndView mav = new ModelAndView("updateRes");
		return mav;
		
	}
	
	@RequestMapping(value="/{id}/{resid}/update", method=RequestMethod.POST)
	public ModelAndView updateRes(@PathVariable("id") int user_id, @PathVariable("resid") int resid){
		
		ModelAndView mav = new ModelAndView("updateRes");		
		RestaurantBean res;
		UserBean user;
		
		try{
			user = userService.getUserByID(user_id);
			res = resService.getRestaurantbyId(resid);
			mav.addObject("resBean", res);
			mav.addObject("loggedInUser", user.getUsername());
		}catch(Exception e){
			logger.error("post restaurant info error: " + e.getMessage());
		}
		
		return mav;
	}
	
	@RequestMapping(value="{id}/{resid}/save", params="updateRes", method=RequestMethod.POST)
	public ModelAndView saveUpdate(@PathVariable("id") int id, @PathVariable("resid") int resid, @ModelAttribute("resBean") RestaurantBean resBean, RedirectAttributes redir){
		
		ModelAndView mav = null;
		
		resBean.setId(resid);
		resBean.setUser_id(id);
		
		boolean updated = resService.updateRestaurant(resBean);
		
		if(updated){
			mav = new ModelAndView("redirect:/"+id+"/admindashboard");
			redir.addFlashAttribute("result", "update sucesseded");
			logger.debug("update sucesseded: " + resBean.toString());
			
		}else{
			mav = new ModelAndView("updateRes");
			mav.addObject("error", "update failed!");
			logger.debug("update failed: " + resBean.toString());
		}
		
		return mav;
		
	}
	
	@RequestMapping(value="{id}/{resid}/save", params="cancel", method=RequestMethod.POST)
	public ModelAndView cancelUpdate(@PathVariable("id") int id, @PathVariable("resid") int resid) {
		ModelAndView mav = new ModelAndView("redirect:/"+id+"/dashboard");
		return mav;
	}

}

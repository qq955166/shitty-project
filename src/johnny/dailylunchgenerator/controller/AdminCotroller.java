package johnny.dailylunchgenerator.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import johnny.dailylunchgenerator.service.ResService;
import johnny.dailylunchgenerator.service.UserService;
import johnny.dailylunchgenerator.viewBean.EmployeeBean;
import johnny.dailylunchgenerator.viewBean.UserBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminCotroller {
	
	@Autowired
	private ResService resService;
	
	@Autowired
	private UserService userService;

	/*@RequestMapping(value="/{id}/admindashboard", method=RequestMethod.GET)
	public ModelAndView dashboardHome(@PathVariable("id") int id, HttpServletRequest req, Model model){
		
		ModelAndView mav = new ModelAndView("dashboard");
		
		List<RestaurantBean> lists = resService.listRestaurant();
		
		UserBean user;
		
		try {
			user = userService.getUserByID(id);
			mav.addObject("loggedInUser", user.getUsername());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mav.addObject("lists", lists);
		return mav;
	}*/
	
	@RequestMapping(value="/{id}/{resid}/delete", method=RequestMethod.POST)
	public ModelAndView deleteRes(HttpServletRequest req, @PathVariable("id") int id, @PathVariable("resid") int resid, RedirectAttributes redir){
		
		ModelAndView mav = new ModelAndView("redirect:/"+id+"/admindashboard");
		
		try{
			
			EmployeeBean res = resService.getRestaurantbyId(resid);
			
			redir.addFlashAttribute("loggedInUser", req.getAttribute("loggedInUser"));
			
			boolean isdeleted = resService.deleteResById(resid);
			
			if(isdeleted){
				redir.addFlashAttribute("result", "Restaurant " + res.getResname() + " has been deleted");
				
			}else{
				redir.addFlashAttribute("result", "deletion has failed");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			redir.addFlashAttribute("result", "Oops, something is wrong.");
		}
		
		return mav;
	}
	
	/*@RequestMapping(value="/{id}/update", method=RequestMethod.POST)
	public ModelAndView updateRes(HttpServletRequest req, @PathVariable("id") int id, RedirectAttributes redir){
		
		ModelAndView mav = new ModelAndView("redirect:updateRes");
		
		RestaurantBean res = resService.getRestaurantbyId(id);
		
		mav.addObject("resname", res.getResname());
		mav.addObject("address", res.getAddress());
		mav.addObject("description", res.getDescription());
		
		redir.addFlashAttribute("resname", res.getResname());
		
		return mav;
	}*/
	
}

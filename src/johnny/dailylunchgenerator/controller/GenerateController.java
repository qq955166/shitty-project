package johnny.dailylunchgenerator.controller;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import johnny.dailylunchgenerator.service.ResService;
import johnny.dailylunchgenerator.viewBean.UserBean;
import johnny.dailylunchgenerator.viewBean.MessageBean;
import johnny.dailylunchgenerator.viewBean.RestaurantBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GenerateController {
	
	@Autowired
	private ResService resService;
	
	@RequestMapping(value="/generate", method=RequestMethod.POST)
	public ModelAndView displayResult(HttpServletRequest req){
		
		RestaurantBean res = null;
		
		if("fast".equals(req.getParameter("fastOnly"))){
			Map<String, String> map = new HashMap<String, String>();
			map.put("food_type", "fast");
			res = resService.getRestaurantByRandomWithFilter(map);
		}else
			res = resService.getRestaurantByRandom();
		
		ModelAndView  mav = new ModelAndView("login");
		mav.addObject("userBean", new UserBean());
		
		if(res!=null){
						
			req.setAttribute("res", res);
			MessageBean msg = new MessageBean();
			msg.setResname("Restaurant Name:");
			msg.setAddress("Restaurant Address:");
			msg.setDescription("Description:");
			msg.setLastvisitedday("Last Visited Day:");
			req.setAttribute("msg", msg);
			
		}else{
			mav.addObject("error", "Oops, something is wrong!");
		}
		
		return mav;
	}

	@RequestMapping(value="/{id}/checkIn", method=RequestMethod.POST)
	public ModelAndView check(@PathVariable("id") int id, RedirectAttributes redir){
		
		ModelAndView mav = new ModelAndView("redirect:/login");
		redir.addFlashAttribute("userBean", new UserBean());
		
		RestaurantBean res = resService.getRestaurantbyId(id);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date today = new Date();
		String lastvisitedday = dateFormat.format(today);
		
		res.setLastvisitedday(lastvisitedday);
		
		boolean updated = resService.updateRestaurant(res);
		
		if(updated){
			redir.addFlashAttribute("checkIn", "Check In Succeeded");
		}else{
			redir.addFlashAttribute("checkIn", "Check In Failed");
		}
		
		return mav;
	}
}

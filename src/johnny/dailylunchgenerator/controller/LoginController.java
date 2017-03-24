package johnny.dailylunchgenerator.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import johnny.dailylunchgenerator.service.UserService;
import johnny.dailylunchgenerator.validator.loginValidator;
import johnny.dailylunchgenerator.viewBean.UserBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController
{

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("loginValidator")
	private loginValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value={"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response, UserBean userBean, BindingResult result)
	{
		ModelAndView model = new ModelAndView("login");
		logger.debug("GET login");
		return model;
	}

	@RequestMapping(value="/signIn", method=RequestMethod.POST)
	public ModelAndView executeLogin(@ModelAttribute("userBean") @Validated UserBean userBean, BindingResult result, RedirectAttributes redir)
	{
		
		ModelAndView mav= null;
		
		if(result.hasErrors()){
			List<FieldError> errors = result.getFieldErrors();
		    for (FieldError error : errors ) {
		    	logger.debug(error.getObjectName() + " - " + error.getDefaultMessage());
		    }
			logger.debug("Returning login page");
			mav = new ModelAndView("login");
			return mav;
		}
		
		String username = (String)userBean.getUsername();
		String password = (String)userBean.getPassword();

		try
		{
			boolean isValidUser = userService.isValidUser(username, password);
			if(isValidUser)
			{
				int id = userService.getUserIDbyName(username);
	
				mav = new ModelAndView("redirect:"+id+"/dashboard");
				
				logger.debug("User " + username + " logined.");
				
				redir.addFlashAttribute("loggedInUser", username);
			}
			else
			{
				mav = new ModelAndView("login");
				mav.addObject("userBean", new UserBean());
				mav.addObject("message", "Invalid credentials!!");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value="/createUser")
	public ModelAndView openCreateUserPage(UserBean userBean, BindingResult result){
		
		ModelAndView mav = new ModelAndView("createUser");		
		return mav;
		
	}
	
	@RequestMapping(value="/createUser/submit", method=RequestMethod.POST)
	public ModelAndView createUser(HttpServletRequest request, @ModelAttribute("userBean") @Validated UserBean userBean, BindingResult result){

		ModelAndView mav = null;
		
		if(result.hasErrors()){
			logger.debug("Returning create user page");
			mav = new ModelAndView("createUser");
			return mav;
		}

		String username = userBean.getUsername();
		String password = userBean.getPassword();

		try {

			boolean isCreatedUser = userService.isCreatedUser(username);

			if(!isCreatedUser && userService.createUser(username, password)){
				mav = new ModelAndView("login");
				mav.addObject("userBean", new UserBean());
				request.setAttribute("message", "Created account sucesseded");
			}else{
				mav = new ModelAndView("login");
				mav.addObject("userBean", new UserBean());
				request.setAttribute("message", "The account has been existed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mav;
	}
}

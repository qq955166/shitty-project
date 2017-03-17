package johnny.dailylunchgenerator.validator;

import johnny.dailylunchgenerator.viewBean.UserBean;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class loginValidator implements Validator{
	
	private static final Logger logger = Logger.getLogger(loginValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		return UserBean.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userBean.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userBean.password");
		
		logger.debug("Login validation");
		
	}

}

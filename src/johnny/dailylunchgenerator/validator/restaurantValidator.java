package johnny.dailylunchgenerator.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import johnny.dailylunchgenerator.viewBean.RestaurantBean;

@Component
public class restaurantValidator implements Validator{
	
	private final static Logger logger = Logger.getLogger(restaurantValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		return RestaurantBean.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resname", "NotEmpty.resBean.resname");
		
		logger.debug("Restaurant validation");
	}

}

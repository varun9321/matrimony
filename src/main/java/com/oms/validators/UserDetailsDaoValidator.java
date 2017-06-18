package com.oms.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartFile;

import com.oms.dao.UserDetailsDao;
import com.oms.entity.User;
import com.oms.repository.UserRepository;



@Component
public class UserDetailsDaoValidator extends LocalValidatorFactoryBean {

	private UserRepository userRepository;

	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserDetailsDao.class);
	}

	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {

		super.validate(obj, errors, validationHints);

		if (!errors.hasErrors()) {
			UserDetailsDao signupForm = (UserDetailsDao) obj;
			User user = userRepository.findUserByEmail(signupForm.getEmail());
			MultipartFile file = signupForm.getFile();

			if (user != null)
				errors.rejectValue("email", "emailNotUnique");
			if (file == null)
				errors.rejectValue("file", "fileempty");
			
		}
	}

}

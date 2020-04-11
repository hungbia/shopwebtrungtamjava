package com.hungbia.shopweb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hungbia.shopweb.model.UserDTO;

@Component // khoi tao bean viladtor
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);// kiem tra xem doi tuong truyen vao la doi tuong user
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;
		if (userDTO.getName() == null || userDTO.getUsername().length() == 0) {
			errors.rejectValue("name", "my.name");

		}
		ValidationUtils.rejectIfEmpty(errors, "password", "my.name");
		if (userDTO.getPassword().length() < 3 || userDTO.getPassword().length() > 12) {
			errors.rejectValue("password", "my.pass");
		}

	}
}

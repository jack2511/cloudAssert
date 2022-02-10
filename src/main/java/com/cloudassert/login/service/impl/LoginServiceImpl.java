package com.cloudassert.login.service.impl;

import org.springframework.stereotype.Service;

import com.cloudassert.login.dto.ResponseDto;
import com.cloudassert.login.dto.UserDataDto;
import com.cloudassert.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public ResponseDto validateLoginData(UserDataDto userData) {

		ResponseDto response;
		String username = userData.getUsername();
		String password = userData.getPassword();

		if (username != null && password != null) {

			// Validating the password length
			if (3 >= password.length()) {
				response = new ResponseDto(422, "Password is too short!");
				return response;
			}

			// Validating for username in given password
			Boolean isUsernameExist = password.toLowerCase().contains(username.toLowerCase());
			if (isUsernameExist) {
				response = new ResponseDto(422, "Password should not have username!");
				return response;
			}

			// Check password for repeated characters
			Boolean isPasswordValid = validatePassword(password);

			if (!isPasswordValid) {
				response = new ResponseDto(422, "Password is not Valid. It has repeated 3 characters!");
				return response;
			} else {
				response = new ResponseDto(201, "Given credentials are valid!");
				return response;
			}

		} else {
			response = new ResponseDto(422, "Credentials cannot be null!");
			return response;
		}
	}

	/**
	 * Method to check for repeated characters
	 * @param password
	 * @return true if valid
	 */
	private Boolean validatePassword(String password) {

		String[] passwordChars = password.split("");

		for (int i = 0; i < passwordChars.length - 5; i++) {
			if (passwordChars[i].equals(passwordChars[i + 3]) && passwordChars[i + 1].equals(passwordChars[i + 4])
					&& passwordChars[i + 2].equals(passwordChars[i + 5])) {
				return false;
			}
		}
		
		return true;
	}
	
}

package com.cloudassert.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudassert.login.dto.ResponseDto;
import com.cloudassert.login.dto.UserDataDto;
import com.cloudassert.login.service.LoginService;

/**
 * Controller for Login Module
 * 
 * @author Jagadesh
 *
 */
@RequestMapping("/")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/credentials")
	public ResponseEntity<String> loginController(@RequestBody UserDataDto userData) {

		ResponseDto response = loginService.validateLoginData(userData);

		if (response.getCode() == 201) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response.getReason());
		} else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response.getReason());
		}
	}
}

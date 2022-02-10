package com.cloudassert.login.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloudassert.login.dto.ResponseDto;
import com.cloudassert.login.dto.UserDataDto;

/**
 * Test class for login credential
 * @author Jagadesh
 *
 */
@RunWith(SpringRunner.class)
public class LoginServiceImplTest {
	
	@InjectMocks
	private LoginServiceImpl loginService = new LoginServiceImpl();

	
	@SuppressWarnings("deprecation")
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testValidateLoginData_Should_return_validResponse() {
		
		UserDataDto userdata = new UserDataDto("user1","pass123pass123");
		ResponseDto response = loginService.validateLoginData(userdata);
		assertEquals(response.getCode(), 201);
		assertTrue(response.getReason().equals("Given credentials are valid!"));
		
	}
	

	@Test
	public void testValidateLoginData_Should_return_InvalidResponse_for_Small_Password() {
		
		UserDataDto userdata = new UserDataDto("user1","pwd");
		ResponseDto response = loginService.validateLoginData(userdata);
		assertEquals(response.getCode(), 422);
		assertTrue(response.getReason().equals("Password is too short!"));
	}
	
	@Test
	public void testValidateLoginData_Should_return_InvalidResponse_for_null_credentials() {
		
		UserDataDto userdata = new UserDataDto("user1", null);
		ResponseDto response = loginService.validateLoginData(userdata);
		assertEquals(response.getCode(), 422);
		assertTrue(response.getReason().equals("Credentials cannot be null!"));
	}
	
	@Test
	public void testValidateLoginData_Should_return_InvalidResponse_for_username_in_password() {
		
		UserDataDto userdata = new UserDataDto("test","test");
		ResponseDto response = loginService.validateLoginData(userdata);
		assertEquals(response.getCode(), 422);
		assertTrue(response.getReason().equals("Password should not have username!"));
	}
	
	@Test
	public void testValidateLoginData_Should_return_InvalidResponse_for_username_in_password_anyCase() {
		
		UserDataDto userdata = new UserDataDto("Test","teSt");
		ResponseDto response = loginService.validateLoginData(userdata);
		assertEquals(response.getCode(), 422);
		assertTrue(response.getReason().equals("Password should not have username!"));
		
	}
	
	@Test
	public void testValidateLoginData_Should_return_InvalidResponse_for_repeatedChars() {
		
		UserDataDto userdata = new UserDataDto("user1","pass123123");
		ResponseDto response = loginService.validateLoginData(userdata);
		assertEquals(response.getCode(), 422);
		assertTrue(response.getReason().equals("Password is not Valid. It has repeated 3 characters!"));
		
	}
	
	@Test
	public void testValidateLoginData_Should_return_InvalidResponse_for_repeatedCharacters() {
		
		UserDataDto userdata = new UserDataDto("user1","usertestest");
		ResponseDto response = loginService.validateLoginData(userdata);
		assertEquals(response.getCode(), 422);
		assertTrue(response.getReason().equals("Password is not Valid. It has repeated 3 characters!"));
		
	}
	
	
}

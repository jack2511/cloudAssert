package com.cloudassert.login.service;

import com.cloudassert.login.dto.ResponseDto;
import com.cloudassert.login.dto.UserDataDto;

/**
 * Service Interface for Login module
 * s
 * @author Jagadesh
 *
 */
public interface LoginService {
	
	ResponseDto validateLoginData(UserDataDto userData);

}

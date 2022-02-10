package com.cloudassert.login;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cloudassert.login.service.impl.LoginServiceImplTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginServiceImplTest.class})
class LoginApplicationTests {

	@Test
	void contextLoads() {
	}

}

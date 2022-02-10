package com.cloudassert.login;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LoginApplication.class);
		// Setting custom port for the application
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8084"));
        app.run(args);
	}

}

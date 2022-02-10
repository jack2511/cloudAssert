package com.cloudassert.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Response Class
 * 
 * @author Jagadesh
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDto {

	private int code;
	
	private String reason;
}

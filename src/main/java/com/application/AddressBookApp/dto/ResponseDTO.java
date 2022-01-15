package com.application.AddressBookApp.dto;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 * 
 */
@Data

public class ResponseDTO {
	public String message;
	public Object data;
	public HttpStatus httpStatus;

	public ResponseDTO(String message, Object data, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.data = data;
		this.httpStatus = httpStatus;
	}

	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

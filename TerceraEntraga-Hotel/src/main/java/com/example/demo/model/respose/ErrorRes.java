package com.example.demo.model.respose;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorRes {
	HttpStatus httpstatus;
	String mensaje;
	
	

}

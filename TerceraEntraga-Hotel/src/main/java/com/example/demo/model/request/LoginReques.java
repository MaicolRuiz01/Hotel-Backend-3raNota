package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginReques {
	private String username;
	private String password;

}

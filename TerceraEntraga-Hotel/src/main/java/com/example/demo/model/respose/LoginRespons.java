package com.example.demo.model.respose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRespons {
	private String email;
    private String token;

}

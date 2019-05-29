package com.peng.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peng.web.domain.User;

/**
 * User{@link User}
 * 
 * @author Peng
 * @date:2019��5��20�� ����10:13:59  
 */
@RestController
public class UserRestController {
	
	@PostMapping("/echo/user")
	public User user(@RequestBody User user){
		return user;
	}
}

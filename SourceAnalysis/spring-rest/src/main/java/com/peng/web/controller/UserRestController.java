package com.peng.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peng.web.domain.User;

/**
 * User{@link User}
 * 
 * @author Peng
 * @date:2019年5月20日 上午10:13:59  
 */
@RestController
public class UserRestController {
	
	@PostMapping("/echo/user")
	public User user(@RequestBody User user){
		return user;
	}
}

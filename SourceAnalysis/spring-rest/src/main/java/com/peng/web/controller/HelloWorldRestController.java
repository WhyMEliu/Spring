package com.peng.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld {@link RestController}
 * 
 * @author Peng
 * @date:2019��5��19�� ����8:37:11  
 */
@RestController
public class HelloWorldRestController {
	
	@GetMapping(value = "/hello-world")
	public String helloWorld(@RequestParam(required = false) String message){
		return "Hello,World!";
	}
}

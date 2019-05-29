package com.peng.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld {@link RestController}
 * 
 * @author Peng
 * @date:2019年5月19日 下午8:37:11  
 */
@RestController
public class HelloWorldRestController {
	
	@GetMapping(value = "/hello-world")
	public String helloWorld(@RequestParam(required = false) String message){
		return "Hello,World!";
	}
}

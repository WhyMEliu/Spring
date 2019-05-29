package com.peng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Peng
 * @date:2019年5月20日 下午4:21:08  
 */
@Controller
public class HelloWorldController {
	
	@RequestMapping("")
	public String index(){
		return "index";
	}
}

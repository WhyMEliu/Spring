package com.peng.web.controller;

import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Peng
 * @date:2019年5月20日 下午4:23:42  
 */
//@RestController
@Controller
public class PropertiesRestController {
	
	@PostMapping(value = "/add/props",
			consumes ="text/properties;charset=UTF-8")
	public Properties addProperties(
			//@RequestBody
			Properties properties){
		return properties;
	}
}

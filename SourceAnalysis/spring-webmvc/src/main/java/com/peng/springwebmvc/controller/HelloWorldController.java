package com.peng.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Peng
 * @date:2019年5月14日 下午4:42:31  
 */
@Controller
public class HelloWorldController {
	
	@RequestMapping("")
	public String index(@RequestParam int value, Model model){
		model.addAttribute("message","Hello,World~");
		return "index";
	}
}

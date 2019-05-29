package com.peng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloWorld {@link Controller}
 * @author Peng
 * @date:2019��5��16�� ����8:53:13  
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestParam(required = false,defaultValue = "0") int value, Model model) {
        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world"; // View �߼�����
    }

    @ModelAttribute("message")
    public String message() {
        return "HelloWorld";
    }
}

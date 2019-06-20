package com.peng.controller;

import com.peng.beans.AutoWired;
import com.peng.service.SalaryService;
import com.peng.web.mvc.Controller;
import com.peng.web.mvc.RequestMapping;
import com.peng.web.mvc.RequestParam;

/**
 * @Authror LP
 * @Date 2019/6/19 16:57
 */
@Controller
public class SalaryController {

    @AutoWired
    private SalaryService salaryService;

    @RequestMapping("/get_salary.json")
    public Integer getSalary(@RequestParam("name") String name,
                             @RequestParam("experience") String experience){
        System.out.println("experience:"+experience);
        return salaryService.calSalary(Integer.valueOf(experience));
    }
}

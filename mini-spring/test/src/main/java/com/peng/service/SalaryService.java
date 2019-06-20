package com.peng.service;

import com.peng.beans.Bean;

/**
 * @Authror LP
 * @Date 2019/6/20 18:17
 */
@Bean
public class SalaryService {
    public Integer calSalary(Integer experience){
        return experience * 1000;
    }
}

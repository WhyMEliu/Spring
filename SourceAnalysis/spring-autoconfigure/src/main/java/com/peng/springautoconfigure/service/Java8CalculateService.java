package com.peng.springautoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Peng
 * @date:2019年5月10日 下午11:07:37  
 */
@Profile("Java8")
@Service
public class Java8CalculateService implements CalculateService {

	@Override
	public Integer sum(Integer... values) {
		System.out.println("Java8 for lambda实现");
		return 1;
	}

}

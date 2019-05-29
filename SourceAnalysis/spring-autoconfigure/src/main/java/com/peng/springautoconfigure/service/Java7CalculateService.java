package com.peng.springautoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Peng
 * @date:2019年5月10日 下午11:07:37  
 */
@Profile("Java7")
@Service
public class Java7CalculateService implements CalculateService {

	@Override
	public Integer sum(Integer... values) {
		System.out.println("Java7 for 循环实现");
		return 0;
	}

}

package com.peng.springautoconfigure.repository;

import com.peng.springautoconfigure.annotation.SencondLevelRepository;

/**
 * 注解层次关系，及派生~
 * 
 * @author Peng
 * @date:2019年5月10日 下午10:35:41  
 */
@SencondLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
	
}

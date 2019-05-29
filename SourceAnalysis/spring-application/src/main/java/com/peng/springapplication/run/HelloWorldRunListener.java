package com.peng.springapplication.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * HelloWorld {@link SpringApplicationRunListener}
 * 
 * @author Peng
 * @date:2019年5月11日 下午11:05:10  
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

	
    public HelloWorldRunListener(SpringApplication application, String[] args) {

    }
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.SpringApplicationRunListener#starting()
	 */
	@Override
	public void starting() {
		
		System.out.println("HelloWorldRunListener.starting()~~~");
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.SpringApplicationRunListener#environmentPrepared(org.springframework.core.env.ConfigurableEnvironment)
	 */
	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.SpringApplicationRunListener#contextPrepared(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.SpringApplicationRunListener#contextLoaded(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.SpringApplicationRunListener#started(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void started(ConfigurableApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.SpringApplicationRunListener#running(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void running(ConfigurableApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.SpringApplicationRunListener#failed(org.springframework.context.ConfigurableApplicationContext, java.lang.Throwable)
	 */
	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		// TODO Auto-generated method stub
		
	}
	
}

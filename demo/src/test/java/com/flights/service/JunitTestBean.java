package com.flights.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
public class JunitTestBean {

	@Autowired
	TestBean testBean;

	@Autowired
	@Qualifier("myBean")
	TestBean myBean;
	
	public void test() {
		
		Assert.assertNotNull(testBean);
		Assert.assertNotNull(myBean);
		Assert.assertFalse(testBean == myBean);
		Assert.assertFalse(testBean.test == myBean.test);
	}
	
}

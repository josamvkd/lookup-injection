package com.josamtechie.lookupInjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class LookupInjectionApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void singletonBeanScopeTest(){
    UserService userService1 = context.getBean("userService",UserService.class);
    UserService userService2 = context.getBean("userService",UserService.class);
		Assertions.assertEquals(userService1.hashCode(),userService2.hashCode());
	}

	@Test
	public void prototypeBeanScopeTest(){
		WeatherService weatherService1 = context.getBean("weatherService",WeatherService.class);
		WeatherService weatherService2 = context.getBean("weatherService",WeatherService.class);
		Assertions.assertNotEquals(weatherService1.hashCode(),weatherService2.hashCode());
	}


}

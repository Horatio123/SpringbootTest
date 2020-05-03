package com.baimahu.SpringbootBasic;

import com.baimahu.SpringbootBasic.bean.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringbootBasicApplicationTests {
	@Autowired
	Person person;
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoad() {
		System.out.println(person);
		logger.info(person.toString());
	}

	@Test
	public void testLog() {
		//log level from low to high
		logger.trace("this is trace log");
		logger.debug("this is debug log");
		logger.info("this is info log");
		logger.warn("this is warning log");
		logger.error("this is error log");
	}

	@Test
	public void testDog() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Dog spike = (Dog)ctx.getBean("dog");
		Dog dudu = (Dog)ctx.getBean("dog-dudu");
		System.out.println(ctx.containsBean("dog"));
		System.out.println(spike);
		System.out.println(dudu);
	}

	@Test
	public void dynamicProxy() {
		Calculator target = new CalculatorImpl();
		Calculator proxy = new CalculatorLoggingProxy(target).getLoggingProxy();
		proxy.add(2, 3);
		proxy.sub(9, 1);
	}

	@Test
	public void testAOP() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Calculator calculator = ctx.getBean(Calculator.class);

		System.out.println(calculator.add(2, 9));

	}


}

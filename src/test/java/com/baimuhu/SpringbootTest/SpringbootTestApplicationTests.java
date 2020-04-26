package com.baimuhu.SpringbootTest;

import com.baimuhu.SpringbootTest.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootTestApplicationTests {
	@Autowired
	Person person;
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoad() {
		System.out.println(person);
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

}

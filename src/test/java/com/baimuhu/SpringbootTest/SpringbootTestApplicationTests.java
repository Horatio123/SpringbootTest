package com.baimuhu.SpringbootTest;

import com.baimuhu.SpringbootTest.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootTestApplicationTests {
	@Autowired
	Person person;

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoad() {
		System.out.println(person);
	}

}

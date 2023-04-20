package com.example.demo;

import com.example.demo.controller.DemoController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	DemoController demoController;
	@Test
	void contextLoads() {

		Assertions.assertThat(demoController).isNot(null);
	}
}

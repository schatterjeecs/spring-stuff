package org.sc.storeservice;

import org.junit.jupiter.api.Test;
import org.sc.storeservice.controllers.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class StoreserviceApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	BookController bookController;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetControllerFromCtx() {
		BookController bookController = applicationContext.getBean(BookController.class);

		System.out.println(bookController.healthCheck());
	}

	@Test
	void testAutowireController() {
		System.out.println(bookController.healthCheck());
	}



}

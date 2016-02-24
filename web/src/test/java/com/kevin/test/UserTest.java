package com.kevin.test;


import com.kevin.model.User;

import com.kevin.model.UserInfo;
import com.kevin.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserTest {

	private UserService userService;

	@Autowired
	private User user;

	@Autowired
	private UserInfo userInfo;

	@Before
	public void before(){                                                                    
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/ApplicationContext.xml"
				,"classpath:conf/spring-mybatis.xml"});
		userService = (UserService) context.getBean("userServiceImpl");
		user = (User) context.getBean("user");
	}
	
	@Test
	public void addUser(){
//		User user = new User();
		user.setId(89);
		user.setNickname("morning");
		user.setState(3);
		System.out.println(userService.insertUser(user));
	}


	@Test
	public void selectUser(){
		user = userService.findUser(10);
		System.out.println(user.getNickname());
	}


	@Test
	public void testAutowired(){
		userInfo.setUserId(1);
	}
}

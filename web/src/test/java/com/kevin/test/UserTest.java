package com.kevin.test;


import com.kevin.model.BaseNoticeMessage;
import com.kevin.model.User;

import com.kevin.model.UserInfo;
import com.kevin.service.BaseNoticeService;
import com.kevin.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserTest {

	private UserService userService;
	private BaseNoticeService baseNoticeService;

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
		baseNoticeService = (BaseNoticeService)context.getBean("baseNoticeServiceImpl");
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
		List<User> users = new ArrayList<User>();
		users = userService.findUser();
		for (User u:users)
			System.out.println(u.getNickname());
	}

	@Test
	public void testInsertNoticeMsg(){
		BaseNoticeMessage callboardMessage1 = new BaseNoticeMessage();
		callboardMessage1.setUserId(1);
		callboardMessage1.setDesId(3);
		callboardMessage1.setSendDate(new Date());
		callboardMessage1.setCategoryId(1);
		callboardMessage1.setDate(new Date());
		callboardMessage1.setDetail("content1");
		callboardMessage1.setTitle("title1");
		callboardMessage1.setPlace("地区");
		callboardMessage1.setUp(10);
		callboardMessage1.setDown(13);
		baseNoticeService.insertNoticeMessage(callboardMessage1);
	}

	@Test
	public void testGetNoticeMsg(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		List<BaseNoticeMessage> baseNoticeMessages = baseNoticeService.getNoticeMessage(1,2,1);
		for (BaseNoticeMessage b:baseNoticeMessages){
//			String reportDate = df.format(b.getDate());
//			System.out.println(reportDate);
			System.out.println(b.getUserName());
			System.out.println(b.getCategoryId());
			System.out.println(b.getUserId());
			System.out.println(b.isVoted());
		}
	}

	@Test
	public void testDate(){
		baseNoticeService.insertNoticePraise(1,5);
	}
}

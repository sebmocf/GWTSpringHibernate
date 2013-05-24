package com.marthym.oikonomos.server.services;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.marthym.oikonomos.client.services.UserService;
import com.marthym.oikonomos.shared.model.User;

@ContextConfiguration(locations={"classpath:/applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserService {
	public static final String USER_ID = "";
	public static final String USER_FIRSTNAME = "";
	public static final String USER_LASTNAME = "";
	public static final String USER_PASSWORD = "";
	public static final Date USER_REGISTERED = new Date();
	public static final Date USER_LASTLOGIN = new Date();
	

	@Autowired
	private UserService userService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("------------TestUserService: start -------");		
	}
	
	@Test
	public void testSaveUser() {
		try {
			userService.saveUser(USER_ID, USER_FIRSTNAME, USER_LASTNAME, USER_PASSWORD, USER_REGISTERED, USER_LASTLOGIN);
		} catch (Exception e) {
			fail(e.getClass()+": "+e.getLocalizedMessage());
		}
	}

	@Test
	public void testFindUser() {
		User user = userService.findUser("marthym");
		assertNotNull(user);
		assertEquals(user.getUserFirstname(), USER_FIRSTNAME);
		System.out.println(user);
	}

	@Test
	public void testUpdateUser() {
		try {
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 2);
		
			userService.updateUser(USER_ID, USER_FIRSTNAME, USER_LASTNAME, USER_PASSWORD, calendar.getTime());
		} catch (Exception e) {
			fail(e.getClass()+": "+e.getLocalizedMessage());
		}
	}

	@Test
	public void testSaveOrUpdateUser() {
		try {
			userService.saveOrUpdateUser(USER_ID, USER_FIRSTNAME, USER_LASTNAME, USER_PASSWORD, USER_REGISTERED, USER_LASTLOGIN);
		} catch (Exception e) {
			fail(e.getClass()+": "+e.getLocalizedMessage());
		}
	}

	@Test
	public void testDeleteUser() {
		try {
			userService.deleteUser(USER_ID);
		} catch (Exception e) {
			fail(e.getClass()+": "+e.getLocalizedMessage());
		}
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("------------TestUserService: end -------");
	}
	
}

package com.lrn.sb.restservices.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lrn.sb.restservices.model.User;
import com.lrn.sb.restservices.service.UserService;

public class UserResourceMockitoTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserResource userResource;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getUserTest() {
		User user = new User(1,"2018-01-01", "testuser");
		when(userService.getUser(anyInt())).thenReturn(user);

		User userReturn = userResource.getUser(1);
		verify(userService, times(1)).getUser(anyInt());
		assertTrue(user.getId()==userReturn.getId());
		assertTrue(user.getDob().equalsIgnoreCase(userReturn.getDob()));
		assertTrue(user.getName().equalsIgnoreCase(userReturn.getName()));


	}


}

package com.sample.springJDBCDemo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sample.springJDBCDemo.model.User;
import com.sample.springJDBCDemo.service.DemoService;

@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {
    
	@Mock
	DemoService demoService;

	@InjectMocks
	DemoController demoController;

	@Test
	public void testSaveUser(){
		User expectedOutput = new User(1, "Dummy", "Pune");
		when(demoService.saveUser(expectedOutput)).thenReturn(expectedOutput);
		User actualOutput = demoController.saveUser(expectedOutput);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testGetAllUser(){
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "Jayesh", "Pune"));
		userList.add(new User(2, "Supriya", "Mumbai"));
		userList.add(new User(3, "Naushad", "Delhi"));

		when(demoService.getAllUser()).thenReturn(userList);
		List<User> actulList = demoController.getAllUser();

		assertEquals(userList, actulList);
	}

	@Test
	public void testGetUserById(){
		User expectedUser = new User(1, "Jayesh", "Pune");
		when(demoService.getUserById(1)).thenReturn(expectedUser);
		User actualUser = demoController.getUserById(1);
		assertEquals(expectedUser, actualUser);
	}

	@Test
	public void testUpdatedUser(){
		User updatedUser = new User(1, "Dummy", "Pune");
		when(demoService.updateUser(updatedUser)).thenReturn(updatedUser);
		User actualUser = demoService.updateUser(updatedUser);
		assertEquals(updatedUser, actualUser);
	}

	@Test
	public void testDeleteUser(){
		int userIdToDelete = 1;
		doNothing().when(demoService).deleteUserById(userIdToDelete);
		demoController.deleteUser(userIdToDelete);
		verify(demoService).deleteUserById(userIdToDelete);
	}
}

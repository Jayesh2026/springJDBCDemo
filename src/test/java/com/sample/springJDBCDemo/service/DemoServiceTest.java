package com.sample.springJDBCDemo.service;

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
import com.sample.springJDBCDemo.repository.DemoRepository;

@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

   @Mock
    DemoRepository demoRepository;

    @InjectMocks
    DemoService demoService;

    @Test
    public void testSaveUser(){
        User expectedOutput = new User(105, "Dummy", "Delhi");
        when(demoRepository.saveUser(expectedOutput)).thenReturn(expectedOutput);
        User actualOutput = demoService.saveUser(expectedOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    
    @Test
    public void testGetAllUser() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "Jayesh", "Pune"));
        userList.add(new User(2, "Supriya", "Mumbai"));
        userList.add(new User(3, "Naushad", "Delhi"));

        when(demoRepository.getAllUsers()).thenReturn(userList);
        List<User> actulList = demoService.getAllUser();

        assertEquals(userList, actulList);
    }

    @Test
    public void testGetUserById() {
        User expectedUser = new User(1, "Jayesh", "Pune");
        when(demoRepository.getUserById(1)).thenReturn(expectedUser);
        User actualUser = demoService.getUserById(1);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testUpdatedUser() {
        User updatedUser = new User(1, "Dummy", "Pune");
        when(demoRepository.updateUser(updatedUser)).thenReturn(updatedUser);
        User actualUser = demoService.updateUser(updatedUser);
        assertEquals(updatedUser, actualUser);
    }

    @Test
    public void testDeleteUser() {
        int userIdToDelete = 1;
        doNothing().when(demoRepository).deleted(userIdToDelete);
        demoService.deleteUserById(userIdToDelete);
        verify(demoRepository).deleted(userIdToDelete);
    }
    


}

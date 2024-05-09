package com.sample.springJDBCDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springJDBCDemo.Model.User;
import com.sample.springJDBCDemo.Repository.DemoRepository;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;
    
    public User saveUser(User user) {
        return demoRepository.saveUser(user);
    }

    public User getUserById(int id){
        return demoRepository.getUserById(id);
    }

    public List<User> getAllUser(){
        List<User> users = demoRepository.getAllUsers();
        return users;
    }

    public User updateUser(User user){
        return demoRepository.updateUser(user);
    }

    public void deleteUserById(int id){
        demoRepository.deleted(id);
    }

}

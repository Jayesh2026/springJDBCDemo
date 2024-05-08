package com.sample.springJDBCDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Model.User;
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
        return demoRepository.getAllUsers();
    }

    public void updateUser(User user){
        demoRepository.updateUser(user);
    }

    public User deleteUserById(int id){
        return demoRepository.deleted(id);
    }

}

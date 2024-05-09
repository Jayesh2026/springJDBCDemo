package com.sample.springJDBCDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springJDBCDemo.Model.User;
import com.sample.springJDBCDemo.Service.DemoService;

@RestController
public class DemoController {
    
    @Autowired
    DemoService demoService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        User userSaved = demoService.saveUser(user);
        return userSaved;
    }

    public List<User> getAllUser(){
        List<User> userList = demoService.getAllUser();
        return userList;
    }

    @GetMapping("/getUser-byId/{id}")
    public User getUserById(@PathVariable int id) {
        return demoService.getUserById(id);
    }
    
    @PutMapping("update-user/{id}")
    public User updateUser(@PathVariable int id, @RequestParam("name") String name, @RequestParam("city") String city) {
        User updatedUser = new User(id, name, city);
        demoService.updateUser(updatedUser);
        return updatedUser;
    }

    @DeleteMapping("/delete-user")
    public void deleteUser(@RequestParam("id") int id){
        demoService.deleteUserById(id);
    }

    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }
}

package com.sample.springJDBCDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Model.User;
import com.sample.springJDBCDemo.Service.DemoService;

@RestController
public class DemoController {
    
    @Autowired
    DemoService demoService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        demoService.saveUser(user);
        String mssg = user.getName()+" your account created succefully!!!!";
        return ResponseEntity.status(HttpStatus.CREATED).body(mssg);
    }


    @GetMapping("/getAll-user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = demoService.getAllUser();
        if(userList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userList);
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
}

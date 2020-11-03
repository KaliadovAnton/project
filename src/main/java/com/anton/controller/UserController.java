package com.anton.controller;

import com.anton.model.User;
import com.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getListOfUsers(){
        List<User> users = userService.getListOfUsers();
        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, User user){

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
}

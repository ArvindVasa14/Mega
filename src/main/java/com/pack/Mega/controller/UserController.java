package com.pack.Mega.controller;

import com.pack.Mega.model.User;
import com.pack.Mega.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<?> addUsers(@RequestBody List<User> users){
        return new ResponseEntity<>(userService.addUsers(users), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}

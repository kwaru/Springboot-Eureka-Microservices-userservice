package com.moreece.userservice.Controller;

import com.moreece.userservice.Entity.User;
import com.moreece.userservice.Service.UserServiceImpl;
import com.moreece.userservice.ValueObject.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){


log.info("Inside create new user");
        return  ResponseEntity.ok().body(userService.createUser(user));
    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<User> getUser(@RequestParam("userEmail") String userEmail){
        log.info("Inside get new user");
        return  ResponseEntity.ok().body(userService.getUser(userEmail));
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        log.info("Inside get users");
        return  ResponseEntity.ok().body(userService.getUsers());
    }


    @GetMapping("/{userEmail}/")
    public ResponseEntity<ResponseObject> getUserswithDepartment(@PathVariable("userEmail") String userEmail){
        log.info("Inside get users with departments");
        return  ResponseEntity.ok().body(userService.getuserwithdeparment(userEmail));
    }
}

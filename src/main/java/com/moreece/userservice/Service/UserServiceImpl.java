package com.moreece.userservice.Service;

import com.moreece.userservice.Entity.User;
import com.moreece.userservice.Repository.UserRepository;
import com.moreece.userservice.ValueObject.Department;
import com.moreece.userservice.ValueObject.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface{
    private  UserRepository userRepository;


    private RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl( UserRepository userRepository,RestTemplate restTemplate){
        this.userRepository = userRepository;
        this.restTemplate= restTemplate;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByEmailAddress(userName);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public ResponseObject getuserwithdeparment(String userEmail) {
    ResponseObject responseObject = new ResponseObject();
        User user = userRepository.findByEmailAddress(userEmail);
        Department department =restTemplate.getForObject("http://localhost:8080/api/v1/departments/"+user.getDepartmentId(),Department.class);
        responseObject.setUser(user);
        responseObject.setDepartment(department);
        return   responseObject;
    }
}

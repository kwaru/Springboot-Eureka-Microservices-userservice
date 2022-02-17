package com.moreece.userservice.Service;

import com.moreece.userservice.Entity.User;

import java.util.List;

public interface UserServiceInterface {

    User createUser( User user);
    User getUser( String userName);
    List<User> getUsers();
}

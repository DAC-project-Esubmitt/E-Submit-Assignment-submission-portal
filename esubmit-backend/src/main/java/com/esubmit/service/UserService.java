package com.esubmit.service;

import java.util.List;

import com.esubmit.entity.User;

public interface UserService {
    User findByUsername(String username);

    void setToken(User user, String token);



    String getToken(User user);
    User registerUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}

package com.example.tospringboot.service;



import com.example.tospringboot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUser(int id);
    void deleteUser(int id);
    void updateUser(User user);
}

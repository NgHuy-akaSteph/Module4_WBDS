package com.example.dev.service;

import com.example.dev.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    boolean save(User user);

    boolean deleteById(int id);

}

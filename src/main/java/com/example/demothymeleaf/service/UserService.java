package com.example.demothymeleaf.service;


import com.example.demothymeleaf.entities.User;


import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    int generateId();

}

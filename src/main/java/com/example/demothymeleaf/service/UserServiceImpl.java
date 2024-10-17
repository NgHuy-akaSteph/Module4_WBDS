package com.example.demothymeleaf.service;

import com.example.demothymeleaf.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final static Map<Integer, User> users;
    static {
        users = new HashMap<>();
        users.put(1, new User(1, "Nguyễn Văn A", true, "anv@codegym.com", "123456", "Hà Nội"));
        users.put(2, new User(2, "Nguyễn Văn B", true, "bnv@codegym.com", "123456", "Hồ Chí Minh"));
        users.put(3, new User(3, "Nguyễn Văn C", true, "cnv@codegym.com", "123456", "Đà Nẵng"));
        users.put(4, new User(4, "Nguyễn Văn D", true, "dnv@codegym.com", "123456", "Đà Nẵng"));
        users.put(5, new User(5, "Nguyễn Văn E", true, "env@codegym.com", "123456", "Hà Nội"));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void deleteById(int id) {
        users.remove(id);
    }

    @Override
    public int generateId() {
        return users.get(users.size()).getId() + 1;
    }


}

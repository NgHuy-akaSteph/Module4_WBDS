package com.example.dev.service;

import com.example.dev.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        String query = "from User as u";
        TypedQuery<User> userTypedQuery = entityManager.createQuery(query, User.class);
        return userTypedQuery.getResultList();
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public boolean save(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean deleteById(int id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
            return true;
        }
        return false;
    }
}
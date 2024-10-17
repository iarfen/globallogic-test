package com.globalLogicTest.services;

import com.globalLogicTest.model.User;
import com.globalLogicTest.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        usersDAO.findAll().forEach(users::add);

        return users;
    }
}
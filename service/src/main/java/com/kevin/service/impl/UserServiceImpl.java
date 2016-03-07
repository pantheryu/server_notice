package com.kevin.service.impl;

import com.kevin.dao.UserDAO;
import com.kevin.model.User;
import com.kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by spirit on 2015/10/2.
 * this is just a test demo
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private User user;

    public int insertUser(User user) {
        // TODO Auto-generated method stub
        return userDAO.insertUser(user);
    }

    public List<User> findUser() {
        return userDAO.finduserById();
    }
}

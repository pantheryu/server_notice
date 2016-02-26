package com.kevin.dao;

import com.kevin.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by spirit on 2015/10/2.
 */

public interface UserDAO {
    /**
     *
     * @param user
     * @return
     */
    public int insertUser(User user);
    public List<User> finduserById();
}

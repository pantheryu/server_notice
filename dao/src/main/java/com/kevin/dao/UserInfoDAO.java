package com.kevin.dao;

import com.kevin.model.UserInfo;

/**
 * Created by spirit on 2016/2/24.
 */
public interface UserInfoDAO {
    public int insertUserInfo(UserInfo userInfo);
    public int updateUserInfo(UserInfo userInfo);
    public int deleteUserInfo(UserInfo userInfo);
    public UserInfo selectUserInfo(int id);
}

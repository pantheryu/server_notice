package com.kevin.service.impl;

import com.kevin.dao.ClubInfoDAO;
import com.kevin.dao.UserInfoDAO;
import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.ClubInfo;
import com.kevin.model.user.UserJoinedGroup;
import com.kevin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spirit on 2016/3/7.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;
    @Autowired
    private ClubInfoDAO clubInfoDAO;


    public List<ClubInfo> queryUserJoined(int userId) {
//        UserJoinedGroup userJoined = userInfoDAO.getUserJoined(userId);
//        return userJoined.getClubInfoList();
//        return userInfoDAO.getUserJoined(userId);
//        return  userInfoDAO.selectClubs(userId);
        List<Integer> list = userInfoDAO.getUserJoinedId(userId);
        List<ClubInfo> clubInfoList = new ArrayList<ClubInfo>();
        for (int i:list){
            clubInfoList.add(clubInfoDAO.selectClub(i));
        }
        return clubInfoList;
    }
}

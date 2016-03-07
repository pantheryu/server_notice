package com.kevin.service;

import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.ClubInfo;

import java.util.List;

/**
 * Created by spirit on 2016/3/7.
 */
public interface UserInfoService {
    public List<ClubInfo> queryUserJoined(int userId);
}

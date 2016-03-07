package com.kevin.dao;

import com.kevin.model.info.ClubInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by spirit on 2016/3/7.
 */
public interface ClubInfoDAO {
    public ClubInfo selectClub(@Param("clubId") int clubId);
}

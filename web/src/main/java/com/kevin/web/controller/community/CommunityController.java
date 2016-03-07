package com.kevin.web.controller.community;

import com.kevin.framework.common.ResultCode;
import com.kevin.model.BaseNoticeMessage;
import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.ClubInfo;
import com.kevin.model.info.UniversityInfo;
import com.kevin.service.UniversityInfoService;
import com.kevin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by spirit on 2016/3/4.
 */
@Controller
public class CommunityController {

    @Autowired
    private UniversityInfoService universityInfoService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/university_info.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode getUniversityInfo(
            @RequestParam("userId") int userId,
            @RequestParam("universityId") int universityId){
        ResultCode<UniversityInfo> result = new ResultCode();
        UniversityInfo universityInfo = universityInfoService.getUniversityInfo(universityId);
        result.setData(universityInfo);
        return result;
    }


    @RequestMapping(value = "/user_joined_group.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode getJoinedGroup(@RequestParam("userId") int userId){

        ResultCode<List<ClubInfo>> result = new ResultCode();
        List<ClubInfo> list = userInfoService.queryUserJoined(userId);
        result.setData(list);
        return result;
    }

}

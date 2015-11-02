package com.kevin.web.controller;

import com.kevin.framework.common.resultCode;
import com.kevin.model.CallboradMessage;
import com.kevin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by spirit on 2015/9/30.
 */
@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring3 MVC");
        SimpleDateFormat dateFormat = new SimpleDateFormat("asdasd");
        model.addAttribute("date", dateFormat.format(new java.util.Date()));
        return "success";
    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public @ResponseBody resultCode returnValue(){
        resultCode<List<CallboradMessage>> result = new resultCode();
//        User user = new User();
//        user.setId(1);
//        user.setNickname("spring");
//        user.setState(5);
        List<CallboradMessage> list = new ArrayList<CallboradMessage>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        CallboradMessage callboardMessage1 = new CallboradMessage();
        callboardMessage1.setCategoryId("study");
        callboardMessage1.setDate("2015/10/23");
        callboardMessage1.setDetail("content1");
        callboardMessage1.setTitle("title1");
        callboardMessage1.setPlace("place1");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2015, 11, 2, 13, 59);
        callboardMessage1.setDate(sdf.format(calendar1.getTime()));
        callboardMessage1.setUp(10);
        callboardMessage1.setDown(13);
        list.add(callboardMessage1);

        CallboradMessage callboardMessage2 = new CallboradMessage();
        callboardMessage2.setCategoryId("study");
        callboardMessage2.setDate("2015/10/23");
        callboardMessage2.setDetail("content1");
        callboardMessage2.setTitle("title1");
        callboardMessage2.setPlace("place1");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2015, 11, 2, 13, 59);
        callboardMessage2.setDate(sdf.format(calendar2.getTime()));
        callboardMessage2.setUp(10);
        callboardMessage2.setDown(13);
        list.add(callboardMessage2);

        result.setData(list);
        return result;
    }
}

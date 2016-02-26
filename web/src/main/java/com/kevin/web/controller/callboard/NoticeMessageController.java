package com.kevin.web.controller.callboard;

import com.kevin.framework.common.ResultCode;
import com.kevin.model.BaseNoticeMessage;
import com.kevin.service.impl.BaseNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.RescaleOp;
import java.util.Date;
import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */

@Controller
public class NoticeMessageController {
    @Autowired
    private BaseNoticeServiceImpl baseNoticeService;

    @Autowired
    private BaseNoticeMessage baseNoticeMessage;

    /*
    * 返回notice_message
    * */
    @RequestMapping(value = "/notice_message.json",method = RequestMethod.GET)
    public @ResponseBody ResultCode getBaseNoticeMessage(
            @RequestParam("userId") int userId,
            @RequestParam("pageNum") int pageNum,
            @RequestParam("categoryId") int categoryId
    ){
        ResultCode<List<BaseNoticeMessage>> result = new ResultCode();
        List<BaseNoticeMessage> baseNoticeMessages = baseNoticeService.getNoticeMessage(userId,pageNum,categoryId);
        result.setData(baseNoticeMessages);
        return result;
    }

    /*
    * 插入notice_message
    * */
    @RequestMapping(value = "/post_notice_message",method = RequestMethod.POST)
    public @ResponseBody ResultCode pushBaseNoticeMessage(
            @RequestParam("msgId") int msgId,
            @RequestParam("userId") int userId,
            @RequestParam("title") String title,
            @RequestParam("dedail") String dedail,
            @RequestParam("date") long date,
            @RequestParam("place") String place,
            @RequestParam("categoryId") int categoryId,
            @RequestParam("up") int up,
            @RequestParam("down") int down,
            @RequestParam("desId") int desId,
            @RequestParam("send_date") long sendDate
    ){
        ResultCode result = new ResultCode();
        baseNoticeMessage.setMsgId(msgId);
        baseNoticeMessage.setUserId(userId);
        baseNoticeMessage.setTitle(title);
        baseNoticeMessage.setDate(new Date(date));
        baseNoticeMessage.setDetail(dedail);
        baseNoticeMessage.setPlace(place);
        baseNoticeMessage.setCategoryId(categoryId);
        baseNoticeMessage.setUp(up);
        baseNoticeMessage.setDown(down);
        baseNoticeMessage.setDesId(desId);
        baseNoticeMessage.setSendDate(new Date(sendDate));
        int ret = baseNoticeService.insertNoticeMessage(baseNoticeMessage);
        result.setErrCode(ret);
        return result;
    }

    /*
    * 返回notice_message
    * */
    @RequestMapping(value = "/update_notice_message",method = RequestMethod.GET)
    public @ResponseBody ResultCode updateBaseNoticeMessage(
            @RequestParam("msgId") int msgId,
            @RequestParam("praise") int praise
    ){
        ResultCode result = new ResultCode();
        int ret = baseNoticeService.updateNoticeMessage(praise,msgId);
        result.setErrCode(ret);
        return result;
    }
}

package com.kevin.service.impl;

import com.kevin.dao.NoticeMessageDAO;
import com.kevin.model.BaseNoticeMessage;
import com.kevin.service.BaseNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */
@Service
public class BaseNoticeServiceImpl implements BaseNoticeService {
    private int pageSize = 16;
    private DateFormat df;

    @Autowired
    private NoticeMessageDAO noticeMessageDAO;
    public List<BaseNoticeMessage> getNoticeMessage(int userId, int pageNum, int categoryId) {
        df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        List<BaseNoticeMessage> baseNoticeMessages = noticeMessageDAO.getNoticeMessage(userId,pageNum*pageSize,categoryId);
        for (BaseNoticeMessage b:baseNoticeMessages){

        }
        return baseNoticeMessages;
    }

    public int insertNoticeMessage(BaseNoticeMessage baseNoticeMessage) {
        return noticeMessageDAO.insertNoticeMessage(baseNoticeMessage);
    }

    public int updateNoticeMessage(int praise,int msgId){
        return noticeMessageDAO.updateNoticeMessage(praise,msgId);
    }

}

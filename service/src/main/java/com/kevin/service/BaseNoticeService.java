package com.kevin.service;

import com.kevin.model.BaseNoticeMessage;

import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */
public interface BaseNoticeService {
    public List<BaseNoticeMessage> getNoticeMessage(int userId,int pageNum,int categoryId);
    public int insertNoticeMessage(BaseNoticeMessage baseNoticeMessage);
    public int updateNoticeMessage(int praise,int msgId);
    public int insertNoticePraise(int userId,int msgId);
}

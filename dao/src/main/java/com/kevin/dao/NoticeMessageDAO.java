package com.kevin.dao;

import com.kevin.model.BaseNoticeMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */
public interface NoticeMessageDAO {
    public List<BaseNoticeMessage> getNoticeMessage(@Param("userId") int userId, @Param("pageNum")int pageNum, @Param("categoryId") int categoryId);
    public int insertNoticeMessage(BaseNoticeMessage baseNoticeMessage);
    public int updateNoticeMessage(@Param("praise") int praise,@Param("msgId") int msgId);
}

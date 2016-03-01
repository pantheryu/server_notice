package com.kevin.dao;

import com.kevin.model.BaseNoticeMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */
public interface NoticeMessageDAO {
    public List<BaseNoticeMessage> getNoticeMessage(@Param("areaId") int areaId, @Param("pageNum")int pageNum, @Param("categoryId") int categoryId);
    public int insertNoticeMessage(BaseNoticeMessage baseNoticeMessage);
    public int updateNoticeMessage(@Param("praise") int praise,@Param("msgId") int msgId);
    public String selectUserInfo(@Param("userId") int userId);
    public String selectCategoryName(@Param("categoryId") int categoryId);
    public boolean selectVoted(@Param("userId") int userId,@Param("msgId") int msgId);
    public int insertNoticePraise(@Param("userId") int userId,@Param("msgId") int msgId);
}

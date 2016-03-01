package com.kevin.model;

import com.kevin.model.utils.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by spirit on 2015/11/2.
 */
@Component
public class BaseNoticeMessage {
    private int msgId;
    private int userId;
    //发送者名字
    private String userName;
    //接收消息的区域
    private int desId;
    private Date sendDate;
    private String title;
    private String detail;
    private Date date;
    private String place;
    private int categoryId;
    //返回类别名字
    private String categoryName;
    private int up,down;
    private boolean voted;

    public boolean isVoted() {
        return voted;
    }

    public void setIsVoted(boolean isVoted) {
        this.voted = isVoted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDesId() {
        return desId;
    }

    public void setDesId(int desId) {
        this.desId = desId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void increase(){
        this.up++;
    }

    public void decrease(){
        this.down++;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

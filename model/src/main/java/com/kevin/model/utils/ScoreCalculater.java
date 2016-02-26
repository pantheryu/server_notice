package com.kevin.model.utils;

import com.kevin.model.BaseNoticeMessage;

import java.util.Date;

/**
 * Created by spirit on 2016/2/24.
 */
public class ScoreCalculater {
    public static double getScore(BaseNoticeMessage baseNoticeMessage,Date today){
        double score = (baseNoticeMessage.getUp()-baseNoticeMessage.getDown() * 0.3)
                /(getDays(today,baseNoticeMessage.getSendDate()) / getDays(baseNoticeMessage.getDate(),baseNoticeMessage.getSendDate()));
        return score;
    }

    public static int getDays(Date begin,Date end){
        int day = (end.getMonth() - begin.getMonth()) * 30 + (end.getDay() - begin.getDay());
        return day;
    }
}

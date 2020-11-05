package com.bot.analyze.dto;

public interface UserInfo {

    String getUserName();
    String getUserId();
    String getLocale();
    Long getChatId();
    SourceEnum getSource();
    UserStatusEnum getNewStatus();
}

package com.bot.analyze.telegram.dto;

import org.telegram.telegrambots.meta.api.objects.User;

public class TelegramUser extends User implements UserInfo  {

    private UserStatusEnum status;
    private String userName;
    private String userId;
    private String locale;
    private Long chatId;

    @Override
    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public Long getChatId() {
        return chatId;
    }

    @Override
    public SourceEnum getSource() {
        return SourceEnum.TELEGRAM;
    }

    @Override
    public UserStatusEnum getNewStatus() {
        return this.status;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public void setStatus(UserStatusEnum statusEnum){
        this.status = statusEnum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(Integer userId) {
        this.userId = String.valueOf(userId);
    }
}

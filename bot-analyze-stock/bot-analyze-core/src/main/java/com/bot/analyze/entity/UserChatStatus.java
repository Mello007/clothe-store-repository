package com.bot.analyze.entity;


import com.bot.analyze.dto.UserStatusEnum;

import javax.persistence.*;

@Entity
@Table(name="user_chat_status")
public class UserChatStatus extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private UserStatusEnum status;

    /**
     * It's an message between two statuses.
     * For example:
     * user writes a sub which he wants to edit or delete - first service
     * the user writes a number of operation to invoke - second service
     *
     * And here second service should know which sub exactly should be edited or deleted,
     * that is why first service set game name in statusMessage and second service read this message
     */
    @Column
    private String statusMessage;

    @OneToOne
    @JoinColumn(name = "bot_user_id", nullable = false)
    private BotUser botUser;

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public BotUser getBotUser() {
        return botUser;
    }

    public void setBotUser(BotUser botUser) {
        this.botUser = botUser;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }
}

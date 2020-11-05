package com.bot.analyze.entity;

import com.bot.analyze.dto.LocalizationEnum;
import com.bot.analyze.dto.SourceEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bot_user")
public class BotUser extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private Long chatId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocalizationEnum localization = LocalizationEnum.EN;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SourceEnum source;

    @OneToOne(mappedBy = "botUser")
    private UserChatStatus chatStatus;

    @Column
    private String name;

    @Column
    private String userCurrency;

    @OneToMany(fetch = FetchType.LAZY)
    List<StockOrder> stockOrders = new ArrayList<>();

    public List<StockOrder> getStockOrders() {
        return stockOrders;
    }

    public void setStockOrders(List<StockOrder> stockOrders) {
        this.stockOrders = stockOrders;
    }

    public LocalizationEnum getLocalization() {
        return localization;
    }

    public void setLocalization(LocalizationEnum localization) {
        this.localization = localization;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUserCurrency() {
        return userCurrency;
    }

    public void setUserCurrency(String userCurrency) {
        this.userCurrency = userCurrency;
    }

    public void setChatStatus(UserChatStatus chatStatus) {
        this.chatStatus = chatStatus;
    }

    public String getName() {
        return name;
    }

    public UserChatStatus getChatStatus() {
        return chatStatus;
    }

    public SourceEnum getSource() {
        return source;
    }

    public void setSource(SourceEnum source) {
        this.source = source;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.bot.analyze.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Info about buying stocks
 */
@Entity
@Table(name="stock_order")
public class StockOrder extends BaseEntity{

    @OneToOne(mappedBy = "stockOrder")
    private StockInfo stockInfo;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyingDate;

    @Column(nullable = false)
    private Integer count = 1;

    @ManyToOne
    @JoinColumn(name = "bot_user_id")
    private BotUser botUser;

    public StockInfo getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(StockInfo stockInfo) {
        this.stockInfo = stockInfo;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BotUser getBotUser() {
        return botUser;
    }

    public void setBotUser(BotUser botUser) {
        this.botUser = botUser;
    }
}

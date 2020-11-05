package com.bot.analyze.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Service
public class TelegramBotInitializer implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private StockAnalyzingBot stockAnalyzingBot;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(stockAnalyzingBot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}

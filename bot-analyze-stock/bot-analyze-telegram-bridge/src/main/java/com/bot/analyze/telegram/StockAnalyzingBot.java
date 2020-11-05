package com.bot.analyze.telegram;

import com.bot.analyze.telegram.command.HelpCommand;
import com.bot.analyze.telegram.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

@Service
public class StockAnalyzingBot extends TelegramLongPollingCommandBot {

    private static final Logger logger = LoggerFactory.getLogger(StockAnalyzingBot.class);

    @Autowired
    public StockAnalyzingBot() {
        registerCommandsForBot();
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                UserInfo telegramUser = userInfoConverter.convertToUserInfo(message.getFrom(), message.getChatId());
                Optional<String> response = chatProcessingService.createResponseForUser(telegramUser, message.getText());
                SendMessage echoMessage = new SendMessage();
                echoMessage.enableHtml(true);
                echoMessage.setChatId(message.getChatId());
                echoMessage.setText(response.get());
                try {
                    execute(echoMessage);
                } catch (TelegramApiException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    private void registerCommandsForBot() {
        HelpCommand helpCommand = new HelpCommand(this, localizationService, userInfoConverter);
        register(helpCommand);
        register(subscribeToPriceCommand);
        register(seeMySubscriptionsCommand);
        register(exitCommand);
        register(searchGameCommand);
        register(startCommand);
        registerDefaultResponseForUnknownCommand(helpCommand);
    }

    private void registerDefaultResponseForUnknownCommand(HelpCommand helpCommand) {
        registerDefaultAction((absSender, message) -> {
            UserInfo userInfo = userInfoConverter.convertToUserInfo(message.getFrom(), message.getChatId());
            SendMessage commandUnknownMessage = new SendMessage();
            commandUnknownMessage.setChatId(message.getChatId());
            commandUnknownMessage.setText(localizationService.getLocalizedMessage("unknown.command", userInfo, message.getText()));
            try {
                absSender.execute(commandUnknownMessage);
            } catch (TelegramApiException e) {
                logger.error(e.getMessage());
            }
            helpCommand.execute(absSender, message.getFrom(), message.getChat(), new String[]{});
        });
    }

    @Override
    public String getBotToken() {
        return telegramBotProperties.getBotToken();
    }

    @Override
    public String getBotUsername() {
        return "xboxnow_bot";
    }

}

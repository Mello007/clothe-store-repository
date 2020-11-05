package com.bot.analyze.telegram.command;

import com.game.bot.dto.TelegramUser;
import com.game.bot.entity.enums.UserStatusEnum;
import com.game.bot.service.ChatProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

public abstract class AbstractCommand extends BotCommand {
    private static final Logger logger = LoggerFactory.getLogger(HelpCommand.class);

    @Autowired
    private ChatProcessingService chatProcessingService;

    public AbstractCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setStatus(getSupportedStatus());
        telegramUser.setUserName(user.getUserName());
        telegramUser.setUserId(user.getId());
        telegramUser.setChatId(chat.getId());
        telegramUser.setLocale(user.getLanguageCode());

        Optional<String> message = chatProcessingService.createResponseForUser(telegramUser, createUserMessageDependsOnParams(strings, telegramUser));
        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.enableHtml(true);
        answer.setText(message.get());
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            logger.error(e.getMessage());
        }
    }

    protected abstract String createUserMessageDependsOnParams(String[] strings, TelegramUser telegramUser);

    protected abstract UserStatusEnum getSupportedStatus();
}

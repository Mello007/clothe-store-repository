package com.bot.analyze.telegram.command;

import com.bot.analyze.telegram.converter.UserInfoConverter;
import com.bot.analyze.telegram.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class StartCommand extends BotCommand {

    private static final Logger logger = LoggerFactory.getLogger(StartCommand.class);

    @Autowired
    private LocalizationService localizationService;
    @Autowired
    private UserInfoConverter userInfoConverter;

    public StartCommand() {
        super("start", "start.working.with.bot");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        UserInfo userInfo = userInfoConverter.convertToUserInfo(user, chat.getId());
        String botDescriptionMessage = localizationService.getLocalizedMessage("bot.description", userInfo);

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.enableHtml(true);
        answer.setText(botDescriptionMessage);
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            logger.error(e.getMessage());
        }
    }
}
package com.bot.analyze.telegram.command;

import com.game.bot.converter.UserInfoConverter;
import com.game.bot.entity.UserInfo;
import com.game.bot.service.localization.LocalizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class HelpCommand extends BotCommand {

    private final ICommandRegistry commandRegistry;
    private final LocalizationService localizationService;
    private final UserInfoConverter userInfoConverter;
    private static final Logger logger = LoggerFactory.getLogger(HelpCommand.class);

    public HelpCommand(ICommandRegistry commandRegistry, LocalizationService localizationService, UserInfoConverter userInfoConverter) {
        super("help", "get.all.commands");
        this.commandRegistry = commandRegistry;
        this.localizationService = localizationService;
        this.userInfoConverter = userInfoConverter;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        UserInfo userInfo = userInfoConverter.convertToUserInfo(user, chat.getId());
        StringBuilder helpMessageBuilder = new StringBuilder("<b>" + localizationService.getLocalizedMessage("help", userInfo) + "</b>\n");
        helpMessageBuilder.append(localizationService.getLocalizedMessage("registered.commands", userInfo) + "\n\n");

        for (IBotCommand botCommand : commandRegistry.getRegisteredCommands()) {
            helpMessageBuilder.append("<b>/" + botCommand.getCommandIdentifier() + "</b>\n" + localizationService.getLocalizedMessage(botCommand.getDescription(), userInfo)).append("\n\n");
        }

        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        helpMessage.setText(helpMessageBuilder.toString());

        try {
            absSender.execute(helpMessage);
        } catch (TelegramApiException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

}
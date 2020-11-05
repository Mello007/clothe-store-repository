package com.bot.analyze.telegram.command;

import com.game.bot.dto.TelegramUser;
import com.game.bot.entity.enums.UserStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class ExitCommand extends AbstractCommand {

    public ExitCommand() {
        super("/exit", "exit.to.initial.menu");
    }

    @Override
    protected String createUserMessageDependsOnParams(String[] strings, TelegramUser telegramUser) {
        return null;
    }

    @Override
    protected UserStatusEnum getSupportedStatus() {
        return UserStatusEnum.EXIT;
    }
}

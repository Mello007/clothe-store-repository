package com.bot.analyze.telegram.converter;

import com.bot.analyze.telegram.dto.TelegramUser;
import com.bot.analyze.telegram.dto.UserInfo;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;

@Service
public class UserInfoConverter {

    public UserInfo convertToUserInfo(User user, Long chatId){
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setUserName(user.getUserName());
        telegramUser.setUserId(user.getId());
        telegramUser.setLocale(user.getLanguageCode());
        return telegramUser;
    }
}

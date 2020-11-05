package com.bot.analyze.service.localization;

import com.bot.analyze.configuration.UTF8Control;
import com.bot.analyze.dto.LocalizationEnum;
import com.bot.analyze.dto.UserInfo;
import com.bot.analyze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class LocalizationService {

    @Autowired
    private UserService userService;
    @Autowired
    private UTF8Control utf8Control;

    public String getLocalizedMessage(String key, LocalizationEnum language, Object... arguments){
        return getTranslatedWord(key, language.getLocalization(), arguments);
    }

    public String getLocalizedMessage(String key, UserInfo userInfo, Object... arguments){
        if (userInfo.getLocale() != null){
            return getTranslatedWord(key, userInfo.getLocale(), arguments);
        } else {
            String userLocale = userService.getUserLocale(userInfo);
            return getTranslatedWord(key, userLocale, arguments);
        }
    }

    private String getTranslatedWord(String key, String userLocale, Object[] arguments) {
        Locale locale = new Locale(userLocale);
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale, utf8Control);
        String value = messages.getString(key);
        return MessageFormat.format(value, arguments);
    }
}

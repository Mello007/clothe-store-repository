package com.bot.analyze.service.statuses.chatting;

import com.bot.analyze.dto.UserInfo;
import com.bot.analyze.dto.UserStatusEnum;
import com.bot.analyze.service.localization.LocalizationService;
import com.bot.analyze.service.statuses.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JustChattingService implements StatusService {

    @Autowired
    private LocalizationService localizationService;

    @Override
    public UserStatusEnum getSupportedStatus() {
        return UserStatusEnum.JUST_CHATTING;
    }

    @Override
    public String getResponse(UserInfo userInfo, String userMessage) {
        return localizationService.getLocalizedMessage(LETS_DO_SOMETHING, userInfo);
    }
}

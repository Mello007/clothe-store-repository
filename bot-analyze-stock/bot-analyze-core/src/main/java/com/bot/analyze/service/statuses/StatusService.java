package com.bot.analyze.service.statuses;

import com.bot.analyze.dto.UserInfo;
import com.bot.analyze.dto.UserStatusEnum;

public interface StatusService {

    UserStatusEnum getSupportedStatus();

    String getResponse(UserInfo userInfo, String userMessage);
}
